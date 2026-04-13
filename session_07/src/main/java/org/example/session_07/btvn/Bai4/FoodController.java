package org.example.session_07.btvn.Bai4;

import org.example.session_07.btvn.Bai3.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/bai4/merchant/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();

    private static final String UPLOAD_PATH = "C:/RikkeiFood_Temp/";

    @PostMapping("/add")
    public String processAddFood(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile file,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (price < 0) {
            model.addAttribute("error", "Giá tiền không được âm!");
            return "food-add";
        }

        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn hình ảnh món ăn!");
            return "food-add";
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            model.addAttribute("error", "Chỉ chấp nhận file định dạng ảnh (jpg, png, jpeg)!");
            return "food-add";
        }

        try {
            // 2. Xử lý tránh ghi đè: Sinh tên file duy nhất bằng UUID
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + extension;

            // 3. Lưu file vật lý
            File destination = new File("C:/RikkeiFood_Temp/" + uniqueFileName);
            if (!destination.getParentFile().exists()) destination.getParentFile().mkdirs();
            file.transferTo(destination);

            // 4. Tạo đối tượng và lưu vào List tạm
            Food newFood = new Food(name, category, price, uniqueFileName);
            foodList.add(newFood);

            // 5. Dùng RedirectAttributes để truyền dữ liệu sang trang chi tiết
            // flashAttribute sẽ tự xóa sau khi dùng xong (tránh lặp lại khi F5)
            redirectAttributes.addFlashAttribute("food", newFood);
            redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công!");

            return "redirect:/merchant/food/detail";

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contentType;
    }

    @GetMapping("/detail")
    public String showDetail() {
        // Model sẽ tự động nhận được object "food" từ FlashAttributes của PostMapping
        return "food-detail";
    }
}
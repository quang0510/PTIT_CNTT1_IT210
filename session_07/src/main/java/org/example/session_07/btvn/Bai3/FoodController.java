package org.example.session_07.btvn.Bai3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bai3/merchant/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();

    private static final String UPLOAD_PATH = "C:/RikkeiFood_Temp/";

    @PostMapping("/add")
    public String processAddFood(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile file,
            Model model) {

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
            File folder = new File(UPLOAD_PATH);
            if (!folder.exists()) folder.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File destination = new File(UPLOAD_PATH + fileName);
            file.transferTo(destination);

            Food newFood = new Food(name, category, price, fileName);
            foodList.add(newFood);

            System.out.println("=== ĐÃ THÊM MÓN ĂN MỚI ===");
            System.out.println("Tên món: " + newFood.getName());
            System.out.println("Danh mục: " + newFood.getCategory());
            System.out.println("Giá: " + newFood.getPrice());
            System.out.println("File lưu tại: " + destination.getAbsolutePath());
            System.out.println("Tổng số món hiện có: " + foodList.size());

            return "redirect:/merchant/food/list";

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi trong quá trình lưu file!");
        }
        return contentType;
    }
}
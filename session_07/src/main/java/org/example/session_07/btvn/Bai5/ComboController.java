package org.example.session_07.btvn.Bai5;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/merchant/combo")
public class ComboController {

    private static List<Combo> comboList = new ArrayList<>();

    @PostMapping("/add")
    public String saveCombo(
            @RequestParam("comboName") String comboName,
            @RequestParam(value = "itemList", required = false) List<String> itemList,
            @RequestParam("banner") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        // 1. Kiểm tra nghiệp vụ: Ít nhất 2 món
        if (itemList == null || itemList.size() < 2) {
            redirectAttributes.addFlashAttribute("error", "Siêu Combo phải có ít nhất 2 món ăn!");
            return "redirect:/merchant/combo/add";
        }

        // 2. Xử lý lưu file banner
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // 3. Lưu vào danh sách tạm
        Combo newCombo = new Combo(comboName, itemList, fileName);
        comboList.add(newCombo);

        // 4. In kết quả
        System.out.println("=== NEW COMBO ADDED ===");
        System.out.println("{");
        System.out.println("  \"comboName\": \"" + comboName + "\",");
        System.out.println("  \"items\": " + itemList.toString() + ",");
        System.out.println("  \"banner\": \"" + fileName + "\"");
        System.out.println("}");

        return "redirect:/merchant/combo/success";
    }
}
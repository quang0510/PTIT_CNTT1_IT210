package org.example.session_07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    // hiển thị form
    // URL: http://localhost:8080/upload/view-form
    @GetMapping("/view-form")
    public String viewForm() {
        return "form-upload";
    }

    // gửi được form lên
    @PostMapping
    public String handleUpload(
            @RequestParam(name = "file") MultipartFile file,
            Model model
    ) {
        String path = "D:\\RIKKEI\\HN-K24-CNTT1\\ss07\\src\\main\\webapp\\images\\";

        if (file.isEmpty()) {
            model.addAttribute("error", "File không tồn tại");
            return "result";
        }

        String fileName = file.getOriginalFilename();

        File insertFile = new File(path + fileName);

        try {
            file.transferTo(insertFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("fileName", fileName);

        return "result";
    }

}
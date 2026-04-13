package org.example.session_07.btvn.Bai5;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleMaxSizeException(Exception e, RedirectAttributes redirectAttributes) {
        // Kiểm tra nếu lỗi liên quan đến dung lượng file
        if (e.getMessage() != null && e.getMessage().contains("exceeds maximum size")) {
            redirectAttributes.addFlashAttribute("error", "File quá lớn! Dung lượng banner tối đa là 10MB.");
            return "redirect:/merchant/combo/add";
        }
        return "error";
    }
}
package org.example.session_07.controller;

import org.example.session_07.model.Gender;
import org.example.session_07.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class StudentController {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1L, "Nguyễn Nhật Minh", 19, Gender.FEMALE),
                    new Student(2L, "Quách Văn Sơn Bách", 19, Gender.MALE),
                    new Student(3L, "Atmin Trần", 19, Gender.OTHER)
            )
    );

    @GetMapping
    public String home(Model model) {
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/handle-add")
    public String handleAdd(
//            @RequestParam(name = "id") Long id,
//            @RequestParam(name = "fullName") String fullName,
//            @RequestParam(name = "age") Integer age,
//            @RequestParam(name = "gender") Gender gender
            @ModelAttribute(name = "student") Student student
    ) {
        students.add(student);
        return "redirect:/";
    }

    // Wrapper Class
    // Những kiểu dữ liệu nguyên thuỷ -> Đối tượng
    // VD: int --> Integer, long -> Long
    @GetMapping("/view-edit/{id}")
    public String viewEdit(
            @PathVariable(name = "id") Long editId,
            Model model
    ) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(editId))
                .findFirst()
                .orElse(null);

        model.addAttribute("student", student);
        return "form";
    }

}
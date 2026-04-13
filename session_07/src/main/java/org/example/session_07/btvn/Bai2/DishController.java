package org.example.session_07.btvn.Bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

class Dish{
    private String name;
    private String category;

    public Dish(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    @ModelAttribute("categories")
    public List<String> populateCategories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    //  thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    // chỉnh sửa
    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    // tìm kiếm
    @GetMapping("/search")
    public String showSearchPage() {
        return "dish-search";
    }
}
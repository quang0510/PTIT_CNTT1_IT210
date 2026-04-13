package org.example.session_07.btvn.Bai3;

public class Food {
    private String name;
    private String category;
    private double price;
    private String imageUrl;

    public Food() {}

    public Food(String name, String category, double price, String imageUrl) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
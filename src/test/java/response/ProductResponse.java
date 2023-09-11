package response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBasketDiscount() {
        return isBasketDiscount;
    }

    public void setisBasketDiscount(boolean isBasketDiscount) {
        isBasketDiscount = isBasketDiscount;
    }

    public int getBasketDiscountPercentage() {
        return basketDiscountPercentage;
    }

    public void setBasketDiscountPercentage(int basketDiscountPercentage) {
        this.basketDiscountPercentage = basketDiscountPercentage;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setisActive(boolean isActive) {
        isActive = isActive;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    private int id;
    private String title;
    private String description;
    private int price;
    private boolean isBasketDiscount;
    private int basketDiscountPercentage;
    private float rating;
    private int stock;
    private boolean isActive;
    private String brand;
    private String category;
    private List<String> images;

}

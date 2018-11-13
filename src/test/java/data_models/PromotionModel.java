package data_models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PromotionModel {

    @JsonProperty
    private int Id;
    @JsonProperty
    private String Name;
    @JsonProperty
    private String Description;
    @JsonProperty
    private double Price;
    @JsonProperty
    private double OriginalPrice;
    @JsonProperty
    private boolean Recommended;
    @JsonProperty
    private int MinimumPhotoCount;

    public PromotionModel(int id, String name, String description, double price, double originalPrice, boolean recommended, int minimumPhotoCount) {
        super();
        Id = id;
        Name = name;
        Description = description;
        Price = price;
        OriginalPrice = originalPrice;
        Recommended = recommended;
        MinimumPhotoCount = minimumPhotoCount;
    }

    public PromotionModel()
    {}

    public String getName() {
        return Name;
    }

    public String getDescription() { return Description; }
}

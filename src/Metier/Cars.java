package Metier;

public class Cars {
    private String brand;
    private String model;
    public Cars(){

    }
    public Cars(String brand, String model) {
        this.setBrand(brand);
        this.setModel(model);
    }
    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }


    @Override public String toString()
    {
        return this.getBrand() + " " + this.getModel() ;
    }
}

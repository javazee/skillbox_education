package core;

public class Car
{
    private String number;
    private int height;
    private double weight;
    private boolean hasVehicle;
    private boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
    public void setNumber (String number){
        this.number = number;
    }
    public String getNumber() {
        return number;
    }
    public void setHeight (int height){
        this.height = height;
    }
    public Integer getHeight() {
        return height;
    }
    public void setWeight (double weight) {
        this.weight = weight;
    }
    public Double getWeight() {
        return weight;
    }
    public void hasVehicle (boolean hasVehicle) {
        this.hasVehicle = hasVehicle;
    }
    public Boolean hasVehicle() {
        return hasVehicle;
    }
    public void isSpecial (boolean isSpecial) {
        this.isSpecial = isSpecial;
    }
    public Boolean isSpecial() {
        return isSpecial;
    }

}
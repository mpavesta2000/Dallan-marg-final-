public class Weapon {
    private String model;
    private int percent;
    private int power;

    public Weapon(String model) {
        this.model = model;
        if(model.equals("sniper")){

            this.percent = 60;
            this.power = 30;

        }else {

            this.percent = 50;
            this.power = 20;

        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

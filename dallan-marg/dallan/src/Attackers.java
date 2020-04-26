public class Attackers {
    private int Health;
    private String name;
    public Attackers(String name){
        this.Health = 100;
        this.name = name;
    }
    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attackers{" +
                "Health=" + Health +
                ", name='" + name + '\'' +
                '}';
    }
}

package Animal;

public class Animal {
    private int ID;
    private String Name;
    private int Speed;
    private int Power;
    private boolean Winner;

    public Animal() {}


    public Animal(int id, String name, int speed, int power) {
        this.ID = id;
        this.Name = name;
        this.Speed = speed;
        this.Power = power;
    }

    public Animal(int ID, String name, int speed, int power, boolean winner) {
        this.ID = ID;
        this.Name = name;
        this.Speed = speed;
        this.Power = power;
        this.Winner = winner;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }

    public boolean isWinner() {
        return Winner;
    }

    public void setWinner(boolean winner) {
        Winner = winner;
    }
}

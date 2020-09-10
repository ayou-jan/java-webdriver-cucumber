package pages;

public class Horse extends Animal {

    public Horse(String name, Double speed) {
        super.name = name;
        this.speed = speed;
    }

    Double speed;

    @Override
    public void speak() {
        System.out.println(classAndName() + "is igogo-ing");
    }

    public void run() {
        System.out.println(classAndName() + " is running with speed somewhere " + speed );
    }
}

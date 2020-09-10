package pages;

public class SpecialDog extends Dog {
    public SpecialDog(String name) {
        super.name = name;
    }

    public void search() {
        System.out.println(classAndName() + " is searching a people...");
    }
}

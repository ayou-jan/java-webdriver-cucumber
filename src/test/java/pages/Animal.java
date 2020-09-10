package pages;

public abstract class Animal {

    protected String name;

    public Animal() {
        this.name = "nameless one";
    }

    public String getName() {
        return "<" + classAndName() + ">";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void walk() {
        System.out.println(classAndName() + " is walking!");
    }

    public void sleep() {
        System.out.println(classAndName() + " is sleeping!");
    }

    public abstract void speak();



    public void eat(String what) {
        System.out.println(classAndName() + " is eating " + what);
    }

    protected String classAndName() {
        String[] arr = getClass().toString().split("\\.");
        return arr[arr.length - 1] + " " + name;
    }

}
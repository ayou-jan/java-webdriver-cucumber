package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.HashMap;
import java.util.Map;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("hello world");
    }

    @And("I say {string}")
    public void iSay(String greetings) {
        System.out.println(greetings);
    }

    @And("I print to console {string} and {string}")
    public void iPrintToConsoleAnd(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }

    @And("I print to console {string} and {string} in UPPERcase")
    public void iPrintToConsoleAndInUPPERcase(String arg0, String arg1) {
        System.out.println(arg0.toUpperCase());
        System.out.println(arg1.toUpperCase());
    }

    @And("I print to console the length of {string} and {string}")
    public void iPrintToConsoleTheLengthOfAnd(String arg0, String arg1) {
        System.out.println(arg0.length());
        System.out.println(arg1.length());
    }

    @And("I compare if {string} and {string} are the same")
    public void iCompareIfAndAreTheSame(String arg0, String arg1) {
        System.out.println(arg0.equals(arg1));
    }

    @And("I compare if {string} and {string} are the same ignoring case")
    public void iCompareIfAndAreTheSameIgnoringCase(String arg0, String arg1) {
        System.out.println(arg0.equalsIgnoreCase(arg1));
    }

    @And("I check if {string} contains a part of {string}")
    public void iCheckIfContainsAPartOf(String arg0, String arg1) {
        System.out.println(arg0.contains(arg1));
    }


    @And("I play with numbers")
    public void iPlayWithNumbers() {

        int a = 5;
        int b = 3;
        float c = 3f;
        System.out.println(a / b);
        System.out.println(a / c);

        int num1 = 12;
        int num2 = 7;
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;

        String color = "red";
        String notFavoriteColor = "notRed";
        System.out.println(color.equals(notFavoriteColor));


    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String arg0) {
        if (arg0.equals("google")) {
            System.out.println("https://www.google.com");
        } else if (arg0.equals("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        } else {
            System.out.println("Unsupported page: " + arg0);
        }


        switch (arg0) {
            case "google":
                System.out.println("https://www.google.com/");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com/");
                break;
            default:
                System.out.println("Unsupported page: " + arg0);
                break;
        }

        int[] groceryList = {2, 6, 8, 123, 4, -9, 0, -12};
        System.out.println(groceryList);
        System.out.println(groceryList[0]);
        System.out.println(groceryList[2]);
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String a) {
        if (a.equals("35")) {
            System.out.println("Number is positive");
        } else if (a.startsWith("-")) {  //second option is "else if (Integer.parseInt(a)<0)"
            System.out.println("Number is negative");
        } else {
            System.out.println("strange symbols");
        }
    }


    @And("I print {string} th day of week")
    public void iPrintThDayOfWeek(String a) {
        switch (a) {
            case "1":
                System.out.println("Monday");
                break;
            case "2":
                System.out.println("Tuesday");
                break;
            case "3":
                System.out.println("Wednesday");
                break;
            case "4":
                System.out.println("Thursday");
                break;
            case "5":
                System.out.println("Friday");
                break;
            case "6":
                System.out.println("Saturday");
                break;
            case "7":
                System.out.println("Sunday");
                break;
            case "8":
                System.out.println("no such a day in a week");
                break;
        }
    }

    @And("I swap the names")
    public void iSwapTheNames() {
        Map<String, String> info = new HashMap<>();
        info.put("firstName","John");
        info.put("middleName","George");
        String temporaryName = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", temporaryName);
        System.out.println(info);

    }
}
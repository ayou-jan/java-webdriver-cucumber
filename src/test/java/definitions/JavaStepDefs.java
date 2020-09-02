package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.Arrays;
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
        info.put("firstName", "John");
        info.put("middleName", "George");
        String temporaryName = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", temporaryName);
        System.out.println(info);

    }

    @Given("array {string}")
    public void array(String array) {
        System.out.println(array);
        String[] arrayForChange = array.split(",");
        arrayForChange[2] = array.split(",")[4];
        arrayForChange[4] = array.split(",")[2];
        for (String i : arrayForChange) {
            System.out.print(i + " ");
        }
    }


    @Given("does {int} divisible by {string}")
    public void doesDivisibleBy(int arg0, String arg1) {

    }

    @Given("does {int} divisible by")
    public void doesDivisibleBy(int a) {
        System.out.println();
        if (a % 3 == 0 && a % 4 != 0) {
            System.out.println("divisible by 3");
        } else if (a % 4 == 0 && a % 3 != 0) {
            System.out.println("divisible by 4");
        } else if (a % 3 == 0 && a % 4 == 0) {
            System.out.println("divisible by 3 and 4");
        }
    }

    @And("I do my homework")
    public void iDoMyHomework() {
        System.out.println("Task 1 && 2:");
        printNumbers(0);
        //System.out.println("Task 3");
        //printInteger();
        //System.out.println("Task 4");
        //printEvenInteger();
        System.out.println("Task 5");
        int[] a = null;
        isEmpty(a);
        int[] b = {1, 2};
        isEmpty(b);
        System.out.println("Task 7");
        FizzBuzz(20);
    }


    void printNumbers(long n) {
        if (n > 0) {
            for (long i = 0; i <= n; i++) {
                System.out.println(i);
            }
        } else if (n < 0) {
            for (long i = 0; i >= n; i--) {
                System.out.println(i);
            }
        } else
            System.out.println(0);
    }

    void printInteger() {
        for (int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
            System.out.println(i);
        }
    }

    void printEvenInteger() {
        for (int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += 2) {
            System.out.println(i);
        }
    }

    boolean isEmpty(int[] a) {
        if (a != null && a.length > 0) {
            System.out.println("array has elements");
            return false;
        } else {
            System.out.println("array is empty");
            return true;
        }
    }


    void FizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    @And("I check where are {int} and {int}")
    public void iCheckWhereAreAnd(int first, int second) {
        whereIsIt(first);
        whereIsIt(second);
    }

    void whereIsIt(int number) {
        if (number % 5 == 0) {
            if (number >= 1 && number <= 10) {
                System.out.println("it is in the range of 1..10");
            }
            if (number >= 11 && number <= 20) {
                System.out.println("it is in the range of 11..20");
            }
        }
    }

    @And("reverse {string} and return every {int}")
    public void reverseAndReturnEvery(String str, int n) {
        String newStr = "";
        for (int i = str.length() - 3; i >= 0; i -= 3) {
            newStr += str.charAt(i);
        }
        System.out.println(newStr);
    }

    @And("I reverse words in row {string}")
    public void iReverseWordsInRow(String str) {
        String reversedRow = "";
        String[] dividedStr = str.split(" ");
        for (int i = dividedStr.length - 1; i >= 0; i--) {
            reversedRow += dividedStr[i] + " ";
        }
        String answer = reversedRow.substring(0, reversedRow.length() - 1); //просто убираем последний пробел
        System.out.println(answer);
    }

    @And("I write two biggest numbers")
    public void iWriteTwoBiggestNumbers() {
        int[] arr1 = {1, 4, 6, -3, -5, 3, 35, -122, 0, 3, 5, 1};
        findTwoBiggest(arr1);
        System.out.println(findDuplicates(arr1));
        System.out.println(isPalindrome("qwertyytrewq"));
        System.out.println(isPalindrome("qwertyytrew"));
        System.out.println(isPalindrome("qwertytrewq"));
        System.out.println(mapOfCharQuantity("Ayriyan"));
    }

    void findTwoBiggest(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 2]);
        System.out.println(arr[arr.length - 1]);
    }

    boolean findDuplicates(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }
        return false;
    }

    boolean isPalindrome(String word) {
        for (int i = 0; i <= word.toCharArray().length / 2; i++) {
            char[] symbols = word.toCharArray();
            if (symbols[i] != symbols[symbols.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    Map<Character, Integer> mapOfCharQuantity(String row) {
        Map<Character, Integer> map = new HashMap<>();
        char[] symbols = row.toCharArray();
        map.put(symbols[0],1);
        for (int i=1; i<symbols.length; i++) {
            if (map.containsKey(symbols[i])) {
                map.put(symbols[i],map.get(symbols[i])+1);
            } else {
                map.put(symbols[i],1);
            }
        }
        return map;
    }
}


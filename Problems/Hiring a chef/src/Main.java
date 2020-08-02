//put imports you need here

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cheff cheff = new Cheff(scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next());
        cheff.sendMessage();
        scanner.close();
    }
}

class Cheff {
    String name;
    int age;
    String stage;
    int yearsOfExperience;
    String cuisinePreference;

    public Cheff(String name, int age, String stage, int yearsOfExperience, String cuisinePreference) {
        this.name = name;
        this.age = age;
        this.stage = stage;
        this.yearsOfExperience = yearsOfExperience;
        this.cuisinePreference = cuisinePreference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCuisinePreference() {
        return cuisinePreference;
    }

    public void setCuisinePreference(String cuisinePreference) {
        this.cuisinePreference = cuisinePreference;
    }

    public void sendMessage() {
        System.out.println("The form for " + name + " is completed. We will contact you if we need a chef that cooks " +
                "" + cuisinePreference + " dishes.");
    }
}
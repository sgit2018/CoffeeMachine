package machine;

import java.util.Scanner;

class InsideCoffeeMachine {
    static int currentMilkQuantity = 540;
    static int currentCoffeeQuantity = 120;
    static int currentWaterQuantity = 400;
    static int currentCupsQuantity = 9;
    static int currentIncome = 550;

    MachineState doWork(String command) {

        String coffeeType;
        String message;
        MachineState machineState = null;
        Scanner scanner = new Scanner(System.in);

        CoffeeSelector:
        switch (command) {
            case "buy":
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: \n");
                coffeeType = scanner.next();

                switch (coffeeType) {
                    case "1":
                        message = new InsideCoffeeMachine().checkResources(currentWaterQuantity, currentCoffeeQuantity,
                                currentMilkQuantity, currentCupsQuantity, 250, 16, 0,
                                1);

                        if (message.equalsIgnoreCase("Enough resources")) {
                            currentWaterQuantity -= 250;
                            currentCoffeeQuantity -= 16;
                            currentCupsQuantity -= 1;
                            currentIncome += 4;
                            System.out.println("I have enough resources, making you a coffee!");
                            machineState = MachineState.MAKING_ESPRESSO;
                        } else {
                            machineState = MachineState.LIMITED_RESOURCES;
                            System.out.println(message);
                        }
                        break CoffeeSelector;
                    case "2":
                        message = new InsideCoffeeMachine().checkResources(currentWaterQuantity, currentCoffeeQuantity,
                                currentMilkQuantity, currentCupsQuantity, 350, 20, 75,
                                1);

                        if (message.equalsIgnoreCase("Enough resources")) {
                            currentWaterQuantity -= 350;
                            currentCoffeeQuantity -= 20;
                            currentMilkQuantity -= 75;
                            currentCupsQuantity -= 1;
                            currentIncome += 7;
                            System.out.println("I have enough resources, making you a coffee!");
                            machineState = MachineState.MAKING_LATTE;
                        } else {
                            machineState = MachineState.LIMITED_RESOURCES;
                            System.out.println(message);
                        }
                        break CoffeeSelector;
                    case "3":
                        message = new InsideCoffeeMachine().checkResources(currentWaterQuantity, currentCoffeeQuantity,
                                currentMilkQuantity, currentCupsQuantity, 200, 12, 100,
                                1);

                        if (message.equalsIgnoreCase("Enough resources")) {
                            currentWaterQuantity -= 200;
                            currentCoffeeQuantity -= 12;
                            currentMilkQuantity -= 100;
                            currentCupsQuantity -= 1;
                            currentIncome += 6;
                            System.out.println("I have enough resources, making you a coffee!");
                            machineState = MachineState.MAKING_CAPPUCCINO;
                        } else {
                            machineState = MachineState.LIMITED_RESOURCES;
                            System.out.println(message);
                        }
                        break CoffeeSelector;
                    case "back":
                        System.out.println("back to main menu");
                        machineState = MachineState.EXIT_COFFEE_MENU;
                        break CoffeeSelector;
                    default:
                        System.out.println("Not a valid coffee type");
                        machineState = MachineState.EXIT_COFFEE_MENU;
                        break CoffeeSelector;
                }
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                int water = scanner.nextInt();
                currentWaterQuantity += water;
                System.out.println("Write how many ml of milk do you want to add:");
                int milk = scanner.nextInt();
                currentMilkQuantity += milk;
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int coffee = scanner.nextInt();
                currentCoffeeQuantity += coffee;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cups = scanner.nextInt();
                currentCupsQuantity += cups;
                machineState = MachineState.FILLING_MACHINE;
                break CoffeeSelector;
            case "take":
                System.out.print("I gave you $" + currentIncome + "\n");
                currentIncome -= currentIncome;
                machineState = MachineState.RETURNING_MONEY;
                break CoffeeSelector;
            case "remaining":
                System.out.println("The Coffee machine has: \n" + currentWaterQuantity + " of water");
                System.out.println(currentMilkQuantity + " of milk");
                System.out.println(currentCoffeeQuantity + " of coffee beans");
                System.out.println(currentCupsQuantity + " of disposable cups");
                System.out.println(currentIncome + " of money \n");
                machineState = MachineState.PRINTING_REMAINING;
                break CoffeeSelector;
            default:
                System.out.println("Exiting the Coffee Machine");
                machineState = (MachineState.EXIT_MACHINE);
                break CoffeeSelector;
        }
        return machineState;
    }

    public String checkResources(int currentWaterQuantity, int currentCoffeeQuantity, int currentMilkQuantity,
                                 int currentCupsQuantity, int requiredWater, int requiredCoffee, int requiredMilk,
                                 int requiredCups) {
        int hasEnough = 0;

        if (currentWaterQuantity - requiredWater < 0) {
            hasEnough = 1;
        }
        if (currentCoffeeQuantity - requiredCoffee < 0) {
            hasEnough = 2;
        }
        if (currentMilkQuantity - requiredMilk < 0) {
            hasEnough = 3;
        }
        if (currentCupsQuantity - requiredCups < 0) {
            hasEnough = 4;
        }

        switch (hasEnough) {
            case 1:
                return "Sorry, not enough water!";
            case 2:
                return "Sorry, not enough coffee!";
            case 3:
                return "Sorry, not enough milk!";
            case 4:
                return "Sorry, not enough cups!";
            default:
                return "Enough resources";
        }
    }
}


public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsideCoffeeMachine coffee = new InsideCoffeeMachine();
        String userAction;
        MachineState status;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            userAction = scanner.next();
            status = coffee.doWork(userAction);
        } while (!status.toString().equalsIgnoreCase("EXIT_MACHINE"));
    }
}

enum MachineState {
    MAKING_ESPRESSO, MAKING_LATTE, MAKING_CAPPUCCINO, LIMITED_RESOURCES, FILLING_MACHINE, RETURNING_MONEY,
    PRINTING_REMAINING, EXIT_COFFEE_MENU, EXIT_MACHINE;
}
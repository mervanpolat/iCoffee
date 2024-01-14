package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);

    private static final int ESPRESSO_WATER_PER_CUP = 250;
    private static final int ESPRESSO_MILK_PER_CUP = 0;
    private static final int ESPRESSO_COFFEE_PER_CUP = 16;
    private static final int ESPRESSO_PRICE = 4;

    private static final int LATTE_WATER_PER_CUP = 350;
    private static final int LATTE_MILK_PER_CUP = 75;
    private static final int LATTE_COFFEE_PER_CUP = 20;
    private static final int LATTE_PRICE = 7;

    private static final int CAPPUCCINO_WATER_PER_CUP = 200;
    private static final int CAPPUCCINO_MILK_PER_CUP = 100;
    private static final int CAPPUCCINO_COFFEE_PER_CUP = 12;
    private static final int CAPPUCCINO_PRICE = 6;

    private int money;
    private int water;
    private int milk;
    private int coffee;
    private int cups;

    public CoffeeMachine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    handleBuyAction();
                    break;
                case "fill":
                    handleFillAction();
                    break;
                case "take":
                    handleTakeAction();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Unexpected action.");
                    break;
            }
        }
    }

    private void printState() {
        System.out.printf("The coffee machine has:\n%d ml of water\n%d ml of milk\n", water, milk);
        System.out.printf("%d g of coffee beans\n%d disposable cups\n$%d of money\n", coffee, cups, money);
    }

    private void handleBuyAction() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
        String choice = scanner.next();
        if ("back".equals(choice)) {
            return;
        }
        int coffeeType = Integer.parseInt(choice);
        switch (coffeeType) {
            case 1:
                makeCoffee(ESPRESSO_WATER_PER_CUP, ESPRESSO_MILK_PER_CUP, ESPRESSO_COFFEE_PER_CUP, ESPRESSO_PRICE);
                break;
            case 2:
                makeCoffee(LATTE_WATER_PER_CUP, LATTE_MILK_PER_CUP, LATTE_COFFEE_PER_CUP, LATTE_PRICE);
                break;
            case 3:
                makeCoffee(CAPPUCCINO_WATER_PER_CUP, CAPPUCCINO_MILK_PER_CUP, CAPPUCCINO_COFFEE_PER_CUP, CAPPUCCINO_PRICE);
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeNeeded, int price) {
        if (hasEnoughResources(waterNeeded, milkNeeded, coffeeNeeded)) {
            water -= waterNeeded;
            milk -= milkNeeded;
            coffee -= coffeeNeeded;
            cups--;
            money += price;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private boolean hasEnoughResources(int waterNeeded, int milkNeeded, int coffeeNeeded) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffee < coffeeNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    private void handleFillAction() {
        System.out.print("Write how many ml of water do you want to add:\n> ");
        water += scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add:\n> ");
        milk += scanner.nextInt();
        System.out.print("Write how many grams of coffee beans do you want to add:\n> ");
        coffee += scanner.nextInt();
        System.out.print("Write how many disposable cups do you want to add:\n> ");
        cups += scanner.nextInt();
    }

    private void handleTakeAction() {
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.start();
    }
}

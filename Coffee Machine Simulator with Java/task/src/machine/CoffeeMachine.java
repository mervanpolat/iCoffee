package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        // I went ahead and divided each step into its own method.
        startMachine();
        grindBeans();
        boilWater();
        mixWaterAndBeans();
        pourCoffee();
        pourMilk();
        serveCoffee();
        calculateCoffeeIngredient();
    }

    private static void calculateCoffeeIngredient(){
        Scanner input = new Scanner(System.in);

        //Getting user input
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = input.nextInt();

        //Creating necessary variables for ingredient calculations
        double sizeOfMilk, sizeOfWater, coffeeBeans;

        //Assigning constant values to the main coffee ingredients
        sizeOfMilk = 50;
        sizeOfWater = 200;
        coffeeBeans = 15;

        //Calculating the coffee ingredients for "n" number of cups
        double calcAmountOfMilk = cups * sizeOfMilk;
        double calcAmountOfCoffeeBean = cups * coffeeBeans;
        double calcAmountOfWater = cups * sizeOfWater;

        //Output
        System.out.println("For " + cups + " cups of coffee you will need: ");
        System.out.println(calcAmountOfWater + " ml of water");
        System.out.println(calcAmountOfMilk + " ml of milk");
        System.out.println(calcAmountOfCoffeeBean + " g of coffee beans");
    }

    private static void startMachine() {
        System.out.println("Starting to make a coffee");
    }
    private static void grindBeans() {
        System.out.println("Grinding coffee beans");
    }

    private static void boilWater() {
        System.out.println("Boiling water");
    }

    private static void mixWaterAndBeans() {
        System.out.println("Mixing boiled water with crushed coffee beans");
    }

    private static void pourCoffee() {
        System.out.println("Pouring coffee into the cup");
    }

    private static void pourMilk() {
        System.out.println("Pouring some milk into the cup");
    }

    private static void serveCoffee() {
        System.out.println("Coffee is ready!");
    }
}

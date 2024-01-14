package machine;
import java.util.Scanner;
import java.lang.Math;

public class CoffeeMachine {
    final static private Scanner s = new Scanner(System.in);
    private static int water = 400, milk = 540, coffee = 120;
    private static int cups = 9, money = 550;

    public static void PrintMachine() {
        System.out.printf("The coffee machine has:\n%d ml of water\n%d ml of milk\n", water, milk);
        System.out.printf("%d g of coffee beans\n%d disposable cups\n%d of money", coffee, cups, money);
    }

    public static void take() {
        System.out.printf("I gave you $%d", money);
        money = 0;
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += s.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += s.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffee += s.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += s.nextInt();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int type = s.nextInt();
        switch (type) {
            case 1:
                water -= 250;
                coffee -= 16;
                money += 4;
                break;
            case 2:
                water -= 350;
                milk -= 75;
                coffee -= 20;
                money += 7;
                break;
            case 3:
                water -= 200;
                milk -= 100;
                coffee -= 12;
                money += 6;
                break;
            default:
                System.out.println("Error!");
                break;
        }
        cups--;
    }

    public static void main(String[] args) {
        PrintMachine();

        System.out.printf("\nWrite action (buy, fill, take):");
        String action = s.next();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            default:
                System.out.println("Error!");
                break;
        }

        System.out.println();
        PrintMachine();
    }
}

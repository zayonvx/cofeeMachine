package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void text (int water, int milk, int beans, int cupsDisposable, int money) {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cupsDisposable + " of disposable cups\n" +
                money + " of money");
    }

    public static void notEnough (String ingredient) {
        System.out.println("Sorry, not enough " + ingredient);
    }

    public static boolean outOfIngredients(int water, int milk, int beans, int cupsDisposable, String buyOption) {

        if (cupsDisposable - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return true;
        } else {
            switch (buyOption) {
                case "1": {
                    if (water - 250 < 0) {
                        notEnough("water!");
                        return true;
                    }
                    if (beans - 16 < 0) {
                        notEnough("coffee beans!");
                        return true;
                    }
                }
                break;
                case "2": {
                    if (water - 350 < 0) {
                        notEnough("water!");
                        return true;
                    }
                    if (milk - 75 < 0) {
                        notEnough("milk!");
                        return true;
                    }
                    if (beans - 20 < 0) {
                        notEnough("coffee beans");
                        return true;
                    }
                }
                break;
                case "3": {
                    if (water - 200 < 0) {
                        notEnough("water!");
                        return true;
                    }
                    if (milk - 100 < 0) {
                        notEnough("milk!");
                        return true;
                    }
                    if (beans - 12 < 0) {
                        notEnough("coffee beans");
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;
        boolean stateOn = true;

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cupsDisposable= 9;
        int money = 550;

        while (stateOn) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            System.out.println(action);

            switch (action) {
                case "buy": {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String buyOption = scanner.nextLine();
                    if (buyOption.equals("1") || buyOption.equals("2") || buyOption.equals("3")) {
                        if (outOfIngredients(water, milk, beans, cupsDisposable, buyOption)) {
                            break;
                        } else {
                            System.out.println("I have enough resources, making you a coffee!");
                        }
                    }

                    switch (buyOption) {
                        case "1": {
                            water -= 250;
                            beans -= 16;
                            cupsDisposable --;
                            money += 4;
                            break;
                        }
                        case "2": {
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            cupsDisposable--;
                            money += 7;
                            break;
                        }
                        case "3": {
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            cupsDisposable--;
                            money += 6;
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    break;
                }

                case "fill": {
                    System.out.println("Write how many ml of water do you want to add: ");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cupsDisposable += scanner.nextInt();
                    break;
                }

                case "take": {
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                }

                case "remaining": {
                    text(water, milk, beans, cupsDisposable, money);
                    break;
                }

                case "exit": {
                    stateOn = false;
                    break;
                }

                default: {
                    break;
                }
            }
        }
    }
}


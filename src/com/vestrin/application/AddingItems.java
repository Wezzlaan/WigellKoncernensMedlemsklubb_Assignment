package com.vestrin.application;

import com.vestrin.entities.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddingItems {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleColors colors = new ConsoleColors();
    public AddingItems(){
    }

    public String brand(){
        System.out.print(colors.applyCyan("\nAnge märke: "));
        return scanner.nextLine().trim();
    }

    public String model(){
        System.out.print(colors.applyCyan("\nAnge modell: "));
        return scanner.nextLine().trim();
    }

    public String price(){
        System.out.print(colors.applyCyan("\nSätt pris (per dag av uthyrning): "));
        double price = 0;
        try {
            price = scanner.nextDouble();
        } catch (InputMismatchException e){
            System.err.println("\nFEL: Input måste vara siffror.");
        }
        scanner.nextLine();
        return Double.toString(price);
    }

    public PC.ComputerType setComputerType() {
        char x = choice("\nAnge datortyp: \n[1] " + PC.ComputerType.DESKTOP + "\n[2] " + PC.ComputerType.LAPTOP);
        return switch (x) {
            case '1' -> PC.ComputerType.DESKTOP;
            case '2' -> PC.ComputerType.LAPTOP;
            default -> throw new InputMismatchException("FEL: '" + x + "' är inget godkänt val.");
        };
    }

    public Keyboard.SwitchType setSwitchType() {
        char x = choice("\nAnge typ av Switch: \n[1] " + Keyboard.SwitchType.MECHANICAL + "\n[2] " + Keyboard.SwitchType.MEMBRANE);
        return switch (x) {
            case '1' -> Keyboard.SwitchType.MECHANICAL;
            case '2' -> Keyboard.SwitchType.MEMBRANE;
            default -> throw new InputMismatchException("FEL: '" + x + "' är inget godkänt val.");
        };
    }

    public Console.ConsoleType setConsoleType() {
        char x = choice("\nAnge typ av konsoll: \n[1] " + Console.ConsoleType.MODERN + "\n[2] " + Console.ConsoleType.RETRO);
        return switch (x) {
            case '1' -> Console.ConsoleType.MODERN;
            case '2' -> Console.ConsoleType.RETRO;
            default -> throw new InputMismatchException("FEL: '" + x + "' är inget godkänt val.");
        };
    }

    public Monitor.ScreenTech setScreenTech() {
        char x = choice(colors.applyCyan("\nAnge skärmteknologi: \n[1] " + Monitor.ScreenTech.TN +
                                        "\n[2] " + Monitor.ScreenTech.IPS +
                                        "\n[3] " + Monitor.ScreenTech.VA +
                                        "\n[4] " + Monitor.ScreenTech.MINI_LED +
                                        "\n[5] " + Monitor.ScreenTech.OLED));
        return switch (x) {
            case '1' -> Monitor.ScreenTech.TN;
            case '2' -> Monitor.ScreenTech.IPS;
            case '3' -> Monitor.ScreenTech.VA;
            case '4' -> Monitor.ScreenTech.MINI_LED;
            case '5' -> Monitor.ScreenTech.OLED;
            default -> throw new InputMismatchException("FEL: '" + x + "' är inget godkänt val.");
        };
    }

    public String setScreenSize(){
        System.out.print(colors.applyCyan("\nAnge skärmstorlek (i tum): "));
        double tmp = 0;
        try {
            tmp = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("FEL: Inmatning måste vara siffror.");
        }
        scanner.nextLine();
        return Double.toString(tmp);
    }

    private char choice (String message) {
        System.out.println(colors.applyCyan(message));
        System.out.print(colors.applyCyan("\nVal: "));
        return scanner.nextLine().charAt(0);
    }
}

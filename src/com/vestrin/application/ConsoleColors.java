package com.vestrin.application;

public class ConsoleColors {

    public final static String RED = "\u001B[31m";
    public final static String RESET = "\u001B[0m";
    public final static String CYAN = "\u001B[36m";
    public final static String GREEN = "\u001B[32m";
    private final static String PURPLE = "\u001B[35m";

    protected ConsoleColors(){
    }
    protected String applyRed(String message){
        return RED + message + RESET;
    }
    protected String applyCyan(String message){
        return CYAN + message + RESET;
    }
    protected String applyGreen(String message){
        return GREEN + message + RESET;
    }
    protected String applyPurple(String message) { return PURPLE + message + RESET; }
}

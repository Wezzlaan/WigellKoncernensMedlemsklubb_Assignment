package com.vestrin.application;

public class ConsoleColors {

    private final String RED = "\u001B[31m";
    private final String RESET = "\u001B[0m";
    private final String CYAN = "\u001B[36m";
    private final String GREEN = "\u001B[32m";
    private final String PURPLE = "\u001B[35m";

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

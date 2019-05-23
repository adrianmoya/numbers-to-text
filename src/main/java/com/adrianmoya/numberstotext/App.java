package com.adrianmoya.numberstotext;

/**
 * Numbers to text. A TDD Exercise
 *
 */
public class App {

    private static final String ONLY_NUMBERS_PATTERN = "^-?[0-9]+$";
    public static void main(String[] args) {

        if(args.length < 1 || args.length > 1) {
            printUsage();
            System.exit(1);
        }

        String input = args[0];
        
        // Is this a valid number? 
        if(input.matches(ONLY_NUMBERS_PATTERN)) {
            String result = NumberToTextConverter.convertNumber(input);
            System.out.println(result);
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Invalid input, please type a valid number. Examples: 23456, -345, 2347658439");
    }
}

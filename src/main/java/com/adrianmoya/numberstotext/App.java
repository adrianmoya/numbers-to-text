package com.adrianmoya.numberstotext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        if(args.length < 1 || args.length > 1) {
            printUsage();
            System.exit(1);
        }
        String input = args[0];
        try {
            // Save check to see if it's a correctly formatted number within possible range
            Long.valueOf(input);
            String result = NumberToTextConverter.convertNumber(input);
            System.out.println(result);
        } catch (NumberFormatException e) {
            printUsage();
        } catch (Exception e) {
            System.out.println("Cannot convert that number");
        }

    }

    private static void printUsage() {
        System.out.println("Invalid input, please type a valid number. Examples: 23456, -345");
    }
}

package com.adrianmoya.numberstotext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String input = args[0];
        try {
            // Save check to see if it's a correctly formatted number
            Integer.valueOf(input);
            
            String result = NumberToTextConverter.convertNumber(input);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please type a valid number. Examples: 23456, -345");
        } catch (Exception e) {
            System.out.println("Cannot convert that number");
        }

    }
}

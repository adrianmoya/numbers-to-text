package com.adrianmoya.numberstotext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Integer number = Integer.valueOf(args[0]);
        } catch (Exception e){
            System.out.println("Invalid input, please type a valid number");
        }
    }
}

package oop.example;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 14 - Tax Calculator
You don’t always need a complex control structure to solve simple problems. Sometimes a program requires an
extra step in one case, but in all other cases there’s nothing to do.

Write a simple program to compute the tax on an order amount. The program should prompt for the order amount
and the state. If the state is “WI,” then the order must be charged 5.5% tax. The program should display the
subtotal, tax, and total for Wisconsin residents but display just the total for non-residents.

Example Output:
What is the order amount? 10
What is the state? WI
The subtotal is $10.00.
The tax is $0.55.
The total is $10.55.

Or

What is the order amount? 10
What is the state? MN
The total is $10.00

Constraints:
Implement this program using only a simple if statement—don’t use an else clause.
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.

Challenges:
Allow the user to enter a state abbreviation in upper, lower, or mixed case.
Also allow the user to enter the state’s full name in upper, lower, or mixed case.
*/

public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        String priceString  = myApp.getPrice();
        double price = myApp.convertStringToDouble(priceString);
        String state = myApp.getState();

        double tax = myApp.calcTax(state, price);
        double total = myApp.calcTotal(price, tax);

        String message = myApp.generateWIMessage(state, price, tax, total);
        System.out.print(message);
    }

    public String getPrice(){
        System.out.print("What is the order amount? ");
        String price = input.nextLine();
        return price;
    }

    public String getState(){
        System.out.print("What is the state? ");
        String quantity = input.nextLine();
        return quantity;
    }

    public double convertStringToDouble(String word){
        return Double.parseDouble(word);
    }

    public double calcTax(String state, double price){
        double tax = 0.0;
        if (state.equals("WI")) {
            tax = price * 0.055;
        }
        return tax;
    }

    public double calcTotal(double subtotal, double tax){
        return (subtotal + tax);
    }

    public String generateWIMessage(String state, double subtotal, double tax, double total){
        String subtotalString = String.format("%.2f", subtotal);
        String taxString = String.format("%.2f", tax);
        String totalString = String.format("%.2f", total);
        String message = "";
        if (state.equals("WI")){
            message = message.concat("The subtotal is $" + subtotalString + ".\nThe tax is $" + taxString + ".\n");
        }
        message = message.concat("The total is " + totalString + ".");
        return message;
    }

}

package main;

import components.Dispenser;

import java.util.Scanner;

/**
 * Created by AKrzos on 2016-08-23.
 */
public class Main {
    public static void main(String[] args) {
        Dispenser dispenser = new Dispenser();


        Scanner reader = new Scanner(System.in);  // Reading from System.in

        int row, position;

        while (true) {
            dispenser.fillMissingIngredients();
            dispenser.PrintDispenser();
            System.out.println("Enter a row: ");
            row = reader.nextInt();
            System.out.println("Enter a position: ");
            position = reader.nextInt();
            System.out.println(dispenser.pickIngridient(row, position));

        }
    }
}

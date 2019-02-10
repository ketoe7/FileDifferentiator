package com.wierzbicki;

import java.util.Scanner;

public class Main {

    private static Extentions extentions = new Extentions();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Type the path to file to check. 'quit' to exit: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                break;
            } else {
                String[] parts = input.split("/");
                /*For testing purpose only
                    System.out.println("Part length = " + parts.length);
                */
                if (!parts[parts.length - 1].contains(".")) {
                    System.out.println("Path does not contain the extention of file.");
                } else {
                    String[] dots = parts[parts.length - 1].split("\\.");
                    /*For testing purpose only
                        System.out.println("Dots length = " + dots.length);
                    */
                    String givenExtention = dots[dots.length - 1];
                    /*For testing purpose only
                        System.out.println(parts[parts.length - 1]);
                    */
                    try {
                        System.out.println(givenExtention);

                        boolean indicator = extentions.get(givenExtention).checkIfExtentionIsTrue(input);
                        if (indicator) {
                            System.out.println("Your file is safe, extention is true! Type next file to check or 'quit' to exit: ");
                        } else {
                            System.out.println("It's fake!!");
                            extentions.searchForRealExtention(input);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Unknown extention, we can not judge if file is safe. Type next file or 'quit' to exit: ");
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}

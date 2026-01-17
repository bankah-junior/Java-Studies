package com.amalitech.recursion;

public class Recursion {
    public static int factorial(int n) {
        // Base case: If n is 0, return 1
        if (n == 0) {
            return 1;
        }
        // Recursive call: otherwise, return n multiplied by the factorial of n-1
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int result = factorial(5); // Calculates 5 * 4 * 3 * 2 * 1
        System.out.println("Factorial of 5 is: " + result); // Output: 120
    }
}

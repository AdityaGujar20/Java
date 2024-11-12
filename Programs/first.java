import java.lang.*;
import java.util.*;


class first {
    public static void main(String args[]){
        // print statement in java
        System.out.println("Hello");

        // creating scanner object to take user input
        Scanner s = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = s.next();
        System.out.println("Hello " + name);

        System.out.println("Enter the 1st number: ");
        int a = s.nextInt();
        System.out.println("Enter the 2nd number: ");
        int b = s.nextInt();
        int c = a + b;
        System.out.println("Sum of a and b is: " + c);
    }    
}

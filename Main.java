import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BitVector bitVector = new BitVector();
        Scanner sc = new Scanner(System.in);
        boolean cond = true;
        System.out.println("Dear user: \n Enter 0 if you want to interrupt the program. \n Enter 1 if you want to set 1 in some position. \n Enter 2 if you want to set 0 in some position.");
        System.out.println("For position you must enter a positive number.");
        while (cond) {
            if (sc.nextInt() == 0) {
                System.out.println("End off.");
                cond = false;
            } else if (sc.nextInt() == 1) {
                System.out.println("For position you must enter a positive number.");
                System.out.print("Enter a position: ");
                bitVector.set(sc.nextInt());
                System.out.println();
            } else if (sc.nextInt() == 2) {
                System.out.println("For position you must enter a positive number.");
                System.out.print("Enter a position: ");
                bitVector.reset(sc.nextInt());
                System.out.println();
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
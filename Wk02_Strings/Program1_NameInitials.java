
//Write a program that computes your initials from your full name and displays them
import java.util.Scanner;

public class Program1_NameInitials {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String s = scanner.nextLine();
        String[] name = s.split(" ");
        String nameInitials = "";
        for (String n : name) {
            nameInitials += n.charAt(0);
        }
        System.out.println("Your initials are: " + nameInitials);
        scanner.close();
    }

}
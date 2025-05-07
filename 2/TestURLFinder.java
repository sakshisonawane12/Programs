import java.util.Scanner;
public class TestURLFinder {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the url:");
        String input=sc.nextLine();

        URLFinder finder=new URLFinder(0);

        boolean isvalid=finder.urlChecker(input);
        System.out.print("Is url valid:"+isvalid);
        
    }
}

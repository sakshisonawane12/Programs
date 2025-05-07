import java.util.Scanner;

public class TestCaesarCipher {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter the string:");
            String input=sc.nextLine();

            CaesarCipher cipher=new CaesarCipher(18);

            String encrypted =cipher.encrypt(input);
            System.err.println("Encrypted:" +encrypted);

            String decrypted =cipher.decrypt(input);
            System.err.println("Decrypted:" +decrypted);
        }


    }
}

import java.util.*;

public class RemovePrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.println("Enter numbers (type -1 to stop):");
        while (true) {
            int n = sc.nextInt();
            if (n == -1) break;
            list.add(n);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (isPrime(it.next())) it.remove();
        }

        System.out.println("After removing primes: " + list);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0) return false;
        return true;
    }
}

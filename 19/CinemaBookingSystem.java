import java.util.Scanner;

class CinemaHall {
    private int[][] seats;  // 2D array to represent the cinema hall seating
    private int rows;
    private int columns;

    // Constructor to initialize seating arrangement
    public CinemaHall(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = new int[rows][columns];

        // Initialize all seats to 0 (Available)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = 0;  // 0 means the seat is available
            }
        }
    }

    // Method to display the seating arrangement
    public void displaySeating() {
        System.out.println("Cinema Seating Map:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to book a seat
    public boolean bookSeat(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            System.out.println("Invalid seat position.");
            return false;
        }
        if (seats[row][column] == 1) {
            System.out.println("Seat already booked.");
            return false;
        }
        seats[row][column] = 1;  // 1 means the seat is booked
        System.out.println("Seat booked successfully.");
        return true;
    }

    // Method to check if a seat is available
    public boolean isSeatAvailable(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            System.out.println("Invalid seat position.");
            return false;
        }
        return seats[row][column] == 0;  // True if seat is available (0 means available)
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a CinemaHall object with 5 rows and 5 columns
        CinemaHall hall = new CinemaHall(5, 5);

        // Display initial seating arrangement
        hall.displaySeating();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Seat Map");
            System.out.println("2. Book a Seat");
            System.out.println("3. Check if a Seat is Available");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                // Display seat map
                hall.displaySeating();
            } else if (choice == 2) {
                // Book a seat
                System.out.print("Enter row number (0-4): ");
                int row = sc.nextInt();
                System.out.print("Enter column number (0-4): ");
                int col = sc.nextInt();

                // Check seat availability before booking
                if (hall.isSeatAvailable(row, col)) {
                    hall.bookSeat(row, col);
                } else {
                    System.out.println("Seat is not available or invalid.");
                }
            } else if (choice == 3) {
                // Check if a seat is available
                System.out.print("Enter row number (0-4): ");
                int row = sc.nextInt();
                System.out.print("Enter column number (0-4): ");
                int col = sc.nextInt();

                if (hall.isSeatAvailable(row, col)) {
                    System.out.println("The seat is available.");
                } else {
                    System.out.println("The seat is already booked or invalid.");
                }
            } else if (choice == 4) {
                // Exit the program
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}

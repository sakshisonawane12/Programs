import java.util.Scanner;

class Rectangle {
    private int length;
    private int breadth;

    // Constructor using 'this' keyword
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate area
    public int getArea() {
        return length * breadth;
    }

    // Method to compare area with another rectangle
    public void compareArea(Rectangle r) {
        int thisArea = this.getArea();
        int otherArea = r.getArea();

        if (thisArea > otherArea) {
            System.out.println("Rectangle 2 rectangle has a larger area.");
        } else if (thisArea < otherArea) {
            System.out.println("Rectangle 1 rectangle has a larger area.");
        } else {
            System.out.println("Both rectangles have equal area.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions for Rectangle 1:");
        System.out.print("Length: ");
        int l1 = sc.nextInt();
        System.out.print("Breadth: ");
        int b1 = sc.nextInt();

        System.out.println("Enter dimensions for Rectangle 2:");
        System.out.print("Length: ");
        int l2 = sc.nextInt();
        System.out.print("Breadth: ");
        int b2 = sc.nextInt();

        Rectangle r1 = new Rectangle(l1, b1);
        Rectangle r2 = new Rectangle(l2, b2);

        r1.compareArea(r2);
        sc.close();
    }
}

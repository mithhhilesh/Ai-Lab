import java.util.Scanner;

public class twoJug {
    public static void main(String[] args) {

        int x = 0;      // 3 litres jug
        int y = 0;      // 5 litres jug
        int maxX = 3;
        int maxY = 5;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1: Fill x");
            System.out.println("2: Fill y");
            System.out.println("3: Empty x");
            System.out.println("4: Empty y");
            System.out.println("5: Pour x -> y");
            System.out.println("6: Pour y -> x");
            System.out.println("7: Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    x = maxX;
                    break;

                case 2:
                    y = maxY;
                    break;

                case 3:
                    x = 0;
                    break;

                case 4:
                    y = 0;
                    break;

                case 5: {
                    int transfer = Math.min(x, maxY - y);
                    x = x - transfer;
                    y = y + transfer;
                    break;
                }

                case 6: {
                    int transfer = Math.min(y, maxX - x);
                    y = y - transfer;
                    x = x + transfer;
                    break;
                }

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("x = " + x + " litres");
            System.out.println("y = " + y + " litres");

            if (x == 4 || y == 4) {
                System.out.println("4 litres measured");
                break;
            }
        }

        sc.close();
    }
}

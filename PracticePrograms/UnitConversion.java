// Create a menu driven command-line based application in Java to convert the N unit distance to the requested unit.
import java.util.Scanner;

public class UnitConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\nMenu based app - Unit conversion for Distance");
            System.out.println("1. CM to M");
            System.out.println("2. M to KM");
            System.out.println("3. KM to M");
            System.out.println("4. M to CM");

            System.out.print("\nEnter your menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Please enter the CM Value: ");
                    double cm = scanner.nextDouble();
                    double meters = cm / 100;
                    System.out.println(cm + " CM = " + meters + " M");
                    break;
                case 2:
                    System.out.print("Please enter the M Value: ");
                    double m = scanner.nextDouble();
                    double kilometers = m / 1000;
                    System.out.println(m + " M = " + kilometers + " KM");
                    break;
                case 3:
                    System.out.print("Please enter the KM Value: ");
                    double km = scanner.nextDouble();
                    double meters2 = km * 1000;
                    System.out.println(km + " KM = " + meters2 + " M");
                    break;
                case 4:
                    System.out.print("Please enter the M Value: ");
                    double m2 = scanner.nextDouble();
                    double cm2 = m2 * 100;
                    System.out.println(m2 + " M = " + cm2 + " CM");
                    break;
                default:
                    System.out.println("Invalid menu option");
                    break;
            }

            System.out.print("\nDo you want to Continue? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }
}

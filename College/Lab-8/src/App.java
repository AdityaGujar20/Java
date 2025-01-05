import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Conference Attendee Management ---");
            System.out.println("1. Add Attendee");
            System.out.println("2. Edit Attendee");
            System.out.println("3. Delete Attendee");
            System.out.println("4. Search Attendee");
            System.out.println("5. Generate Attendee Statistics");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contactNumber = scanner.nextLine();
                    System.out.print("Enter Country: ");
                    String country = scanner.nextLine();

                    AttendeeManager.addAttendee(fullName, email, contactNumber, country);
                }
                case 2 -> {
                    System.out.print("Enter Attendee ID to edit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter New Contact Number: ");
                    String newContactNumber = scanner.nextLine();

                    AttendeeManager.editAttendee(id, newEmail, newContactNumber);
                }
                case 3 -> {
                    System.out.print("Enter Attendee ID to delete: ");
                    int id = scanner.nextInt();
                    AttendeeManager.deleteAttendee(id);
                }
                case 4 -> {
                    System.out.print("Enter search query (Name or Country): ");
                    String searchQuery = scanner.nextLine();
                    AttendeeManager.searchAttendee(searchQuery);
                }
                case 5 -> {
                    System.out.println("\n--- Attendee Statistics by Country ---");
                    AttendeeManager.generateStatistics();
                }
                case 6 -> System.out.println("Exiting the application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

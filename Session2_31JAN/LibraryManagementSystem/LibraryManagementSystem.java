import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Publisher> publishers = new ArrayList<>();
        ArrayList<LibraryBook> books = new ArrayList<>();
        ArrayList<IssueRecord> issueRecords = new ArrayList<>();

        int choice;
        do {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Department");
            System.out.println("2. Add Publisher");
            System.out.println("3. Add Book");
            System.out.println("4. Display Books");
            System.out.println("5. Issue Book");
            System.out.println("6. Display Issue Records");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Department Name: ");
                    String departmentName = scanner.nextLine();
                    departments.add(new Department(departmentName));
                    break;
                case 2:
                    System.out.print("Enter Publisher Name: ");
                    String publisherName = scanner.nextLine();
                    System.out.print("Enter Publisher Contact Info: ");
                    String contactInfo = scanner.nextLine();
                    publishers.add(new Publisher(publisherName, contactInfo));
                    break;
                case 3:
                    System.out.print("Enter Book Name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter Page Count: ");
                    int pageCount = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Edition: ");
                    String edition = scanner.nextLine();
                    System.out.print("Enter Department Name: ");
                    String bookDepartment = scanner.nextLine();
                    Department department = findDepartment(departments, bookDepartment);
                    System.out.print("Enter Publisher Name: ");
                    String bookPublisher = scanner.nextLine();
                    Publisher publisher = findPublisher(publishers, bookPublisher);

                    if (department != null && publisher != null) {
                        books.add(
                                new LibraryBook(bookName, pageCount, price, quantity, publisher, edition, department));
                    } else {
                        System.out.println("Invalid Department or Publisher. Book not added.");
                    }
                    break;
                case 4:
                    displayBooks(books);
                    break;
                case 5:
                    System.out.print("Enter Book Name to Issue: ");
                    String issueBookName = scanner.nextLine();
                    LibraryBook issueBook = findBook(books, issueBookName);

                    if (issueBook != null) {
                        System.out.print("Enter Issuer ID: ");
                        String issuerId = scanner.nextLine();
                        System.out.print("Enter Issue Date: ");
                        String issueDate = scanner.nextLine();
                        System.out.print("Enter Last Return Date: ");
                        String lastReturnDate = scanner.nextLine();
                        System.out.print("Enter Fine (if any): ");
                        double fine = scanner.nextDouble();

                        issueRecords.add(new IssueRecord(issueBook, issuerId, issueDate, lastReturnDate, fine));
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Book not found. Cannot issue.");
                    }
                    break;
                case 6:
                    displayIssueRecords(issueRecords);
                    break;
                case 0:
                    System.out.println("Exiting Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void displayBooks(ArrayList<LibraryBook> books) {
        System.out.println("\nLibrary Books:");
        for (LibraryBook book : books) {
            System.out.println(book.toString());
        }
    }

    private static void displayIssueRecords(ArrayList<IssueRecord> issueRecords) {
        System.out.println("\nIssue Records:");
        for (IssueRecord record : issueRecords) {
            System.out.println(record.toString());
        }
    }

    private static Department findDepartment(ArrayList<Department> departments, String departmentName) {
        for (Department department : departments) {
            if (department.getName().equalsIgnoreCase(departmentName)) {
                return department;
            }
        }
        System.out.println("Department not found.");
        return null;
    }

    private static Publisher findPublisher(ArrayList<Publisher> publishers, String publisherName) {
        for (Publisher publisher : publishers) {
            if (publisher.getName().equalsIgnoreCase(publisherName)) {
                return publisher;
            }
        }
        System.out.println("Publisher not found.");
        return null;
    }

    private static LibraryBook findBook(ArrayList<LibraryBook> books, String bookName) {
        for (LibraryBook book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }
}

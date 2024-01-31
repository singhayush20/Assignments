import java.util.Scanner;

public class PublicationService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = null;
        Tape tape = null;

        try {

            System.out.println("Enter Book details:");
            System.out.print("Title: ");
            String bookTitle = scanner.nextLine();

            System.out.print("Price: ");
            float bookPrice = scanner.nextFloat();
            scanner.nextLine();

            System.out.print("Page Count: ");
            int pageCount = scanner.nextInt();

            book = new Book(bookTitle, bookPrice, pageCount);

            System.out.println("\nEnter Tape details:");
            System.out.print("Title: ");
            String tapeTitle = scanner.nextLine();
            // Consume the newline character left in the buffer
            scanner.nextLine();

            System.out.print("Price: ");
            float tapePrice = scanner.nextFloat();

            System.out.print("Playing Time (in mins): ");
            float playingTime = scanner.nextFloat();

            tape = new Tape(tapeTitle, tapePrice, playingTime);

        } catch (Exception e) {
            System.out.println("An exception occurred. Resetting data members to zero values.");
            resetToZeroValues(book, tape);
        } finally {
            System.out.println("\nBook Details:");
            displayPublicationDetails(book);

            System.out.println("\nTape Details:");
            displayPublicationDetails(tape);

            scanner.close();
        }
    }

    private static void displayPublicationDetails(Publication publication) {
        System.out.println("Title: " + publication.title);
        System.out.println("Price: " + publication.price);
    }

    private static void resetToZeroValues(Book book, Tape tape) {
        System.out.println("Resetting data members to zero values.");

        if (book != null) {
            book.title = "";
            book.price = 0.0f;
            book.pageCount = 0;
        }

        if (tape != null) {
            tape.title = "";
            tape.price = 0.0f;
            tape.playingTime = 0.0f;
        }
    }
}
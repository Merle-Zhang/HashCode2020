import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.lang.StringBuilder;

public class BookScanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bookNum = scan.nextInt(); // B
        int libNum = scan.nextInt(); // L
        int dayNum = scan.nextInt(); // D

        ArrayList<Book> books = new ArrayList<Book>(bookNum);
        for (int i = 0; i < bookNum; i++) {
            int score = scan.nextInt();
            books.add(new Book(i, score));
        }

        ArrayList<Library> libraries = new ArrayList<Library>(libNum);
        for (int i = 0; i < libNum; i++) {
            int numBook = scan.nextInt();
            int signup = scan.nextInt();
            int speed = scan.nextInt();
            libraries.add(new Library(i, numBook, signup, speed));

            ArrayList<Book> libBooks = libraries.get(i).books;
            for (int j = 0; j < numBook; j++) {
                int bookId = scan.nextInt();
                libBooks.add(books.get(bookId));
            }
        }
        scan.close();
        
        Collections.sort(libraries, Collections.reverseOrder());

        StringBuilder builder = new StringBuilder();
        HashSet<Book> scannedBook = new HashSet<Book>();
        int day = dayNum;
        int libsize = 0;
        while (libraries.size() > 0 && day > 0) {
            Library library = libraries.get(0);
            library.removedup(scannedBook);
            if (library.books.size() == 0) {
                libraries.remove(0);
                continue;
            }
            day -= library.signup;
            int numBook = day * library.speed;
            if (numBook <= 0) {
                libraries.remove(0);
                continue;
            }
            numBook = Math.min(numBook, library.books.size());
            builder.append(library.id + " " + numBook + "\n");
            Collections.sort(library.books, Collections.reverseOrder());
            for (int i = 0; i < numBook; i++) {
                Book book = library.books.get(i);
                scannedBook.add(book);
                builder.append(book.id + " ");
            }
            builder.append("\n");
            libsize++;
            libraries.remove(0);
            Collections.sort(libraries, Collections.reverseOrder());
        }
        builder.insert(0, libsize + "\n");
        System.out.println(builder);
    }
    
    
}
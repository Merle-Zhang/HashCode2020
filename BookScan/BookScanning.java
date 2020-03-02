import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;
import java.util.Collection;




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

        // for (Book book : books) {
        //     System.out.println(book);
        // }

        // Collections.sort(books);
        // Collections.sort(libraries);
        
        // for (Library library : libraries) {
        //     System.out.println(library);
        // }
        // System.out.println(Arrays.toString(books.toArray()));
        // System.out.println(Arrays.toString(libraries.toArray()));

        Collections.sort(libraries);

        System.out.println(libraries.size());
        for (Library library : libraries) {
            System.out.println(library.id + " " + library.books.size());
            Collections.sort(library.books);
            for (Book book : library.books) {
                System.out.print(book.id + " ");
            }
            System.out.println();
        }

    }
    
    
}
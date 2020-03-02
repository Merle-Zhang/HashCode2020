import java.util.ArrayList;
import java.util.HashSet;

public class Library implements Comparable<Library> {

    int id;
    int signup;
    int speed;
    ArrayList<Book> books;

    public Library(int id, int numBook, int signup, int speed) {
        this.id = id;
        this.books = new ArrayList<Book>(numBook);
        this.signup = signup;
        this.speed = speed;
    }

    int scoresum() {
        int sum = 0;
        for (Book book : books) {
            sum += book.score;
        }
        return sum;
    }

    int calculate() {
        return scoresum()/signup;
    }
    
    public int compareTo(Library m) {
        return this.calculate() - m.calculate();
    }
    
    public void removedup(HashSet<Book> scannedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (scannedBook.contains(books.get(i))) {
                books.remove(i);
                i--;
            }
        }
    }

    @Override
    public String toString() {
        return "LibID: " + id + "\nSignup: " + signup + "\nSpeed: " + speed + "\nNumber of Books: " + books.size();
    }
}
import java.util.ArrayList;

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
    
    
    @Override
    public String toString() {
        return "LibID: " + id + "\nSignup: " + signup + "\nSpeed: " + speed + "\nNumber of Books: " + books.size();
    }
}
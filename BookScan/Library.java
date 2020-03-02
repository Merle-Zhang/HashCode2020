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

    public int compareTo(Library m) {
        return this.signup - m.signup;
    }
    
    
    @Override
    public String toString() {
        return "LibID: " + id + "\nSignup: " + signup + "\nSpeed: " + speed + "\nNumber of Books: " + books.size();
    }
}
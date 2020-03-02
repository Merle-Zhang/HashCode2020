public class Book implements Comparable<Book> {
    int id;
    int score;

    public Book(int id, int score) {
        this.id = id;
        this.score = score;
    }

    public int compareTo(Book m) { 
        return this.score - m.score;
    } 

    @Override
    public String toString() {
        return "ID: " + id + "\nScore: " + score;
    } 
}
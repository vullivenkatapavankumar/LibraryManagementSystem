import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private List<Book> issuedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
        book.issue();
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
        book.returnBook();
    }

    public String toString() {
        return "[User ID: " + userId + ", Name: " + name + ", Books Issued: " + issuedBooks.size() + "]";
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }
}

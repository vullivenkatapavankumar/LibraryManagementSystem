import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered successfully.");
    }

    public void viewBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void viewUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    public User findUserById(String userId) {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return u;
            }
        }
        return null;
    }

    public void issueBook(String userId, String bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);
        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return;
        }
        user.issueBook(book);
        System.out.println("Book issued successfully.");
    }

    public void returnBook(String userId, String bookId) {
        User user = findUserById(userId);
        Book book = findBookById(bookId);
        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book is not issued.");
            return;
        }
        user.returnBook(book);
        System.out.println("Book returned successfully.");
    }
}

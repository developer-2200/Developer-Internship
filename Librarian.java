package InternshipTask;

public class Librarian extends Member {
    
    public Librarian(int memberID, String name) {
        super(memberID, name, Integer.MAX_VALUE);// Librarians can manage any number of books
    }
    
    //invoking getBook method to add book in member
    public void addBook(Library library, Book book) {
        library.getBooks().add(book);
    }

    //invoking getBook method to remove book in member
    public void removeBook(Library library, Book book) {
        library.getBooks().remove(book);
    }
}

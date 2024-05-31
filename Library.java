package InternshipTask;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryOperations {
    private List<Book> books;
    private List<Member> members;
    
    
    // upcasting arraylist to members and books
    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    //returning books
    public List<Book> getBooks() {
        return books;
    }
    
    //returning members
    public List<Member> getMembers() {
        return members;
    }
    
    // if book is available and  member have limit teacher 5 and student 3 book so set issue is true ,else false(no book is issued )
    @Override
    public boolean issueBook(Book book, Member member) {
        if (!book.isIssued() && member.canIssueMoreBooks()) {
            book.setIssued(true);
            member.issueBook(book);
            return true;
        }
        return false;
    }
    
     //if book is issued and member contains the book then book will return
    @Override
    public boolean returnBook(Book book, Member member) {
        if (book.isIssued() && member.getCurrentIssuedBooks().contains(book)) {
            book.setIssued(false);
            member.returnBook(book);
            return true;
        }
        return false;
    }
}

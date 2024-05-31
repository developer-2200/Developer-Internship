package InternshipTask;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberID;
    private String name;
    private int maxBooksIssued;
    private List<Book> currentIssuedBooks;

   //constructor for referring memebersID name and Maximum book issued and up caste current  issued books to array list
    public Member(int memberID, String name, int maxBooksIssued) {
        this.memberID = memberID;
        this.name = name;
        this.maxBooksIssued = maxBooksIssued;
        this.currentIssuedBooks = new ArrayList<>();
    }
    
    // to get members ID 
    public int getMemberID() {
        return memberID;
    }
   
    // to get name of members
    public String getName() {
        return name;
    }
    
    // get numbers of max book issued 
    public int getMaxBooksIssued() {
        return maxBooksIssued;
    }
    
    //get current Issued books
    public List<Book> getCurrentIssuedBooks() {
        return currentIssuedBooks;
    }
      
    //get in t/f can issue more books
    public boolean canIssueMoreBooks() {
        return currentIssuedBooks.size() < maxBooksIssued;
    }
    
   // adding issue books to library
    public void issueBook(Book book) {
        currentIssuedBooks.add(book);
    }
     
    //removing issued books
    public void returnBook(Book book) {
        currentIssuedBooks.remove(book);
    }
}


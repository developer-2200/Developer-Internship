package InternshipTask;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isIssued;
    
    //parameter for referring bookId, title, author and isIssued    
    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    
    //get the book id
    public int getBookID() {
        return bookID;
    }
    
    //get the Title 
    public String getTitle() {
        return title;
    }
    
    // get the author
    public String getAuthor() {
        return author;
    }

    //get isIssued in boolean 
    public boolean isIssued() {
        return isIssued;
    }

    //updating isIssued  
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

}


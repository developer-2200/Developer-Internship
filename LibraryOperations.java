package InternshipTask;


public interface LibraryOperations {
	
	//interface for issue and return the books
    boolean issueBook(Book book, Member member);
    boolean returnBook(Book book, Member member);
}

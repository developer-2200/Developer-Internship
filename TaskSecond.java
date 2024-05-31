package InternshipTask;

public class TaskSecond {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(1, "Mamta");// librarian name
        StudentMember student = new StudentMember(2, "Uttkarsh");//student name  as member
        TeacherMember teacher = new TeacherMember(3, "Swati Mam");//teacher name as member

        //books in library
        Book book1 = new Book(101, "Java Programming", "Author A");
        Book book2 = new Book(102, "Data Structures", "Author B");
        Book book3 = new Book(103, "Algorithms", "Author C");
        
        //adding books in library
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
        librarian.addBook(library, book3);
         
        //issue books from library
        System.out.println("Issuing books to members:");
        System.out.println("Issue book1 to student: " + library.issueBook(book1, student));
        System.out.println("Issue book2 to student: " + library.issueBook(book2, student));
        System.out.println("Issue book3 to student: " + library.issueBook(book3, student)); // Should fail
        System.out.println("Issue book3 to teacher: " + library.issueBook(book3, teacher));

         //returning the books to library
        System.out.println("\nReturning books:");
        System.out.println("Return book1 from student: " + library.returnBook(book1, student));
        System.out.println("Return book3 from teacher: " + library.returnBook(book3, teacher));

        System.out.print("\nRemoving book2 from library");
        librarian.removeBook(library, book2);
        
    }
}

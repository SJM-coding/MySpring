package workshop.library.control;

import workshop.library.entity.*;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("중앙 도서관");
        addSampleBooks(library);

        System.out.println("===== 중앙 도서관 =====");
        printLibraryStatus(library);

        System.out.println("\n===== 도서 검색 테스트 =====");
        testFindBook(library);

        System.out.println("\n===== 도서 대출 테스트 =====");
        testCheckOut(library);

        System.out.println("\n도서관 현재 상태:");
        printLibraryStatus(library);

        System.out.println("\n===== 도서 반납 테스트 =====");
        testReturn(library);

        System.out.println("\n도서관 현재 상태:");
        printLibraryStatus(library);

        System.out.println("===== 대출 가능한 도서 목록 =====");
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }

    private static void testFindBook(Library library) {
        Book foundByTitle = library.findBookByTitle("자바의 정석");
        if (foundByTitle != null) System.out.println("제목으로 검색 결과:\n" + foundByTitle);

        List<Book> foundByAuthor = library.findBooksByAuthor("Robert C. Martin");
        System.out.println("\n저자로 검색 결과:");
        for (Book book : foundByAuthor) {
            System.out.println(book);
        }
    }

    private static void testCheckOut(Library library) {
        library.checkOutBook("978-89-01-14077-4");
    }

    private static void testReturn(Library library) {
        library.returnBook("978-89-01-14077-4");
    }

    private static void displayAvailableBooks(Library library) {
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}

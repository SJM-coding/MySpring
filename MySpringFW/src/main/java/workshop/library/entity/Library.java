package workshop.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) result.add(book);
        }
        return result;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.checkOut()) {
            System.out.println("도서 대출 성공!\n대출된 도서 정보:\n" + book);
            return true;
        }
        System.out.println("도서 대출 실패.");
        return false;
    }

    public void returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            System.out.println("도서 반납 성공!\n반납된 도서 정보:\n" + book);
        } else {
            System.out.println("도서를 찾을 수 없습니다.");
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) result.add(book);
        }
        return result;
    }

    public int getTotalBooks() { return books.size(); }

    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) count++;
        }
        return count;
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}
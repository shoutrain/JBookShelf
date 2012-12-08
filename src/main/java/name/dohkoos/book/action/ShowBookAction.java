package name.dohkoos.book.action;

import name.dohkoos.book.model.Book;
import name.dohkoos.book.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class ShowBookAction extends ActionSupport {
    private static final long serialVersionUID = 2538923417705852774L;

    private Book book;
    private Long bookId;

    private BookService bookService;

    public String execute() throws Exception {
        book = bookService.getBook(bookId);
        return SUCCESS;
    }

    public Book getBook() {
        return book;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}

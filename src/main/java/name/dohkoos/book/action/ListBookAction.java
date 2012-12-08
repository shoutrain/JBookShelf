package name.dohkoos.book.action;

import java.util.List;

import name.dohkoos.book.model.Book;
import name.dohkoos.book.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class ListBookAction extends ActionSupport {
    private static final long serialVersionUID = 2538923417705852774L;

    private List<Book> bookList;

    private BookService bookService;

    public String execute() throws Exception {
        bookList = bookService.getBookList();
        return SUCCESS;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}

package name.dohkoos.book.action;

import name.dohkoos.account.model.User;
import name.dohkoos.book.model.Book;
import name.dohkoos.book.service.BookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditBookAction extends ActionSupport {
    private static final long serialVersionUID = 2538923417705852774L;

    private Book book;
    private Long bookId;

    private BookService bookService;

    public String execute() throws Exception {
        User user = (User)ActionContext.getContext().getSession().get("user");
        book.setUser(user);
        bookService.updateBook(book);
        return SUCCESS;
    }

    public String input() throws Exception {
        book = bookService.getBook(bookId);
        return INPUT;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}

package com.goo.training.ssh.jbs.book.service;

import java.util.List;

import com.goo.training.ssh.jbs.book.dao.BookDao;
import com.goo.training.ssh.jbs.book.model.Book;

public class BookService {
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBookList() {
		return bookDao.getBookList();
	}

	public Book getBook(Long bookId) {
		return bookDao.getBook(bookId);
	}

	public void saveOrUpdateBook(Book book) {
		bookDao.saveOrUpdateBook(book);
	}

	public void deleteBook(Long bookId) {
		bookDao.deleteBook(bookId);
	}
}

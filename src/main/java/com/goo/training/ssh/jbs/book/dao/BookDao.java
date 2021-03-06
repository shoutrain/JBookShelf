package com.goo.training.ssh.jbs.book.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.goo.training.ssh.jbs.book.model.Book;

public class BookDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Book> getBookList() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Book b");
			@SuppressWarnings("unchecked")
			List<Book> bookList = query.list();
			return bookList;
		} finally {
			session.close();
		}
	}

	public Book getBook(Long bookId) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Book b where b.id = :id");
			query.setLong("id", bookId);
			query.setMaxResults(1);
			return (Book) query.uniqueResult();
		} finally {
			session.close();
		}
	}

	public void saveOrUpdateBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			session.saveOrUpdate(book);
			ts.commit();
		} finally {
			session.close();
		}
	}

	public void deleteBook(Long bookId) {
		Session session = sessionFactory.openSession();
		Transaction ts = null;
		try {
			ts = session.beginTransaction();
			Book book = (Book) session.get(Book.class, bookId);
			session.delete(book);
			ts.commit();
		} finally {
			session.close();
		}
	}
}

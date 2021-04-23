package vn.book.trade.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.book.trade.entity.Book;

@Repository
@Transactional
public class BookDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public Book findById(int id) {
		return this.entityManager.find(Book.class, id);
	}
	public Book insert(Book test) {
		try {
			
			this.entityManager.persist(test);
			this.entityManager.flush();
			return test;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
}

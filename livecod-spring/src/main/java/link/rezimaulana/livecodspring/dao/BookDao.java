package link.rezimaulana.livecodspring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import link.rezimaulana.livecodspring.model.Book;

@Repository
public class BookDao extends BaseDao {

	public Book insert(final Book data) {
		this.em.persist(data);
		return data;
	}
	
	public Book update(final Book data) {
		final Book result = this.em.merge(data);
		return result;
	}
	
	public Optional<Book> getById(final Long id) {
		final Book findOne = this.em.find(Book.class, id);
		em.detach(findOne);
		final Optional<Book> result = Optional.ofNullable(findOne);
		return result;
	}
	
	public List<Book> getAll(){
		final String sql = "SELECT doc FROM Book doc";
		final List<Book> result = this.em.createQuery(sql, Book.class).getResultList();
		return result;
	}
	
	public boolean deleteById(final Long id) {
		final String sql = "DELETE FROM Book WHERE id = :id";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}

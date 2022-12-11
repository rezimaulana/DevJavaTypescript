package link.rezimaulana.livecodspring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import link.rezimaulana.livecodspring.model.Author;

@Repository
public class AuthorDao extends BaseDao{

	public Author insert(final Author data) {
		this.em.persist(data);
		return data;
	}
	
	public Author update(final Author data) {
		final Author result = this.em.merge(data);
		return result;
	}
	
	public Optional<Author> getById(final Long id) {
		final Author findOne = this.em.find(Author.class, id);
		em.detach(findOne);
		final Optional<Author> result = Optional.ofNullable(findOne);
		return result;
	}
	
	public List<Author> getAll() {
		final String sql = "SELECT doc FROM Author doc";
		final List<Author> result = this.em.createQuery(sql, Author.class).getResultList();
		return result;
	}
	
	public boolean deleteById(final Long id) {
		final String sql = "DELETE FROM Author WHERE id = :id";
		final int result = this.em.createQuery(sql, Author.class).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}

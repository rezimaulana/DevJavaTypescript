package link.rezimaulana.livecodspring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import link.rezimaulana.livecodspring.model.Library;

@Repository
public class LibraryDao extends BaseDao {
	
	public Library insert(final Library data) {
		this.em.persist(data);
		return data;
	}
	
	public Library update(final Library data) {
		final Library result = this.em.merge(data);
		return result;
	}
	
	public Optional<Library> getById(final Long id) {
		final Library findOne = this.em.find(Library.class, id);
		em.detach(findOne);
		final Optional<Library> result = Optional.ofNullable(findOne);
		return result;
	}
	
	public List<Library> getAll() {
		final String sql = "SELECT doc FROM Library doc";
		final List<Library> result = this.em.createQuery(sql, Library.class).getResultList();
		return result;
	}

	public boolean deleteById(final Long id) {
		final String sql = "DELETE FROM Library WHERE id = :id";
		final int result = this.em.createQuery(sql).setParameter("id", id).executeUpdate();
		return result > 0;
	}
	
}

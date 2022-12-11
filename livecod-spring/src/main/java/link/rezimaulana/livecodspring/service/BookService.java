package link.rezimaulana.livecodspring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import link.rezimaulana.livecodspring.constant.ResponseConst;
import link.rezimaulana.livecodspring.dao.BookDao;
import link.rezimaulana.livecodspring.dto.ResponseDto;
import link.rezimaulana.livecodspring.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional(rollbackOn = Exception.class)
	public ResponseDto insert(final Book data) {
		final ResponseDto response = new ResponseDto();
		try {
			bookDao.insert(data);
			response.setMessage(ResponseConst.CREATED.getResponse());			
		} catch(Exception e) {
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public ResponseDto update(final Book data) {
		final ResponseDto response = new ResponseDto();
		final Optional<Book> optional = bookDao.getById(data.getId());
		if(optional.isPresent()) {
			try {
				final Book result = optional.get();
				result.setTitle(data.getTitle());
				result.setDescription(data.getDescription());
				bookDao.update(result);
				response.setMessage(ResponseConst.UPDATED.getResponse());
			} catch (Exception e) {
				response.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return response;
	}
	
	public Book getById(final Long id) {
		final Optional<Book> optional = bookDao.getById(id);
		if(optional.isPresent()) {
			final Book result = optional.get();
			return result;
		} else {
			throw new RuntimeException("Not Found!");
		}
	}
	
	public List<Book> getAll(){
		return bookDao.getAll();
	}
	
	@Transactional(rollbackOn = Exception.class)
	public ResponseDto deleteById(final Long id) {
		final ResponseDto response = new ResponseDto();
		final Optional<Book> optional = bookDao.getById(id);
		if(optional.isPresent()) {
			try {
				bookDao.deleteById(id);
				response.setMessage(ResponseConst.DELETED.getResponse());
			} catch (Exception e) {
				response.setMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return response;
	}

}

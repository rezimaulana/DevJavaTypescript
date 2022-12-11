package link.rezimaulana.livecodspring.service;

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
			response.setMessage(ResponseConst.FAILED.getResponse());
		}
		return response;
	}

}

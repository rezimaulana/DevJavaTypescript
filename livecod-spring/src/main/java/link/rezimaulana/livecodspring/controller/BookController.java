package link.rezimaulana.livecodspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import link.rezimaulana.livecodspring.dto.ResponseDto;
import link.rezimaulana.livecodspring.model.Book;
import link.rezimaulana.livecodspring.service.BookService;

@RestController
@RequestMapping("books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<ResponseDto> insert(@RequestBody final Book data){
		final ResponseDto result = bookService.insert(data);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
}
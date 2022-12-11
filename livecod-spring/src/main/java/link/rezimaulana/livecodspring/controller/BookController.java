package link.rezimaulana.livecodspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping
	public ResponseEntity<ResponseDto> update(@RequestBody final Book data){
		final ResponseDto result = bookService.update(data);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("detail")
	public ResponseEntity<Book> getById(@RequestParam(required = true) final Long id){
		final Book result = bookService.getById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAll() {
		final List<Book> result = bookService.getAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseDto> deleteById(@RequestParam(required = true) final Long id) {
		final ResponseDto result = bookService.deleteById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
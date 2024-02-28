package com.example.springbootfirstproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirstproject.model.Book;
import com.example.springbootfirstproject.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping("/save")
	public Book save(@RequestBody Book book){
		
		return service.saveBook(book);
	}
	
	@GetMapping("allbooks")
	public List<Book> getAll(){
		return service.allBooks();
	}
	
//	@GetMapping("/countNames")
//	public Long getCountname(@RequestBody String name){
//		return service.countName(name);
//	}
	
	
//	@GetMapping("{name}")
//	public Long countNames(@PathVariable String name){
//		return service.countName(name);
//	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable long id){
		return service.bookId(id);
	}
	
	@PutMapping("update/{id}")
	public Book update(@PathVariable long id,@RequestBody Book book){
		return service.updateBook(id, book);
		
	}
	
	@DeleteMapping("deleteBook/{id}")
	public void delete(@PathVariable long id){
		
		service.deleteook(id);
		
	}
	
	
	
	@PostMapping("searchByName/{name}")
	public Book getname(@PathVariable String name){
		return service.searchByName(name);
	}
	
	@PostMapping("searchPrice/{price}")
	public Book getPrice(@PathVariable String price){
		return service.findPrice(price);
	}
	
	@PostMapping("/{name}/{price}")
	public List<Book> findnameandprice(@PathVariable String name,@PathVariable String price){
		return service.findNameAndPrice(name, price);
		
	}
	
	@GetMapping("countAll")
	public Long countAll(){
		return service.countName();
	}
	
	@PostMapping("ispresentBookName/{id}")
	public Boolean isBookNamePresent(@PathVariable long id){
		return service.ispresentBookOrNot(id);
	}
	
//	@GetMapping("allIds")
//	public Iterable<Book> allIds(Iterable<Long> ids){
//		return service.findAllIds(ids);
//	}
	

	@GetMapping("firstname")
	public Book firstName(String name){
		return service.findFirstName(name);
	}
}

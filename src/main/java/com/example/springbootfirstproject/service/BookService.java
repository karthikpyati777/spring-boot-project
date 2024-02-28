package com.example.springbootfirstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootfirstproject.model.Book;

@Service
public interface BookService {

	Book saveBook(Book book);

	List<Book> allBooks();

	Book bookId(Long id);

	Book updateBook(Long id, Book book);

	void deleteook(long id);

	Book searchByName(String name);

	Book findPrice(String price);

	List<Book> findNameAndPrice(String name, String price);

	Long countName();

	boolean ispresentBookOrNot(long id);
	

//	Iterable<Book> findAllIds(Iterable<Long> ids);
	
	Book findFirstName(String name);

}

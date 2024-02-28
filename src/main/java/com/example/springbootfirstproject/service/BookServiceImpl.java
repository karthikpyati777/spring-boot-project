package com.example.springbootfirstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootfirstproject.exception.NotFoundException;
import com.example.springbootfirstproject.model.Book;
import com.example.springbootfirstproject.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repo;

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		Book book1 = new Book();

		book1.setName(book.getName());
		book1.setPrice(book.getPrice());

		return repo.save(book1);
	}

	@Override
	public List<Book> allBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Book bookId(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new NotFoundException("not found book with given id"));
	}

	@Override
	public Book updateBook(Long id, Book book) {
		// TODO Auto-generated method stub

		Book b = repo.findById(id).orElseThrow(() -> new NotFoundException("not found book with given id"));
		b.setId(book.getId());
		b.setName(book.getName());
		b.setPrice(book.getPrice());

		return repo.save(b);
	}

	@Override
	public void deleteook(long id) {
		// TODO Auto-generated method stub
		repo.findById(id).orElseThrow(() -> new NotFoundException("not found id"));

		repo.deleteById(id);

		System.out.println("DELETED SUCCESSFULLY WITH GIVEN ID : " + id);
	}

	@Override
	public Book searchByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);

	}

	@Override
	public Book findPrice(String price) {
		// TODO Auto-generated method stub
		return repo.findByPrice(price);
	}

	@Override
	public List<Book> findNameAndPrice(String name, String price) {
		// TODO Auto-generated method stub
		return repo.findByNameAndPrice(name, price);
	}

	@Override
	public Long countName() {
		// TODO Auto-generated method stub
		return repo.count();
	}

	@Override
	public boolean ispresentBookOrNot(long id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public Book findFirstName(String name) {
		// TODO Auto-generated method stub
		return repo.findFirstByName(name);
	}

//	@Override
//	public Iterable<Book> findAllIds(Iterable<Long> ids) {
//		// TODO Auto-generated method stub
//		return repo.findAllById(ids);
//	}

	
}

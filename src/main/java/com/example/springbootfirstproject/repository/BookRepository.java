package com.example.springbootfirstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootfirstproject.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	
	public  Book findByName(String name);
	
	public Book findByPrice(String price);
	
	List<Book> findByNameAndPrice(String name,String price);
	
	long count();
	
	Book findFirstByName(String name);

	
	
	
}

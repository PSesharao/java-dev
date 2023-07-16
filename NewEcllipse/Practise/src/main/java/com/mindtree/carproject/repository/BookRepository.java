package com.mindtree.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.carproject.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	Book findByName(String name);
}

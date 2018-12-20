package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findAllByOrderByTitleDesc();
	List<Book> findByCategoryNameNot(String name);
	int  countByTitleContaining(String name);
	List<Book> findByTitleContaining(String name);
	Book findByTitle(String title);
}

package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
}

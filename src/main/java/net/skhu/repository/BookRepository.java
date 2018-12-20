package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import net.skhu.domain.Book;
import net.skhu.domain.Category;
import net.skhu.model.Pagination;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findAllByOrderByTitleDesc();
	List<Book> findByCategoryNameNot(String name);
	int  countByTitleContaining(String name);
	List<Book> findByTitleContaining(String name);
	Book findByTitle(String title);
	
	public Page<Book> findAll(Pageable pageable);
	
    public default List<Book> findAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           new Sort(Sort.Direction.ASC, "id"));
        Page<Book> page = findAll(pageable);
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
    
    public Page<Book> findByCategoryId(int categoryId, Pageable pageable);
    public default List<Book> findByCategoryId(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPg() - 1, pagination.getSz(),
                                           new Sort(Sort.Direction.ASC, "id"));
        Page<Book> page = findByCategoryId(pagination.getCi(), pageable);
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }
    
    

    

}

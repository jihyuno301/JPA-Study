package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.domain.Book;
import net.skhu.domain.Category;
import net.skhu.domain.Publisher;
import net.skhu.model.BookModel;
import net.skhu.repository.BookRepository;
import net.skhu.service.BookService;

@Service
public class BookService {
	
	@Autowired BookRepository bookRepository;
	@Autowired BookService bookService;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public boolean hasErrors(BookModel book, BindingResult bindingResult) {
		
		Book bookc = bookRepository.findByTitle(book.getTitle());
	        if (bookc != null) {
	            bindingResult.rejectValue("title", null, "책제목이 중복됩니다.");
	            return true;
	        }
	        
		if (bindingResult.hasErrors())
            return true;
        
       
        return false;
    }

	public Book createEntity(BookModel bookModel) {
		Book book = new Book();
		book.setTitle(bookModel.getTitle());
		book.setAuthor(bookModel.getAuthor());
		book.setCategory(new Category());
		book.getCategory().setId(bookModel.getCategoryId());
		book.setPrice(bookModel.getPrice());
		book.setPublisher(new Publisher());
		book.getPublisher().setId(bookModel.getPublisherId());
		book.setAvailable(false);
		return book;
		
	}
	
	public void save(BookModel bookModel) {
		Book book = createEntity(bookModel);
		bookRepository.save(book);
	}
	
	
}

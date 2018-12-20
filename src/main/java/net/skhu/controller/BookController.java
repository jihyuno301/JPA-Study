package net.skhu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.validation.BindingResult;

import net.skhu.domain.Book;
import net.skhu.model.BookModel;
import net.skhu.repository.BookRepository;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.PublisherRepository;
import net.skhu.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired BookService bookService;
	@Autowired BookRepository bookRepository;
	@Autowired CategoryRepository categoryRepository;
	@Autowired PublisherRepository publisherRepository;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "book/list";
	}
	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Model model, BookModel book) {
		
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("publishers", publisherRepository.findAll());
		return "book/create";
	} 
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@Valid BookModel book, BindingResult bindingResult,
		Model model	) {
		if(bookService.hasErrors(book, bindingResult)) {
			model.addAttribute("categories", categoryRepository.findAll());
			model.addAttribute("publishers", publisherRepository.findAll());
			return "book/create";
		}
		bookService.save(book);
		return "redirect:list";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") int id) {
		model.addAttribute("book", bookRepository.findById(id).get());
		return "book/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.PUT)
	public String edit(Book book) {
		bookRepository.save(book);
		return "redirect:list";
	}
	
	//RequestMethod.DELETE는 GET처럼 요청할 때 쓰인다.
	@RequestMapping(value="delete")
	public String delete(@RequestParam("id") int id) {
		Book book = bookRepository.findById(id).get();
		bookRepository.delete(book);
		return "redirect:list";
	}
	
	//JPA query creation
	@RequestMapping(value="findAllByOrderByTitleDesc")
	public String findAllByOrderByTitleDesc(Model model) {
		model.addAttribute("books", bookRepository.findAllByOrderByTitleDesc());
		return "book/list";
	}
	
	@RequestMapping(value="findByCategoryNameNot")
	public String findByCategoryNameNot(Model model, @RequestParam("name") String name) {
		model.addAttribute("books", bookRepository.findByCategoryNameNot(name));
		return "book/list";
	}
	
	@RequestMapping(value="countByTitleContaining")
	public String countByTitleContaining(Model model, @RequestParam("name") String name) {
		model.addAttribute("num", bookRepository.countByTitleContaining(name));
		model.addAttribute("books", bookRepository.findByTitleContaining(name));
		model.addAttribute("name", name);
		return "book/list";
	}
	
}

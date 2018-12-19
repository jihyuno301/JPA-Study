package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.domain.Book;
import net.skhu.repository.BookRepository;
import net.skhu.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Autowired BookService bookService;
	@Autowired BookRepository bookRepository;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "book/list";
	}
	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "book/create";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Book book) {
		bookRepository.save(book);
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
	
	
	
}

package gp.swd20.bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gp.swd20.bookstore.domain.Book;
import gp.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	// http://localhost:8080/booklist
	@RequestMapping(value="booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist"; //booklist.html
	}
	
	//tyhjä lomake uudesta kirjasta
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook"; //addbook.html
	}
	
	//tallenna lomake uudesta kirjasta
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	//kirjan poisto tietokannasta
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist"; // redirect ja .. = back
	}

	//Edit book, kirjan muokkaus
	@RequestMapping(value="/edit/{id}")
	public String addBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		//model.addAttribute("books", repository.findAll());
		return "editbook";
	}
}

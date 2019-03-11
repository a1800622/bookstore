package gp.swd20.bookstore.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gp.swd20.bookstore.domain.Book;
import gp.swd20.bookstore.domain.BookRepository;
import gp.swd20.bookstore.domain.CategoryRepository;
//IMPORT domain categoryrepository!!!!!

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository drepository;
	
	// http://localhost:8080/booklist
	@RequestMapping(value="booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist"; //booklist.html
	}
	
	//REST kaikki kirjat books
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) repository.findAll();
	} 
	
	//REST kirja id:llä
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return repository.findById(bookId);
	}
	
	//REST lisää kirja
	@RequestMapping(value="books", method = RequestMethod.POST)
	public @ResponseBody Book addNewBookRest(@RequestBody Book book) {
		return repository.save(book);
	}
	
	
	//tyhjä lomake uudesta kirjasta
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", drepository.findAll());
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

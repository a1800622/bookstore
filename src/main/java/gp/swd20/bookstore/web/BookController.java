package gp.swd20.bookstore.web;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gp.swd20.bookstore.domain.Book;

@Controller
public class BookController {

	private ArrayList<Book> books = new ArrayList<Book>();
	@GetMapping("/index")
	public String newBook(Model model) {
		Book book = new Book();
		model.addAttribute("books", books);
		model.addAttribute("book", book);
		return "index";
	}
	
	@PostMapping("/index")
	public String addBook(@ModelAttribute Book book, Model model) {
		books.add(book);
		model.addAttribute("book", book);
		return "redirect:/index";
	}
	
}

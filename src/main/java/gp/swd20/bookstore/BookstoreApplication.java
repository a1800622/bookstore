package gp.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gp.swd20.bookstore.domain.Book;
import gp.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Saving some books");
			repository.save(new Book("The complete Robot","Isaac Asimov",1982,"0-385-17724-0",20));
			repository.save(new Book("Lord of the flies","William Golding",1954,"0-571-05686-5",25));
			
			log.info("Fetching all of the books");
			for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}


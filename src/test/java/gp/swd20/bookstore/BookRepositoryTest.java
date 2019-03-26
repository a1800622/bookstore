package gp.swd20.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import gp.swd20.bookstore.domain.Book;
import gp.swd20.bookstore.domain.BookRepository;
import gp.swd20.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository brepository;
	//findByAuthor
	
	@Test
	public void findByAuthorShouldReturnBook() {
		
		List<Book> books = brepository.findByAuthor("William Golding");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Lord of the flies");
	}
	
	//create test
	
	@Test
	public void createTest() {
		Book book = new Book("title Test","author Test",0,"isbn Test",0, new Category("cat Test"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
		
	}
	
	//find test
	
	@Test
	public void findByAuthorShouldReturnTest() {
		
		List<Book> books = brepository.findByAuthor("author Test");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("title Test");
	}
	
	
}

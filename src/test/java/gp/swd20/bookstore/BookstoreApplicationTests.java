package gp.swd20.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import gp.swd20.bookstore.web.BookController;
import gp.swd20.bookstore.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	//Book

	@Autowired
	private BookController Bcontroller;
	
	@Test
	public void contextLoadsBook() throws Exception {
		assertThat(Bcontroller).isNotNull();
	}
	
	//User
	
	@Autowired
	private UserController Ucontroller;
	
	@Test
	public void contextLoadsUser() throws Exception {
		assertThat(Ucontroller).isNotNull();
	}

}



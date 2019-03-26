package gp.swd20.bookstore;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import gp.swd20.bookstore.domain.CategoryRepository;
import gp.swd20.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;
	//findByName
	
		@Test
		public void findByName() {
			
			List<Category> categories = crepository.findByName("SciFi");
			
			assertThat(categories).hasSize(1);
			assertThat(categories.get(0).getName()).isEqualTo("SciFi");
		}
		
		//create new category
		
		@Test
		public void createCategory() {
			Category category = new Category("testcat");
			crepository.save(category);
			assertThat(category.getCategoryid()).isNotNull();
			
		}
		
}
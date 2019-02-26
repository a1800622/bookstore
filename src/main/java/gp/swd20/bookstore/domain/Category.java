package gp.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	//Category OneToMany Book
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	//getters
	
	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	//setters

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
}

package cst438;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class MovieRating {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=1, max=25)
	private String title;
	
	@NotNull
	@Range(min=1, max=5)
	private int rating;
	
	@NotNull
	@Size(min=3, max=25)
	private String name;
	
	private String dateTime;
	
	public MovieRating() {
		
	}

	public MovieRating(long id, @NotNull String title, @NotNull int rating, @NotNull String name, String dateTime) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.name = name;
		this.dateTime = dateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}

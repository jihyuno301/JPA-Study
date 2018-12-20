package net.skhu.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookModel {
	
	@NotEmpty
	@Size(min=3, max=10)
	String title;
	
	@NotEmpty
	@Size(min=3, max=10)
	String author;
	
	
	Integer categoryId;
	
	
	Integer price;
	
	
	Integer publisherId;
	
	//available 0으로 디폴트
	
	
}

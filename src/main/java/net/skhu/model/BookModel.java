package net.skhu.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookModel {
	
	@NotEmpty(message="책 제목을 입력하세요")
	@Size(min=5, max=10)
	String title;
	
	@NotEmpty
	@Size(min=3, max=10, message="저자의 이름을 3자 이상으로 적으세요")
	String author;
	
	
	Integer categoryId;
	
	
	Integer price;
	
	
	Integer publisherId;
	
	//available 0으로 디폴트
	
	
}

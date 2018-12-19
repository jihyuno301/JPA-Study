package net.skhu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude= {"books"})
@EqualsAndHashCode(exclude= {"books"})
@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	String title;
	
	@JsonIgnore
	@OneToMany(mappedBy="category", fetch=FetchType.LAZY)
	List<Book> books;
}

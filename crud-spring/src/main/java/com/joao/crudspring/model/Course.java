package com.joao.crudspring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
//data lombok, gera automaticamente getter e setters, equals etc. Porém nao fez, n sei porque
@Entity
//Irá fazer o mapeamento com banco de dados. 
//@Table (name = "qualquer outro nome")//

@NoArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 200, nullable = false)//(name ="qualquernome") - nullable = false = não nulo
	private String name;
	
	@Column(length = 200, nullable = false)//(name ="qualquernome")
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Course() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", category=" + category + "]";
	} 
	
	
	
	
	

}

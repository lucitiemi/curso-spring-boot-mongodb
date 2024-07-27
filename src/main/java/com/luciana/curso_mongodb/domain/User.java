package com.luciana.curso_mongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user") 		// nao precisaria do valor em parenteses, pois, por padrao, a colecao já eh criada com o nome da classe em minusculo. Só é necessario quando se deseja criar um nome diferente para a colecao
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// atributos
	@Id
	private String id;
	private String name;
	private String email;
	
	// associacoes
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
	
	
	
	// construtores
	public User() {}
	
	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	
	

	// getters e setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	
	
	// hash e equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}

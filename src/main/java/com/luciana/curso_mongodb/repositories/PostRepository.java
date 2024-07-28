package com.luciana.curso_mongodb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.luciana.curso_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	// Consulta simples com @Query
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	
	// Consulta simples com query methods
	List<Post> findByTitleContainingIgnoreCase(String title);
	
	
	// Consulta com vários critérios
	@Query("{ $and: [ {date: {$gte: ?1}}, {date: { $lte: ?2}} , {$or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}

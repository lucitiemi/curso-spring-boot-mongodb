package com.luciana.curso_mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luciana.curso_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}

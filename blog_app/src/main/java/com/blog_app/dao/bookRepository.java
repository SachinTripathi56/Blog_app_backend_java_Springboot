package com.blog_app.dao;
import org.springframework.data.repository.CrudRepository;

import com.blog_app.entities.book;


public interface bookRepository extends CrudRepository<book, Integer> {
    
    public book findById(int id);
}

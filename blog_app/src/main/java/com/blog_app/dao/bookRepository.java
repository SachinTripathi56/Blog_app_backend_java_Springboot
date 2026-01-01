package com.blog_app.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blog_app.entities.book;


public interface bookRepository extends CrudRepository<book, Integer> {
    
    public List<book> findById(int id);
}

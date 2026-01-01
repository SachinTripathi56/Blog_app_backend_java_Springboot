package com.blog_app.services;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.blog_app.entities.book;

@Component
public class bookservice {
    
    
    private static List<book> list = new ArrayList<>();

    static {
        list.add(new book(1 , "hello from here" , "Sachin"));
        list.add(new book(2 , "hello from there" , "XYZ"));
        list.add(new book(3, "hello from here11" , "TRipathi"));
    }

    public List<book> getallbooks( ){
        return list;
    }
    public book getbyid(int id ){
        book b = null;
       
         b = list.stream().filter(e->e.getId()==id).findFirst().get();
          return b;
    }

    public void addbook(book book){
        list.add(book);
    }

    public void deletebook(int id ){
        list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
    }
    

    public void updateBook(book book , int id){
        list =list.stream().map(e->{
            if(e.getId() == id){
                e.setName(book.getName());
                e.setAuthor(book.getAuthor());
            }
            return e;
        }).collect(Collectors.toList());
    }
}

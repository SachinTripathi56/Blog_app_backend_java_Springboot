package com.blog_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog_app.dao.bookRepository;
import com.blog_app.entities.book;

@Component
public class bookservice {

    @Autowired
    private bookRepository bookRepository;
    
    // private static List<book> list = new ArrayList<>();

    // static {
    //     list.add(new book(1 , "hello from here" , "Sachin"));
    //     list.add(new book(2 , "hello from there" , "XYZ"));
    //     list.add(new book(3, "hello from here11" , "TRipathi"));
    // }

    public List<book> getallbooks( ){

        List<book> book = (List<book>) this.bookRepository.findAll();
        return book;
    }
    public book getbyid(int id ){
        book b = null;
       
        //  b = list.stream().filter(e->e.getId()==id).findFirst().get();
        //   return b;
        b = this.bookRepository.findById(id);
        return b ; 

    }

    public book addbook(book book){

        // list.add(book);

       return  this.bookRepository.save(book);
    }

    public void deletebook(int id ){
        // list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());

        this.bookRepository.deleteById(id);
    }
    

    public void updateBook(book book , int id){
        // list =list.stream().map(e->{
        //     if(e.getId() == id){
        //         e.setName(book.getName());
        //         e.setAuthor(book.getAuthor());
        //     }
        //     return e;
        // }).collect(Collectors.toList());
         book b = book;
        b.setId(id);
        this.bookRepository.save(book);
    }
}

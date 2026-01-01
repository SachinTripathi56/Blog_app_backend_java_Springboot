package com.blog_app.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog_app.entities.book;
import com.blog_app.services.bookservice;





@RestController
public class BookController {

   

    @Autowired
    private bookservice bookservice;
    
    @GetMapping("/books")
   public ResponseEntity<List<book>> getbook(){
    List<book> list = this.bookservice.getallbooks();
    if(list.size()<=0){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(list));
   }
   
   @GetMapping("/book/{id}")
   public ResponseEntity< book> getbook(@PathVariable("id") int id) {
          book book = bookservice.getbyid(id);

          if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }
       return ResponseEntity.of(Optional.of(book));
   }

   @PostMapping("/books")
   public ResponseEntity<book> postMethodName(@RequestBody book book) {
      book b =null;
     try {    
        b = this.bookservice.addbook(book);

     return ResponseEntity.status(HttpStatus.CREATED).body(b);
     }  

     catch(Exception e){ 
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
      
   }

   @DeleteMapping("/books/{id}")
   public ResponseEntity< List<book>> deletebook(@PathVariable("id") int id ){
     try {
          this.bookservice.deletebook(id);
          List<book> list = this.bookservice.getallbooks();
    return ResponseEntity.of(Optional.of(list));
     } catch (Exception e) {

      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }

   }
   
   @PutMapping("books/{id}")
   public ResponseEntity<List<book>> updatebook(@PathVariable int id, @RequestBody book book) {
       
      try{
 this.bookservice.updateBook(book, id);
    return ResponseEntity.of(Optional.of(this.bookservice.getallbooks()));
      }
      catch(Exception e){
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
   }
   
     
      
}

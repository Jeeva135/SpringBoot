package com.student.ust.controller;

import com.student.ust.entity.Book;
import com.student.ust.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/{id}")
    public ResponseEntity<Book>
    get(@PathVariable Integer id) {
        try {

            Book book = bookService.getBookByID(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/books")
    public void add(@RequestBody Book book) {
        bookService.saveBook(book);
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> get(){
        try{
            List<Book>bookList=bookService.getAllBook();
            return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);

        }
        catch(NoSuchElementException e){
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable Integer id){
        bookService.deleteId(id);
    }
    @PutMapping("/books")
    public ResponseEntity<Book>put(@RequestBody Book book){
        try{
            Book updateBook=bookService.updateBook(book);
            return  new ResponseEntity<Book>(book,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return  new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

}

package com.tianjiqx.controller;


import com.tianjiqx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by tianjiqx on 2017/6/26.
 */
@RestController
public class RibbonController {
    @Autowired
    private BookService bookService;


    @GetMapping(value = "/book/books")
    public List<java.lang.Object> bookList(){
        return bookService.bookList();
    }
    @PostMapping(value = "/book/add")
    public Object addBook(@RequestParam("bookName") String bookName,
                        @RequestParam("author") String author,
                        @RequestParam("description") String description,
                        @RequestParam("publishDate") String publishDate){

        return bookService.addBook(bookName,author,description,publishDate);
    }
    @GetMapping(value = "/book/{id}")
    public java.lang.Object bookFindOne(@PathVariable("id") Integer id)
    {
        return bookService.bookFindOne(id);
    }

    @GetMapping(value = "/book/findByAuthor")
    public List<java.lang.Object> bookListByAuthor(@RequestParam("author") String author)
    {
        return bookService.findByAuthor(author);
    }

    @PutMapping(value ="/book/update/{id}")
    public Object bookUpdate(@PathVariable("id") Integer id,
                           @RequestParam("bookName") String bookName,
                           @RequestParam("author") String author,
                           @RequestParam("description") String description,
                           @RequestParam("publishDate") String publishDate){
        return bookService.bookUpdate(id,bookName,author,description,publishDate);

    }

    @DeleteMapping(value = "/book/delete/{id}")
    public void bookDelete(@PathVariable("id") Integer id)
    {
        bookService.bookDelete(id);
    }



}

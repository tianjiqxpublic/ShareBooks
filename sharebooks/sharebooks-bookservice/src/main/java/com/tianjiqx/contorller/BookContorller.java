package com.tianjiqx.contorller;

import com.tianjiqx.dao.BookRepo;
import com.tianjiqx.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianjiqx on 2017/6/25.
 */
@RestController
public class BookContorller {
    @Autowired
    private BookRepo bookRepo;

    //查找所有的书
    @GetMapping(value = "/book/books")
    public List<Book> bookList()
    {
        return bookRepo.findAll();
    }
    //增加一本书
    @PostMapping(value = "/book/add")
    public Book addBook(@RequestParam("bookName") String bookName,
                        @RequestParam("author") String author,
                        @RequestParam("description") String description,
                        @RequestParam("publishDate") String publishDate){
        System.out.println(bookName+" "+ author + " "+ description+ " " +publishDate);
        Book book = new Book(bookName,author,description,publishDate);
        return bookRepo.save(book);
    }

    //按书id查找
    @GetMapping(value = "/book/{id}")
    public Book bookFindOne(@PathVariable("id") Integer id){
        return bookRepo.findOne(id);
    }
    //按作者查找
    @GetMapping(value = "/book/findByAuthor")
    public List<Book> bookListByAuthor(@RequestParam("author") String author){
        return bookRepo.findBookByAuthor(author);
    }
    //更新一本书
    @PutMapping(value ="/book/update/{id}")
    public Book bookUpdate(@PathVariable("id") Integer id,
                           @RequestParam("bookName") String bookName,
                           @RequestParam("author") String author,
                           @RequestParam("description") String description,
                           @RequestParam("publishDate") String publishDate){

        Book book = new Book(bookName,author,description,publishDate);
        book.setId(id);

        return bookRepo.save(book);
    }
    //删除一本书
    @DeleteMapping(value = "/book/delete/{id}")
    public void bookDelete(@PathVariable("id") Integer id)
    {
        bookRepo.delete(id);
    }



}

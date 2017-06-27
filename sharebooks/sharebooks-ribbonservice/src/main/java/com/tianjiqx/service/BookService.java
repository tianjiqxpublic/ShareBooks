package com.tianjiqx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjiqx on 2017/6/26.
 */
@Service
public class BookService {
    @Autowired
    RestTemplate restTemplate;
    private String errorMsg = "sorry, bookservice call fail.";
    @HystrixCommand(fallbackMethod = "bookListError")
    public List<java.lang.Object> bookList()
    {
        return restTemplate.getForObject("http://SHAREBOOKS-BOOKSERVICE//book/books", ArrayList.class);
    }
    public List<java.lang.Object>  bookListError()
    {
        return null;
    }
    @HystrixCommand(fallbackMethod = "bookError")
    public java.lang.Object addBook(@RequestParam("bookName") String bookName,
                        @RequestParam("author") String author,
                        @RequestParam("description") String description,
                        @RequestParam("publishDate") String publishDate) {
        System.out.println("http://SHAREBOOKS-BOOKSERVICE//book/add"+
                        "?bookName="+bookName+"&author="+author +"&description="+description+"&publishDate="+publishDate);

        return restTemplate.postForLocation("http://SHAREBOOKS-BOOKSERVICE//book/add"+
            "?bookName="+bookName+"&author="+author +"&description="+description+"&publishDate="+publishDate,
                Object.class);
    }
    public  java.lang.Object bookError(@RequestParam("bookName") String bookName,
                                       @RequestParam("author") String author,
                                       @RequestParam("description") String description,
                                       @RequestParam("publishDate") String publishDate)
    {
        return null;
    }

    @HystrixCommand(fallbackMethod = "bookFindOneError")
    public java.lang.Object bookFindOne(@PathVariable("id") Integer id)
    {
        return restTemplate.getForObject("http://SHAREBOOKS-BOOKSERVICE//book/"+id,Object.class);
    }
    public java.lang.Object bookFindOneError(@PathVariable("id") Integer id)
    {
        return null;
    }
    @HystrixCommand(fallbackMethod = "bookError")
    public java.lang.Object bookUpdate(@PathVariable("id") Integer id,
                             @RequestParam("bookName") String bookName,
                             @RequestParam("author") String author,
                             @RequestParam("description") String description,
                             @RequestParam("publishDate") String publishDate)
    {
        java.lang.Object object =new java.lang.Object();
        restTemplate.put("http://SHAREBOOKS-BOOKSERVICE//book/update/"+id+"?"+
                        "bookName="+bookName+"&author="+author +"&description="+description+"&publishDate="+publishDate,
                Object.class,object);

        return object;
    }

    @HystrixCommand(fallbackMethod = "Error")
    public void bookDelete(@PathVariable("id") Integer id){
        restTemplate.delete("http://SHAREBOOKS-BOOKSERVICE//book/delete/"+id);
    }


    @HystrixCommand(fallbackMethod = "bookListError")
    public List<java.lang.Object> findByAuthor(@RequestParam("author") String author)
    {
        System.out.println("http://SHAREBOOKS-BOOKSERVICE//book/findByAuthor"+"?author="+author);
        return restTemplate.getForObject("http://SHAREBOOKS-BOOKSERVICE//book/findByAuthor"+"?author="+author,ArrayList.class);
    }
    public List<java.lang.Object> bookListError(@RequestParam("author") String author)
    {
        return null;
    }

    public void Error(@PathVariable("id") Integer id)
    {
    }
    public java.lang.Object bookError(@PathVariable("id") Integer id,
                                      @RequestParam("bookName") String bookName,
                                      @RequestParam("author") String author,
                                      @RequestParam("description") String description,
                                      @RequestParam("publishDate") String publishDate)
    {
        return null;
    }


}

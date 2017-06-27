package com.tianjiqx.dao;

import com.tianjiqx.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tianjiqx on 2017/6/25.
 */
public interface BookRepo extends JpaRepository<Book,Integer> {
    //根据作者查找书
    public List<Book> findBookByAuthor(String author);
}

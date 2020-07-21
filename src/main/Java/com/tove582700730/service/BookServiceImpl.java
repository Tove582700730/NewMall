package com.tove582700730.service;

import com.tove582700730.dao.BookMapper;
import com.tove582700730.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookByTypeId(Integer tid) {
        List<Book> bookList = bookMapper.getBookByTypeId(tid);
        return bookList;
    }

    @Override
    public Book getBookDetailById(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }
}

package com.tove582700730.service;

import com.tove582700730.pojo.Book;

import java.util.List;

public interface BookService {
    /**
     * 根据类型id查询所有图书
     * @param tid
     * @return
     */
    List<Book> getBookByTypeId(Integer tid);

    /**
     * 根据图书id查询详情
     * @param bid
     * @return
     */
    Book getBookDetailById(Integer bid);

}

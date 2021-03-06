package com.tove582700730.dao;
import com.tove582700730.pojo.Book;
import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);


    int insert(Book record);

    Book selectByPrimaryKey(Integer bookId);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);

    /**
     * 根据类型id查询图书列表
     * @param tid
     * @return
     */
    List<Book> getBookByTypeId(Integer tid);

}

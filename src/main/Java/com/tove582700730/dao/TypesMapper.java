package com.tove582700730.dao;
import com.tove582700730.pojo.Types;
import java.util.List;
public interface TypesMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Types record);

    Types selectByPrimaryKey(Integer tid);

    List<Types> selectAll();

    int updateByPrimaryKey(Types record);
}

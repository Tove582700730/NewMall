package com.tove582700730.dao;
import com.tove582700730.pojo.OrderDetail;
import com.tove582700730.pojo.Orders;
import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer oid);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);

    /**
     * 添加订单主表内容
     * @param orders
     */
    void addOrder(Orders orders);

}

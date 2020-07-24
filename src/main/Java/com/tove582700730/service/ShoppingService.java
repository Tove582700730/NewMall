package com.tove582700730.service;

import com.tove582700730.pojo.Shopping;
import com.tove582700730.util.ResultVo;

import javax.servlet.http.HttpSession;

public interface ShoppingService {
    /**
     * 添加到购物车
     * @param shopping
     * @param session
     * @return
     */
    ResultVo addShopping(Shopping shopping, HttpSession session);

    ResultVo getShoppingList(HttpSession session);
}

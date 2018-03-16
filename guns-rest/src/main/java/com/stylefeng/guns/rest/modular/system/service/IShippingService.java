package com.stylefeng.guns.rest.modular.system.service;

import com.github.pagehelper.PageInfo;
import com.stylefeng.guns.rest.modular.system.common.ServerResponse;
import com.stylefeng.guns.rest.modular.system.pojo.Shipping;

/**
 * Created by geely
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse<String> del(Integer userId, Integer shippingId);
    ServerResponse update(Integer userId, Shipping shipping);
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}

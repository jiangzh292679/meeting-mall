package com.stylefeng.guns.modular.business.service;

import com.github.pagehelper.PageInfo;
import com.stylefeng.guns.modular.business.common.ServerResponse;
import com.stylefeng.guns.modular.business.pojo.Product;
import com.stylefeng.guns.modular.business.vo.ProductDetailVo;

/**
 * Created by geely
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);



}

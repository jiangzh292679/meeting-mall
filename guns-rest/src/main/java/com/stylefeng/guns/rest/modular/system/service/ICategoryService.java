package com.stylefeng.guns.rest.modular.system.service;

import com.stylefeng.guns.rest.modular.system.common.ServerResponse;
import com.stylefeng.guns.rest.modular.system.pojo.Category;

import java.util.List;

/**
 * Created by geely
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}

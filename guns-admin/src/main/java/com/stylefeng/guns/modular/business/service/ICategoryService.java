package com.stylefeng.guns.modular.business.service;



import com.stylefeng.guns.modular.business.common.ServerResponse;
import com.stylefeng.guns.modular.business.pojo.Category;

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

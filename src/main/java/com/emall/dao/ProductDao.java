package com.emall.dao;

import com.emall.common.ServerResponse;
import com.emall.pojo.Product;
import com.emall.vo.ProductDetailVo;
import com.emall.vo.ProductListVo;
import com.emall.vo.ProductSerarchVo;
import com.emall.vo.UploadVo;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public interface ProductDao {
    Product findById(Integer id) throws Exception;
    int updateProductStatus(@Param("id") Integer id,@Param("status") Integer status) throws Exception;
    int saveOrUpdateProduct(Product product) throws Exception;
    ProductDetailVo showById(Integer id) throws Exception;
    List<ProductSerarchVo> findByIdOrName(@Param("id") Integer id,@Param("name") String name) throws Exception;
    List<ProductListVo> findAll() throws Exception;
    List<ProductListVo> findListByKeyword(@Param("categoryId") Integer categoryId, @Param("name") String keyword) throws Exception;
    public int uploadImage(@Param("productId") Integer productId, @Param("uri") String uri) throws Exception;

    public int fullUploadImage(@Param("productId") Integer productId, @Param("uri") String uri) throws Exception;

}

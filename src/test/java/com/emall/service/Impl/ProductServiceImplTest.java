package com.emall.service.Impl;

import com.emall.common.ServerResponse;
import com.emall.pojo.Product;
import com.emall.service.Iservice.ProductService;
import com.emall.vo.ProductDetailVo;
import com.emall.vo.ProductSerarchVo;
import com.github.pagehelper.PageInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public class ProductServiceImplTest {
    ApplicationContext context;

    private ProductService productService;
    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        productService = context.getBean(ProductService.class);

    }

    @After
    public void tearDown() throws Exception {
        context = null;
        productService = null;
    }

    @Test
    public void testFindById() throws Exception {

       ServerResponse<Product> product = productService.findById(28);
        System.out.println(product);

    }
    @Test
    public void testupdateProductStatus() throws Exception{
        ServerResponse<Product> productServerResponse = productService.updateProductStatus(27,1);
        System.out.println(productServerResponse);
    }
    @Test
    public void testsaveOrUpdateProduct() throws Exception{
        Product product = new Product(27,100006,"Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用","送品牌烤箱，五一大促","ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg","ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg,4bb02f1c-62d5-48cc-b358-97b05af5740d.jpeg,36bdb49c-72ae-4185-9297-78829b54b566.jpeg","<p><img alt=\"miaoshu.jpg\" src=\"http://img.mmall.com/9c5c74e6-6615-4aa0-b1fc-c17a1eff6027.jpg\" width=\"790\" height=\"444\"><br></p><p><img alt=\"miaoshu2.jpg\" src=\"http://img.mmall.com/31dc1a94-f354-48b8-a170-1a1a6de8751b.jpg\" width=\"790\" height=\"1441\"><img alt=\"miaoshu3.jpg\" src=\"http://img.mmall.com/7862594b-3063-4b52-b7d4-cea980c604e0.jpg\" width=\"790\" height=\"1442\"><img alt=\"miaoshu4.jpg\" src=\"http://img.mmall.com/9a650563-dc85-44d6-b174-d6960cfb1d6a.jpg\" width=\"790\" height=\"1441\"><br></p>",new BigDecimal(4200),8000,1);
        ServerResponse<Product> productServerResponse = productService.saveOrUpdateProduct(product);
        System.out.println(productServerResponse);
    }
    @Test
    public void testshowById() throws Exception{
       ServerResponse<ProductDetailVo> productDetailVoServerResponse =  productService.showById(2);
        System.out.println(productDetailVoServerResponse);
    }

    @Test
    public void testfindByIdOrName(){
        ServerResponse<PageInfo<ProductSerarchVo>> pageInfoServerResponse = productService.findByIdOrName(null,"i",null,null);
        System.out.println(pageInfoServerResponse);
    }
}
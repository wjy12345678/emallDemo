package com.emall.controller;

import com.emall.common.ServerResponse;
import com.emall.pojo.Product;
import com.emall.service.Iservice.ProductService;
import com.emall.vo.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Controller
@RequestMapping("/manage/product/")
public class ProdAction {

    @Autowired
    private ProductService productService;

    /**
     * 后台-----商品上架下架
     * @param productId
     * @param status
     * @return
     */
    @RequestMapping(value = "set_sale_status.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Product> updateProductStatus(Integer productId, Integer status){

       return productService.updateProductStatus(productId,status);

    }

    /**
     * 后台----添加或更新商品
     * @param product
     * @return
     */
    @RequestMapping(value = "save.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Product> saveOrUpdateProduct(Product product){

        return productService.saveOrUpdateProduct(product);
    }

    /**
     * 后台---通过商品id查看商品详情
     * @param productId
     * @param session
     * @return
     */
    @RequestMapping(value = "detail.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ProductDetailVo> showById(Integer productId, HttpSession session){
        ServerResponse<ProductDetailVo> productDetailVoServerResponse =  productService.showById(productId);
        if (productDetailVoServerResponse.getStatus() == 1){
            session.setAttribute("productId",productId);
        }
        return productService.showById(productId);
    }

    /**
     * 后台-----通过商品id或商品名称搜索商品
     * @param productId
     * @param productName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "search.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo<ProductSerarchVo>> findByIdOrName(Integer productId, String productName, Integer pageNum, Integer pageSize){
        return productService.findByIdOrName(productId,productName,pageNum,pageSize);
    }

    /**
     * 后台----查看商品列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo<ProductListVo>> findAll(Integer pageNum,Integer pageSize){
        return productService.findAll(pageNum,pageSize);
    }

    /**
     * 后台----图片上传
     * @param pathUri
     * @param session
     * @return
     */
    @RequestMapping(value = "upload.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UploadVo> uploadImage( String pathUri,HttpSession session){

        Integer productId = (Integer) session.getAttribute("productId");
        return productService.uploadImage(productId,pathUri);
    }

    /**
     * 后台-----富文本上传
     * @param pathUri
     * @param session
     * @return
     */
    @RequestMapping(value = "richtext_img_upload.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<FullUploadVo> fullUploadImage(String pathUri[], HttpSession session){

        Integer productId = (Integer) session.getAttribute("productId");

        return productService.fullUploadImage(productId,pathUri);
    }
}

package com.lizl.eshop.service;

import com.lizl.eshop.service.fallback.EshopProductServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lizhaoliang on 18/2/24.
 */
@FeignClient(value = "eshop-product-service", fallback = EshopProductServiceFallBack.class)
public interface EshopProductService {

    @RequestMapping(value = "/brand/findById",method = RequestMethod.GET)
    String findBrandById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/brand/findByIds",method = RequestMethod.GET)
    String findBrandByIds(@RequestParam(value = "ids") String ids);

    @RequestMapping(value = "/category/findById",method = RequestMethod.GET)
    String findCategoryById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/product-intro/findById",method = RequestMethod.GET)
    String findProductIntroById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/product-property/findById",method = RequestMethod.GET)
    String findProductPropertyById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/product-property/findByProductId",method = RequestMethod.GET)
    String findProductPropertyByProductId(@RequestParam(value = "productId") Integer productId);

    @RequestMapping(value = "/product/findById",method = RequestMethod.GET)
    String findProductById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/product-specification/findById",method = RequestMethod.GET)
    String findProductSpecificationById(@RequestParam(value = "id") Integer id);

    @RequestMapping(value = "/product-specification/findByProductId",method = RequestMethod.GET)
    String findProductSpecificationByProductId(@RequestParam(value = "productId") Integer productId);
}
package com.lizl.eshop.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.lizl.eshop.service.EshopProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lizhaoliang on 18/3/13.
 */
@RestController
public class DataLinkController {

    @Autowired
    private  EshopProductService eshopProductService;
    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/getProduct")
    @ResponseBody
    public String getProduct(Integer productId){

        Jedis jedis = jedisPool.getResource();

        String dimProductJSON = jedis.get("dim_product_" + productId);

        if(StringUtils.isEmpty(dimProductJSON)){

            String productDataJSON = eshopProductService.findProductById(productId);

            if(StringUtils.isNotEmpty(productDataJSON)){
                JSONObject prductDataJSONObject = JSONObject.parseObject(productDataJSON);

                String productPropertyDataJSON = eshopProductService.findProductPropertyByProductId(prductDataJSONObject.getInteger("id"));

                if(StringUtils.isNotEmpty(productPropertyDataJSON)){
                    prductDataJSONObject.put("product_property",JSONObject.parse(productPropertyDataJSON));
                }

                String productSpecificationDataJSON = eshopProductService.findProductSpecificationByProductId(prductDataJSONObject.getInteger("id"));

                if(StringUtils.isNotEmpty(productSpecificationDataJSON)){
                    prductDataJSONObject.put("product_specification", JSONObject.parse(productSpecificationDataJSON));
                }

                jedis.set("dim_product_" + productId, prductDataJSONObject.toJSONString());

                return prductDataJSONObject.toJSONString();
            }

        }

        return "";
    }
}

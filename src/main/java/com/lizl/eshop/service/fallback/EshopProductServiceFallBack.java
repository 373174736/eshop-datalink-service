package com.lizl.eshop.service.fallback;

import com.lizl.eshop.service.EshopProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lizhaoliang on 18/3/14.
 */
@Component
public class EshopProductServiceFallBack implements EshopProductService{
    @Override
    public String findBrandById(@RequestParam(value = "id") Integer id) {
        return null;
    }

    @Override
    public String findBrandByIds(@RequestParam(value = "ids") String ids) {
        return null;
    }

    @Override
    public String findCategoryById(@RequestParam(value = "id") Integer id) {
        return null;
    }

    @Override
    public String findProductIntroById(@RequestParam(value = "id") Integer id) {
        return null;
    }

    @Override
    public String findProductPropertyById(@RequestParam(value = "id") Integer id) {
        return null;
    }

    @Override
    public String findProductPropertyByProductId(@RequestParam(value = "productId") Integer productId) {
        return null;
    }

    @Override
    public String findProductById(@RequestParam(value = "id") Integer id) {
        return null;
    }

    @Override
    public String findProductSpecificationById(@RequestParam(value = "id") Integer id) {
        return null;
    }

    @Override
    public String findProductSpecificationByProductId(@RequestParam(value = "productId") Integer productId) {
        return null;
    }
}

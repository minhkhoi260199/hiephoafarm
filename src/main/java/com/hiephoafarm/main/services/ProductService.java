package com.hiephoafarm.main.services;

import com.hiephoafarm.main.models.ProductE;
import com.hiephoafarm.main.repositories.ProductRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService {

    ProductRepos productRepos;

    public List<ProductE> findAll(){
        return productRepos.findAll();
    }
    public ProductE save(ProductE productE){
        return productRepos.save(productE);
    }
}

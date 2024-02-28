package com.shoppingcart.product.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.shoppingcart.product.model.ProductDTO;

public interface ProductRepository extends MongoRepository<ProductDTO, String>
{
  ProductDTO findByProductName(String productName);
  List<ProductDTO> findByCategory(String category);
  List<ProductDTO> findByProductType(String productType);
}


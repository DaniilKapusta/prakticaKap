package com.example.demo.Repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {
    public List<ProductEntity> findByProductName(String productName);
    @Transactional
    @Modifying
    @Query(value = "UPDATE PRODUCT_ENTITY SET product_Count = :uppProductCount WHERE ID = :id", nativeQuery = true)
  public void updateProductCountById(@Param("id") Long id, @Param("uppProductCount") Integer uppProductCount);

   // public ProductEntity addProduct(ProductEntity productEntity);
}

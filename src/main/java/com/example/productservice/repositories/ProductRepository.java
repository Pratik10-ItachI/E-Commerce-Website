package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Product save(Product entity);

    @Override
    void delete(Product entity);

    @Override
    List<Product>  findAll();

    Optional<Product> findProductById(Long id);

    @Query(
            value = "SELECT title FROM product WHERE lower(title) LIKE CONCAT('%', LOWER(:searchKey), '%')",
            nativeQuery = true)
    List<String> findAllPhones(@Param("searchKey") String searchKey);

}

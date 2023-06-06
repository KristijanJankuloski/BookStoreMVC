package com.chrissj.bookstore.repository;

import com.chrissj.bookstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p join Author a join Category c where concat(p.name, p.description, a.fullName, c.name) like '%:keyowrd%'")
    List<Product> findByKeyword(@Param("keyword") String keyword);
    @Query("select p from Product p where p.category.id = :categoryId")
    List<Product> getAllByCategoryId(@Param("categoryId") int categoryId);

    @Query("select p from Product p where p.publisher.id = :publisherId")
    List<Product> getALlByPublisherId(@Param("publisherId") int publisherId);

    @Query("select  p from Product p join p.authors a where a.id = :authorId")
    List<Product> getAllByAuthorId(@Param("authorId") int authorId);
    @Query("select count(p) from Product p join p.authors a where a.id = :authorId")
    int CountWithAuthorId(@Param("authorId") int authorId);
}

package com.aprendendo2.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo2.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

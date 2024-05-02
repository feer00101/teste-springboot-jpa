package com.aprendendo2.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo2.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

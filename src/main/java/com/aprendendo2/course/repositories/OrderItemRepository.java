package com.aprendendo2.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo2.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

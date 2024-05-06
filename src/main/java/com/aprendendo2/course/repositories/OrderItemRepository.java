package com.aprendendo2.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo2.course.entities.OrderItem;
import com.aprendendo2.course.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}

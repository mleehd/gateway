package com.apria.gateway.validation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apria.gateway.validation.model.EDIOrder;

@Repository("ediOrderRepository")
public interface EDIOrderRepository extends JpaRepository<EDIOrder, Long> {

	EDIOrder findByediOrderId(String ediOrderId);
}

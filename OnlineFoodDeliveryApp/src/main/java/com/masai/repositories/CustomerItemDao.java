package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerItem;

public interface CustomerItemDao extends JpaRepository<CustomerItem, Integer> {

}

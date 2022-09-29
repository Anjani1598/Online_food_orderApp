package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Bill;

public interface BillDao extends JpaRepository<Bill, String> {

}

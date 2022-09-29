package com.masai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Item;

public interface ItemDao extends JpaRepository<Item, String> {

}

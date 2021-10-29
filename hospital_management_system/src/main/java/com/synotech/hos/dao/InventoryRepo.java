package com.synotech.hos.dao;

import com.synotech.hos.controllers.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> {
}

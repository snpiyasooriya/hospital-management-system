package com.synotech.hos.services;

import com.synotech.hos.controllers.Inventory;
import com.synotech.hos.dao.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    final InventoryRepo inventoryRepo;

    @Autowired
    public InventoryService(InventoryRepo inventoryRepo){
            this.inventoryRepo = inventoryRepo;
    }

    public List<Inventory> getInventory(){
        return inventoryRepo.findAll();
    }

    public  Inventory save(Inventory newInventory){
        return inventoryRepo.save(newInventory);
    }
}

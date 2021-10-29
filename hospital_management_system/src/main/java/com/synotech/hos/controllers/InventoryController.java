package com.synotech.hos.controllers;

import com.synotech.hos.dao.DoctorRepo;
import com.synotech.hos.model.Doctor;
import com.synotech.hos.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@RestController
@RequestMapping(path = "api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getAllInventoryItems(){
        return inventoryService.getInventory();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> create(@RequestBody
                                                 Inventory newInventory
    ) throws SerialException {

        Inventory inventory = inventoryService.save(newInventory);
        if (inventory == null) {
            throw new SerialException();
        } else {
            return new ResponseEntity<>(inventory, HttpStatus.CREATED);
        }
    }

}

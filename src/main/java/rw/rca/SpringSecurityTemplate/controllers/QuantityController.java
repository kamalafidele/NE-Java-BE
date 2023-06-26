package rw.rca.SpringSecurityTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.SpringSecurityTemplate.Models.Quantity;
import rw.rca.SpringSecurityTemplate.Services.QuantityService;

@RestController
@RequestMapping("/api/quantities")
public class QuantityController {
    private final QuantityService quantityService;

    @Autowired
    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @GetMapping
    public ResponseEntity<?> getAllQuantities() {
        return ResponseEntity.ok(quantityService.getAllQuantities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuantityById(@PathVariable Long id) {
        Quantity quantity = quantityService.getQuantityById(id);
        if (quantity != null) {
            return ResponseEntity.ok(quantity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quantity not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> createQuantity(@RequestBody Quantity quantity) {
        Quantity createdQuantity = quantityService.saveQuantity(quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuantity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuantity(@PathVariable Long id) {
        quantityService.deleteQuantity(id);
        return ResponseEntity.noContent().build();
    }
}

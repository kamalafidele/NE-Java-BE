package rw.rca.SpringSecurityTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.SpringSecurityTemplate.Models.Purchased;
import rw.rca.SpringSecurityTemplate.Services.PurchasedService;

@RestController
@RequestMapping("/api/purchased")
public class PurchasedController {
    private final PurchasedService purchasedService;

    @Autowired
    public PurchasedController(PurchasedService purchasedService) {
        this.purchasedService = purchasedService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasedItems() {
        return ResponseEntity.ok(purchasedService.getAllPurchasedItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchasedItemById(@PathVariable Long id) {
        Purchased purchased = purchasedService.getPurchasedItemById(id);
        if (purchased != null) {
            return ResponseEntity.ok(purchased);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Purchased item not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> createPurchasedItem(@RequestBody Purchased purchased) {
        Purchased createdPurchasedItem = purchasedService.savePurchasedItem(purchased);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPurchasedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchasedItem(@PathVariable Long id) {
        purchasedService.deletePurchasedItem(id);
        return ResponseEntity.noContent().build();
    }
}

package rw.rca.SpringSecurityTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.SpringSecurityTemplate.Models.Product;
import rw.rca.SpringSecurityTemplate.Models.Purchased;
import rw.rca.SpringSecurityTemplate.Pojos.Request.PurchasedRequest;
import rw.rca.SpringSecurityTemplate.Services.ProductService;
import rw.rca.SpringSecurityTemplate.Services.PurchasedService;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/purchased")
public class PurchasedController {
    private final PurchasedService purchasedService;
    private final ProductService productService;

    @Autowired
    public PurchasedController(PurchasedService purchasedService, ProductService productService) {
        this.purchasedService = purchasedService;
        this.productService = productService;
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
    public ResponseEntity<?> createPurchasedItem(@RequestBody PurchasedRequest purchasedRequest) {
        Optional<Product> product = productService.getProductById(purchasedRequest.getProductId());
        Purchased purchased = new Purchased(product.get(), purchasedRequest.getQuantity(), purchasedRequest.getDate());

        Purchased createdPurchasedItem = purchasedService.savePurchasedItem(purchased);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPurchasedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchasedItem(@PathVariable Long id) {
        purchasedService.deletePurchasedItem(id);
        return ResponseEntity.noContent().build();
    }
}

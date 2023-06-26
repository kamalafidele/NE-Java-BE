package rw.rca.SpringSecurityTemplate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.SpringSecurityTemplate.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

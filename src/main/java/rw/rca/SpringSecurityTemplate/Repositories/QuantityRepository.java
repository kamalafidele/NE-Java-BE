package rw.rca.SpringSecurityTemplate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.SpringSecurityTemplate.Models.Quantity;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {
}

package rw.rca.SpringSecurityTemplate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.SpringSecurityTemplate.Models.Purchased;

public interface PurchasedRepository extends JpaRepository<Purchased, Long> {
}

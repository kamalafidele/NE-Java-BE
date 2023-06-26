package rw.rca.SpringSecurityTemplate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.SpringSecurityTemplate.Enums.ERole;
import rw.rca.SpringSecurityTemplate.Models.Role;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

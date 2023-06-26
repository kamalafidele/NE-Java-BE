package rw.rca.SpringSecurityTemplate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.rca.SpringSecurityTemplate.Models.Quantity;
import rw.rca.SpringSecurityTemplate.Repositories.QuantityRepository;

import java.util.List;

@Service
public class QuantityService {
    private final QuantityRepository quantityRepository;

    @Autowired
    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public List<Quantity> getAllQuantities() {
        return quantityRepository.findAll();
    }

    public Quantity getQuantityById(Long id) {
        return quantityRepository.findById(id).orElse(null);
    }

    public Quantity saveQuantity(Quantity quantity) {
        return quantityRepository.save(quantity);
    }

    public void deleteQuantity(Long id) {
        quantityRepository.deleteById(id);
    }
}

package ecom.e_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ecom.e_store.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
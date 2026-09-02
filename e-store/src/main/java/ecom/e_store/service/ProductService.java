package ecom.e_store.service;

import java.util.List;
import ecom.e_store.dto.ProductDto;

public interface ProductService {
    List<ProductDto> getProducts();
    ProductDto getProductById(Long id);
}

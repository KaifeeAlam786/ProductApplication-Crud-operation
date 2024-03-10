package in.kaifee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kaifee.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer>{

}

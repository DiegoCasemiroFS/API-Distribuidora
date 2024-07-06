package br.com.DiegoCasemiroFS.demo.service;

import br.com.DiegoCasemiroFS.demo.entity.Product;
import br.com.DiegoCasemiroFS.demo.entity.dto.ProductDTO;
import br.com.DiegoCasemiroFS.demo.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public Product findById(Long id){
    return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Id não encontrado"));
  }

  public List<Product> findAllProducts(){
    return productRepository.findAll();
  }

  public Product createProduct(Product product){
    productRepository.save(product);
    return product;
  }
/*
  public Product addProduct(Product product){

  }

  public Product removeProduct(){

  }
*/
  public Product updateProduct(Long id, Product product){
    return productRepository.findById(id)
        .map(f -> {
          product.setId(f.getId());
          productRepository.save(product);
          return product;
        }). orElseThrow(() -> new RuntimeException("Id não encontrado"));
  }

  public void deleteProduct(Long id){
    productRepository.findById(id)
        .map(f -> {
          productRepository.delete(f);
          return Void.TYPE;
        }).orElseThrow(() -> new RuntimeException("Id não encontrado"));
  }
}
package br.com.DiegoCasemiroFS.demo.service;

import br.com.DiegoCasemiroFS.demo.entity.Produto;
import br.com.DiegoCasemiroFS.demo.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  ProdutoRepository produtoRepository;

  public Produto findById(Long id){
    return produtoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Id não encontrado"));
  }

  public List<Produto> listProduct(){
    return produtoRepository.findAll();
  }

  public Produto createProduct(Produto produto){
    produtoRepository.save(produto);
    return produto;
  }

  public Produto updateProduct(Long id, Produto produto){
    return produtoRepository.findById(id)
        .map(f -> {
          produto.setId(f.getId());
          produtoRepository.save(produto);
          return produto;
        }). orElseThrow(() -> new RuntimeException("Id não encontrado"));
  }

  public void deleteProduct(Long id){
    produtoRepository.findById(id)
        .map(f -> {
          produtoRepository.delete(f);
          return Void.TYPE;
        }).orElseThrow(() -> new RuntimeException("Id não encontrado"));
  }

}

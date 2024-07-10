package br.com.DiegoCasemiroFS.distribuidora.controller;

import br.com.DiegoCasemiroFS.distribuidora.entity.Client;
import br.com.DiegoCasemiroFS.distribuidora.service.ClientService;
import java.util.List;

import br.com.DiegoCasemiroFS.distribuidora.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private OrderService orderService;

  @GetMapping("/{id}")
  public Client findById(@PathVariable Long id){
    return clientService.findById(id);
  }

  @GetMapping
  public List<Client> findAllClients(){
    return clientService.findAllClients();
  }

  @PostMapping
  public Client createClient(@RequestBody Client client){
    return clientService.createClient(client);
  }

  @PutMapping("/{id}")
  public Client updateClient(@PathVariable Long id, @RequestBody Client client){
    return clientService.updateClient(id, client);
  }

  @DeleteMapping
  public void deleteClient(@PathVariable Long id){
    clientService.deleteClient(id);
  }

}
package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.ClientApi;
import com.k48.managing.stock.dto.ClientDto;
import com.k48.managing.stock.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ClientDto save(@RequestBody ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        clientService.delete(id);
    }
}

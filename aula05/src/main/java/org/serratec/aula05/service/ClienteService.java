package org.serratec.aula05.service;

import org.serratec.aula05.entity.Cliente;
import org.serratec.aula05.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void inserir(Cliente cliente) {
        this.clienteRepository.save(cliente);
        System.out.println("Cliente salvo com sucesso");
    }

    public void atualizaCep(UUID idCliente, String cep) {
        Optional<Cliente> clienteOpt = this.clienteRepository.findById(idCliente);

        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.getEndereco().setCep(cep);
            this.clienteRepository.save(cliente);
        }

    }

}

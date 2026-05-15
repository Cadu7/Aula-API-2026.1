package org.serratec.aula05.service;

import org.serratec.aula05.entity.Funcionario;
import org.serratec.aula05.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inserir(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        System.out.println("O funcionario foi salvo com sucesso");
    }

}

package org.serratec.aula06.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.aula06.entity.Usuario;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioBuscaId {

    private UUID id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;

    public UsuarioBuscaId(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.telefone = usuario.getTelefone();
        this.cpf = formatCPF(usuario.getCpf());
        this.email = usuario.getEmail();
    }

    private String formatCPF(String cpf) {
        String cpfFormated = "";
        cpfFormated += cpf.substring(0,3) + ".";
        cpfFormated += cpf.substring(3,6) + ".";
        cpfFormated += cpf.substring(6,9) + "-";
        cpfFormated += cpf.substring(9);
        return cpfFormated;
    }

}

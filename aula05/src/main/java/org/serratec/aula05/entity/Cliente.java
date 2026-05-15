package org.serratec.aula05.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends Pessoa {

    @Embedded // define que vai puxar todos os campos e atruir a ela na tabela no banco de dados
    private Endereco endereco;

}

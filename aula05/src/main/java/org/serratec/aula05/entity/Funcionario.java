package org.serratec.aula05.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcionario extends Pessoa {

    @Column()
    private Double salario;

    @Enumerated(EnumType.STRING) // transformar o enum em um campo do db
    // ASSISTENTE varchar(255) "ASSISTENTE"
    // ASSISTENTE 0
    private Cargo cargo;

}

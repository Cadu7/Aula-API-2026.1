package org.serratec.aula05.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @Inheritance(strategy = InheritanceType.JOINED) // gera uma tabela por classe
// inserçoes moderadas, consulta pesadas
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // gera uma tabela por classe abstrata com todos os atributos == @MappedSuperclass
// o padrão, mantem as constraints, consultas mais leves quando quero trabalhar com vários campos da classe
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // gera apenas uma classe com todo os campos dos filhos
// x classes, basicamente os mesmos campos com comportamento diferenciado
@DiscriminatorColumn(name = "tipo")
@Entity
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

}

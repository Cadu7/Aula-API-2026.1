package org.serratec.aula04.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty
    @Size(max = 10)
    @Column(length = 100, unique = true, nullable = false)
    private String nome;

    @Column(length = 255, nullable = true)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private Boolean ativo;

    @NotNull
    @Min(10)
    @Column(nullable = false)
    private Integer quantidade;

}

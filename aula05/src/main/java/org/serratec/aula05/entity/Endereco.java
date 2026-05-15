package org.serratec.aula05.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable // define que ela pode estar dentro de outra classe para ser só uma tabela
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Column()
    private String cep;

    @Column()
    private String logradouro;

    @Column()
    private String complemento;

}

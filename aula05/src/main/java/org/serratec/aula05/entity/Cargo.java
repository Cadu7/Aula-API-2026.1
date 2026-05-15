package org.serratec.aula05.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cargo {

    ASSISTENTE,
    GERENTE,
    ANALISTA;

    @JsonCreator
    public static Cargo parse(String value) {
        for(Cargo cargo: values()){
            if (cargo.name().equalsIgnoreCase(value)){
                return cargo;
            }
        }
        throw new IllegalArgumentException();
    }

}

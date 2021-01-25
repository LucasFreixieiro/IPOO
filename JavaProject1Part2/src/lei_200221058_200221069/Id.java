/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;

/**
 * Informação de um ID
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class Id {

    private LocalDate date;
    private String value;
    private int distance;

    /**
     * Construtor
     *
     * @param value Valor do ID
     * @param date Data da criação do ID
     */
    public Id(String value, LocalDate date) {
        this.date = date;
        this.value = value;
    }

    /**
     *
     * @return Data que o Id foi gerado
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Altera a data
     *
     * @param date Data
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return Valor do id gerado
     */
    public String getValue() {
        return value;
    }

    /**
     * Altera o valor
     *
     * @param value Valor
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Distância que o utilizador estava de outro
     * @return Distância 
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Alterar distância
     * 
     * @param distance Distância
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

}

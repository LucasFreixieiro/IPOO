/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Enumerado com os tipos de estados NORMAL - continuo INFECTED - Infetado
 * ISOLATION - Em isolamento
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 *
 */
public enum UserState {
    NORMAL, INFECTED, ISOLATION, CAREFUL;

    /**
     *
     * @return Estado do Utilizador
     */
    @Override
    public String toString() {
        switch (this) {
            case NORMAL:
                return "Contínuo";
            case INFECTED:
                return "Infetado";
            case ISOLATION:
                return "Em Isolamento";
            case CAREFUL:
                return "Contínuo";
            default:
                return "";
        }
    }
}

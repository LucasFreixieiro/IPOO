/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 *
 * @author Lucas Freixieiro
 */

/*
Enumerado para o estado do utilizador
*/

/*
NORMAL -> continuo
INFECTED -> Infetado
ISOLATION -> Em isolamento
*/

public enum UserState {
    NORMAL, INFECTED, ISOLATION;
    
    public String toString() {
        switch(this) {
            case NORMAL:
                return "Contínuo";
            case INFECTED:
                return "Infetado";
            case ISOLATION:
                return "Em Isolamento";
            default:
                return "";
        }
    }
}

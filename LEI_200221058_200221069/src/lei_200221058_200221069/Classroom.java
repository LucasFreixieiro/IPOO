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
//Classe para as salas de aula
/*
Requerimentos:
-> Capacidade (Lugares disponiveis na sala)
-> Nome (Nome da sala)
 */
public class Classroom {

    private int capacity;
    private String name;

    public Classroom(String name, int capacity) {
        if (capacity > 0 && name != null && !name.isEmpty()) {
            this.capacity = capacity;
            this.name = name;
        } else {
            System.out.println("Campos inválidos.\nPor favor insira novamente!");
        }

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.out.println("Campo inválido.\nPor favor insira uma capacidade acima de 0.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Campo inválido.\nPor favor insira um nome válido!");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Registo dos Utilizadores
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class UserDB {

    private ArrayList<User> users;
    private ArrayList<Id> infectedIDs;

    /**
     * Construtor do UserDB Cria os arrays com tamanho 0
     */
    public UserDB() {
        users = new ArrayList<>();
        infectedIDs = new ArrayList<>();
    }

    /**
     *
     * @return utilizadores registados
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Adiciona um utilizador ao array users Para isso é feito o
     * redimensionamento do array Copiando o mesmo para outro e depois copiando
     * de volta para o original
     *
     * @param user Utilizador a ser adicionado
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Remove um utilizador do array users
     *
     * @param user utilizador a ser removido
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * Serve para obter um utilizador com um determindado numberID
     *
     * @param numberID número do utilizador a ser procurado
     * @return Utilizador com o numberID igual ao do parametro
     */
    public User getUser(String numberID) {
        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(numberID)) {
                return user;
            }
        }
        System.out.println("Utilizador inválido");
        return null;
    }

    /**
     * Obter posição de um utilizador no array users
     *
     * @param user utilizador a ser procurado
     * @return indice ao qual um determinado utilizador se encontra no array
     * users
     */
    public int getArrayIndex(User user) {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Obtem o total de utilizadores no array users
     *
     * @return quantidade de utililizadores
     */
    public int getTotalCount() {
        return users.size();
    }

    /**
     * Verifica se o utilizador já se encontra no array
     *
     * @param numberID número do utilziador a ser verificado
     * @return Verdadeiro se o utilizador está no array, false se não está
     */
    public boolean verifyUser(String numberID) {
        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(numberID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Define os Ids recebidos para cada utilizador Utiliza os ids transmitidos
     * para preencher o array dos ids recebidos
     */
    public void setIDs() {
        String ID;
        LocalDate today;
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i);
            ID = UUID.randomUUID().toString();
            today = LocalDate.now();
            System.out.println(users.get(i).getUserID());
            users.get(i).setTransmitedIds(ID, today);
            for (int j = 0; j < users.size(); j++) {
                if (i != j) {
                    users.get(j).setReceivedIDs(ID, today);
                }
            }
        }
    }

    /**
     *
     * @return Ids infetados
     */
    public ArrayList<Id> getInfectedIDs() {
        return infectedIDs;
    }

    /**
     * Define os ids infetados Redimensiona o array dos id infetados
     *
     * @param ids IDs a serem inseridos na lista
     */
    public void setInfectedIDs(ArrayList<Id> ids) {
        ids = verifyInfectedIDs(ids);
        if (ids != null) {
            infectedIDs = ids;
        }
    }

    /**
     * Verifica se já se passaram 7 dias desde que o array foi gerado Se sim ele
     * será eliminado
     *
     * @param ids Array de ids a serem verificados
     * @return Array do tipo Id que contém os ids mais atuais
     */
    public ArrayList<Id> verifyInfectedIDs(ArrayList<Id> ids) {
        LocalDate after;
        if (ids != null) {
            for (int i = 0; i < ids.size(); i++) {
                after = ids.get(i).getDate().plusDays(7);
                if (LocalDate.now().isAfter(after)) {
                    ids = removeOldID(i, ids);
                    i--;
                }
            }
            return ids;
        }
        return null;
    }

    /**
     * Remove o id do array passado em parametro na posição indicada
     *
     * @param index posição a eliminar
     * @param ids array a ser alterado
     * @return array alterado
     */
    public ArrayList<Id> removeOldID(int index, ArrayList<Id> ids) {
        ids.remove(index);
        return ids;
    }

    /**
     * Limpa o array que contém os ids dos utilizadores infetados Só é acionado
     * após o upload dos ids infetados em cada utilizador (é acionado através da
     * organização)
     */
    public void clearInfectedIDs() {
        infectedIDs = new ArrayList<>();
    }

}

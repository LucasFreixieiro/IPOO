/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Classe auxiliar para obter o que o utilizador escreve
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
//Importar classes bibliotecas necessárias
import java.util.Scanner;

//Classe que permite ler as opções introduzidas pelo utilizador
public class InputReader {

    private Scanner reader;

    /**
     * Construtor
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Obter o valor introduzido pelo utilizador
     *
     * @param question Pergunta
     * @return Valor introduzido
     */
    public int getOption(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
        while (!reader.hasNextInt()) {
            reader.nextLine();
            System.out.print(question);
        }
        int number = reader.nextInt();
        reader.nextLine();
        return number;
    }

    /**
     * Obtem o numberID do utilizador Este é validado para que tenha 9
     * caracteres e se é numérico
     *
     * @param question Pergunta
     * @return numberID
     */
    public String getUserID(String question) {
        String userID;
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
        userID = reader.nextLine();
        while (userID.length() != 9 && isNumeric(question)) {
            System.out.print(question);
            userID = reader.nextLine();
        }
        return userID;
    }

    /**
     * Obtem aquilo que o utilizador introduzir
     *
     * @param question Pergunta
     * @return texto
     */
    public String getText(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);

        return reader.nextLine();
    }

    /**
     * Obtem o estado
     *
     * @param question Pergunta
     * @return Estado do utilizador
     */
    public UserState getUserState(String question) {
        UserState status = UserState.NORMAL;
        System.out.println("Estados:");
        System.out.println("1 - Contínuo");
        System.out.println("2 - Isolamento");
        System.out.println("3 - Infetado");
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
        while (!reader.hasNextInt()) {
            reader.nextLine();
            System.out.print(question);
        }
        int option = reader.nextInt();
        while (option > 3 || option < 1) {
            System.out.print(question);
            System.out.println("Opção inválida! Escolha uma opção válida.");
            option = reader.nextInt();
        }
        switch (option) {
            case 1: {
                status = UserState.NORMAL;
                break;
            }
            case 2: {
                status = UserState.ISOLATION;
                break;
            }
            case 3: {
                status = UserState.INFECTED;
                break;
            }
            default: {
                System.out.println("Erro no Sistema! Opção não reconhecida");
            }
        }
        reader.nextLine();
        return status;
    }

    /**
     * Verifica se a String é numérica
     *
     * @param strNum String para verificar
     * @return boolean se sim true, se não false
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

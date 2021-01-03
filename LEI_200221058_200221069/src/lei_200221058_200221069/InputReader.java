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

//Importar classes bibliotecas necessárias
import java.util.Scanner;

//Classe que permite ler as opções introduzidas pelo utilizador
public class InputReader {
    private Scanner reader;
    
    public InputReader() {
        reader = new Scanner(System.in);
    }
    
    public int getOption(String question) {
        if(question == null) {
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
    
    public int getUserID(String question){
        if(question == null) {
        question = "";
        }
        question += "> ";
        System.out.print(question);
        while (!reader.hasNextInt()) {
        reader.nextLine();
        System.out.print(question);
        }
        int number = reader.nextInt();
        while(((int) (Math.log10(number) + 1)) != 9){
            System.out.print(question);
            number = reader.nextInt();
        }
        reader.nextLine();
        return number;        
    }
    
    public String getText(String question){
        if(question == null){
            question = "";
        }
        question += "> ";
        System.out.print(question); 
        
        return reader.nextLine();
    }
    //assasaa
    public UserState getUserState(String question){
        UserState status = UserState.NORMAL;
        System.out.println("Estados:");
        System.out.println("1 - Contínuo");
        System.out.println("2 - Isolamento");
        System.out.println("3 - Infetado");
        if(question == null) {
        question = "";
        }
        question += "> ";
        System.out.print(question);
        while (!reader.hasNextInt()) {
        reader.nextLine();
        System.out.print(question);
        }
        int option = reader.nextInt();
        while(option > 3 || option < 1){
            System.out.print(question);
            option = reader.nextInt();
        }
        switch(option){
            case 1:{
                status = UserState.NORMAL;
                break;
            }
            case 2:{
                status = UserState.ISOLATION;
                break;
            }
            case 3:{
                status = UserState.INFECTED;
                break;
            }
            default:{
                System.out.println("Erro no Sistema! Opção não reconhecida");
            }
        }
        reader.nextLine();
        return status;
    }
}

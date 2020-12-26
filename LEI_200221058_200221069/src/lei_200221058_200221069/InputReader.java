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
    
    public int getNumber(String question) {
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
    
    public String getText(String question){
        if(question == null){
            question = "";
        }
        question += "> ";
        System.out.print(question); 
        
        return reader.nextLine();
    }
}

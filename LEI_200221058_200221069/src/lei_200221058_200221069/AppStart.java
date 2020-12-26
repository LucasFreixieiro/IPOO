/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 *
 * @author lukef
 */
public class AppStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputReader reader = new InputReader();
        reader.getText("Ola");
        AdministrationMenu admin = new AdministrationMenu();
        //AshowAdministrationMenu();
        //EncryptionText enc = new EncryptionText();
    }
    
    public void showMainMenu(){
        System.out.println("\tSistema de rastreio de contactos em sala de aula");
        System.out.println("\t\tBem-vindo!!!");
        System.out.println("Insira a sua opção:");
        System.out.println("1 - Registo de presenças.");
        System.out.println("2 - Área de utilizador.");
        System.out.println("3 - Área da Autoridade de Saúde.");
        System.out.println("4 - Área de administrador.");
        System.out.println("0 - Sair.");
    }
}

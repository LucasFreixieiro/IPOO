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
public class AdministrationMenu {
    
    //Atributos 
    private Classroom[] classrooms; //Será que isto devia de ficar aqui?

    public AdministrationMenu() {
        int option; //Variável auxiliar para guardar temporáriamente a escolha do administrador
        InputReader reader = new InputReader();
        
        showAdministrationMenu(); //Demonstra o menu ao administrador
        option = reader.getNumber("");
        
        //Enquanto a opção for diferente de 0 o programa continuará a correr
        while(option != 0){
            
            //Ponte para os métodos correspondentes às opções
            switch(option){
                case 1:
                    System.out.println("ola amigos");
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opção não reconhecida");
                    break;
            }
            
            //De forma a que a informação não apareça de seguida
            //ao utilizador é pedido que ele insira um enter para continuar o programa
            reader.getText("Prima Enter para continuar");
            
            //Demonstração do menu e pedido de nova opção
            showAdministrationMenu();
            option = reader.getNumber("");
        }
    }
    
    //Menu com as opções
    public void showAdministrationMenu(){
        System.out.println("\tSistema de rastreio de contactos em sala de aula");
        System.out.println("\t\tÁrea de administração");
        System.out.println("Insira a sua opção:");
        System.out.println("1 - Criar utilizador");
        System.out.println("2 - Eliminar utilizador");
        System.out.println("3 - Mostrar lista de utilizadores");
        System.out.println("4 - Criar sala de aula");
        System.out.println("5 - Eliminar sala de aula");
        System.out.println("6 - Mostar lista de salas");
        System.out.println("0 - Sair");
    }
    
    /*public void createClassroom(){
        
    }*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 *
 * @author Lucas Freixieiro
 * @v1.0.0
 */
public class UserMenu {
    //Número de Utilizador
    private int numberID;

    public UserMenu(int numberID) {
        this.numberID = numberID;
        int option;
        
        InputReader reader = new InputReader();
        showUserMenu();
        
        option = reader.getNumber("");
        while(option != 0){
            switch(option){
                case 1:{
                    System.out.println("");
                    break;
                }
                case 2:{
                    System.out.println("");
                    break;
                }
                case 3:{
                    System.out.println("");
                    break;
                }
                case 4:{
                    System.out.println("");
                    break;
                }
                case 5:{
                    System.out.println("");
                    break;
                }
                default:{
                    System.out.println("Opção não reconhecida");
                }
            }
        }
        /*User user1 = new User("1", UserState.NORMAL);
        user1.setTransmitedIds();
        user1.setTransmitedIds();
        user1.listTransmitedIds();
        //System.out.println(user1.getTransmitedIds());*/
    }
    
    //Menu do utilizador
    public void showUserMenu(){
        System.out.println("\tSistema de rastreio de contactos em sala de aula\n");
        System.out.println("\t\tUtilizador: " + numberID);
        System.out.println("\t\tEstado: " );
        System.out.println("Insira a sua opção: ");
        System.out.println("1 - Verificar indicações da Entidade de Saúde");
        System.out.println("2 - Declarar-se como infetado");
        System.out.println("3 - Entrar em isolamento profilático");
        System.out.println("4 - Terminar isolamento.");
        System.out.println("5 - Ver estatísticas diárias");
        System.out.println("0 - Sair");
    }
}

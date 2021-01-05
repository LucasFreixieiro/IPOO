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
    
    private UserDB userDB;
    //Número de Utilizador
    private User user;

    public UserMenu(UserDB userDB) {
        this.userDB = userDB;
    }
    
    public void run(String numberID){
        user = userDB.getUser(numberID);
        int option;
        
        InputReader reader = new InputReader();
        showUserMenu();
        
        option = reader.getOption("");
        while(option != 0){
            switch(option){
                case 1:{
                    System.out.println("");
                    break;
                }
                case 2:{
                    setNewState(UserState.INFECTED);
                    break;
                }
                case 3:{
                    //verificar se não está em isolamento ou infetado
                    setNewState(UserState.ISOLATION);
                    break;
                }
                case 4:{
                    //Verificar se está em isolamento
                    setNewState(UserState.NORMAL);
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
            
            //De forma a que a informação não apareça de seguida
            //ao utilizador é pedido que ele insira um enter para continuar o programa
            reader.getText("Prima Enter para continuar");
            
            //Demonstração do menu e pedido de nova opção
            showUserMenu();
            option = reader.getOption("");
        }
    }
    
    //Menu do utilizador
    public void showUserMenu(){
        System.out.println("\tSistema de rastreio de contactos em sala de aula\n");
        System.out.println("\t\tUtilizador: " + user.getUserID());
        System.out.println("\t\tEstado: " + user.getUserState());
        System.out.println("Insira a sua opção: ");
        System.out.println("1 - Verificar indicações da Entidade de Saúde");
        System.out.println("2 - Declarar-se como infetado");
        System.out.println("3 - Entrar em isolamento profilático");
        System.out.println("4 - Terminar isolamento.");
        System.out.println("5 - Ver estatísticas diárias");
        System.out.println("0 - Sair");
    }
    
    public void setNewState(UserState userState){
        if(user != null){
            user.setUserState(userState);
        }
    }
}

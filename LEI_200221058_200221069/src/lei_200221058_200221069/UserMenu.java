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
    private int numberID;
    
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
    
   public void showTeacherMenu(){
       showUserMenu();
       System.out.println("6 - Iniciar aula");
       System.out.println("7 - Terminar aula");
   }
}

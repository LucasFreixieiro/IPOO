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
public class HealthOrganizationMenu {
    private HealthOrganizationRecomendations recomendations;
    private InputReader reader;
    private Statistics statistics;
    public HealthOrganizationMenu(HealthOrganizationRecomendations recomendations, UserDB userDB) {
        reader = new InputReader();
        this.recomendations = recomendations;
        statistics = new Statistics(userDB);
    }
    
    public void run(){
        int option;
        showHealthOrganizationMenu();
        
        option = reader.getOption("");
        while(option != 0){
            switch(option){
                case 1:{
                    System.out.println("");
                    break;
                }
                case 2:{           
                    statistics.Statistics();
                    break;
                }
                case 3:{
                    recomendations.newRecomendation();
                    break;
                }
                case 4:{
                    editRecomendation();
                    break;
                }
                case 5:{
                    removeRecomendation();
                    break;
                }
                case 6:{
                    recomendations.listRecomendations();
                    break;
                }
                default:{
                    System.out.println("Opção não reconhecida");
                    break;
                }
            }
            
            //De forma a que a informação não apareça de seguida
            //ao utilizador é pedido que ele insira um enter para continuar o programa
            reader.getText("Prima Enter para continuar");
            
            //Demonstração do menu e pedido de nova opção
            showHealthOrganizationMenu();
            option = reader.getOption("");
        }
    }
    
    public void showHealthOrganizationMenu(){
        System.out.println("\tSistema de rastreio de contactos em sala de aula");
        System.out.println("\t\tÁrea da organização de Saúde");
        System.out.println("Insira a sua opção:");
        System.out.println("1 - Enviar lista de doentes infetados hoje");
        System.out.println("2 - Ver Estatísticas");
        System.out.println("3 - Nova Recomendação");
        System.out.println("4 - Editar Recomendações");
        System.out.println("5 - Remover Recomendação");
        System.out.println("6 - Listar Recomendações");
        System.out.println("0 - Sair");
    }
    
    public void removeRecomendation(){
        int option;
        
        recomendations.listRecomendations();
        option = reader.getOption("Introduza o número");
        recomendations.removeRecomendation(option);
    }
    
    public void editRecomendation(){
        int option;
        
        recomendations.listRecomendations();
        option = reader.getOption("Introduza o número");
        recomendations.editRecomendation(option);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;

/**
 * Menu do utilzador
 * @author Lucas Freixieiro
 * @version 1.0.0
 */
public class UserMenu {
    
    //Objeto que contém os utilziadores registados
    private UserDB userDB;
    //Número de Utilizador
    private User user;
    //Recomendações
    private HealthOrganizationRecomendations recomendations;
    //Estatisticas
    private Statistics statistics;

    /**
     * Construtor do Menu do Utilizador
     * @param userDB Registo de utilizadores registados pelo administrador
     * @param recomendations Recomendações registadas pela organização de saúde
     */
    public UserMenu(UserDB userDB, HealthOrganizationRecomendations recomendations) {
        this.userDB = userDB;
        this.recomendations = recomendations;
        statistics = new Statistics(userDB);
    }
    
    /**
     * Método a ser executado quando se quer obter o menu e executar as suas opções
     * @param user Utilizador que entrou no menu
     */
    public void run(User user){
        this.user = user;
        int option;
        
        //Limpar ids antigos
        removeOldTransmitedIDs();
        removeOldReceivedIDs();
        
        InputReader reader = new InputReader();
        showUserMenu();
        
        //Verificar se o utilizador está em isolamento e se já passaram 15 dias
        verifyState();
        
        option = reader.getOption("");
        while(option != 0){
            switch(option){
                case 1:{
                    showRecomendations();
                    break;
                }
                case 2:{
                    if(user.getUserState() != UserState.INFECTED){
                        setNewState(UserState.INFECTED);
                        System.out.println("Estado alterado com  sucesso");
                        sendIDs();
                    }
                    else
                        System.out.println("O utilizador já está declarado como infetado");
                    break;
                }
                case 3:{
                    if(user.getUserState() != UserState.INFECTED && user.getUserState() != UserState.ISOLATION){
                        setNewState(UserState.ISOLATION);
                        System.out.println("Estado alterado com sucesso");
                    }
                    else
                        System.out.println("O utilizador já está em isolamento");
                    break;
                }
                case 4:{
                    //Verificar se está em isolamento
                    setNewState(UserState.NORMAL);
                    break;
                }
                case 5:{
                    statistics.Statistics();
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
            showUserMenu();
            option = reader.getOption("");
        }
    }
    
    
    /**
     * Método onde está listado o menu do utilizador
     */
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
    
    /**
     * Define o estado do utilizador para o passado em parametro
     * @param userState Estado do utilizador a ser definido
     */
    public void setNewState(UserState userState){
        if(user != null){
            user.setUserState(userState);
        }
    }
    
    /**
     * Lista em formato de texto as recomendações da organização de saúde
     */
    public void showRecomendations(){
        recomendations.listRecomendations();
    }
    
    /**
     * Lista os Ids transmitidos e recebidos
     * Método feito a pensar nos testes
     */
    public void listIds(){
        user.listTransmitedIds();
        user.listReceivedIds();
    }
    
    /**
     * Guarda no objeto userDB os ids transmitidos por este utilizador quando o mesmo se declara infetado
     */
    public void sendIDs(){
        Id[] ids = user.getTransmitedIds();
        userDB.setInfectedIDs(ids);
    }
    
    /**
     * Remoção de Ids transmitidos que já tem uma data maior que 28 dias
     */
    public void removeOldTransmitedIDs(){
        LocalDate after;
        Id[] ids = user.getTransmitedIds();
        if(ids != null){
            for(int i=0; i<ids.length; i++){
                after = ids[i].getDate().plusDays(28);
                if(LocalDate.now().isAfter(after)){
                    System.out.println(i);
                    user.removeTransmitedID(i);
                    ids = user.getTransmitedIds();
                    i--;
                }
            }
        }
    }
    
    /**
     * Remoção de Ids recebidos que já tem uma data maior que 28 dias
     */
    public void removeOldReceivedIDs(){
        LocalDate after;
        Id[] ids = user.getReceivedIDs();
        if(ids != null){
            for(int i=0; i<ids.length; i++){
                after = ids[i].getDate().plusDays(28);
                if(LocalDate.now().isAfter(after)){
                    user.removeReceivedID(i);
                    ids = user.getTransmitedIds();
                    i--;
                }
            }
        }
    }
    
    /**
     * Verifica se o utilizador está em isolamento
     * Se estiver e já se tiverem passado os 15 dias desde o inicio do isolamento então terá o seu estado alterado
     */
    public void verifyState(){
        if(user.getUserState() == UserState.ISOLATION){
            if(user.getChangeStateDate().isAfter(user.getChangeStateDate().plusDays(15))){
                user.setUserState(UserState.NORMAL);
            }
        }
    }
}

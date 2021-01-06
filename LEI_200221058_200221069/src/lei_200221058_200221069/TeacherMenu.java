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
public class TeacherMenu {
    
    private LessonDB lessonDB;
    private UserDB userDB;
    private InputReader reader;
    
    private UserDB attendances;
    private Lesson lesson;
    private boolean flag;

    public TeacherMenu(LessonDB lessonDB, UserDB userDB) {
        reader = new InputReader();
        this.lessonDB = lessonDB;
        this.userDB = userDB;
    }
    
    public void run(){
        System.out.println(flag);
        int option;
        attendances = new UserDB();
        
        
        showTeacherMenu();
        
        option = reader.getOption("");
        while(option != 0 || flag){
            switch(option){
                case 1:{
                    setAttendances();
                    break;
                }
                case 2:{
                    if(!flag)
                        startLesson();
                    else
                        System.out.println("Aula já iniciada");
                    break;
                }
                case 3:{
                    endLesson();
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
            showTeacherMenu();
            option = reader.getOption("");
        }
    }
    
    public void showTeacherMenu(){
       System.out.println("1 - Registar Presenças");
       System.out.println("2 - Iniciar aula");
       System.out.println("3 - Terminar aula");
       System.out.println("0 - Sair");
   }
    
   public void setAttendances(){
       int option;
       
       showAttendanceMenu();
       option = reader.getOption("Opção");
       
       while(option!=0){
           switch(option){
               case 1:{
                   User user;
                   user = userDB.getUser(reader.getUserID("Número de Aluno"));
                   if(user!=null)
                       attendances.addUser(user);
                   else
                       System.out.println("Aluno inexistente");
               }
           }
           showAttendanceMenu();
           option = reader.getOption("Opção");
       }
   }
   
   public void showAttendanceMenu(){
       System.out.println("1 - Marcar presença");
       System.out.println("0 - Sair");
   }
   
   public void startLesson(){
       lesson = new Lesson();
       lessonDB.addLesson(lesson);
       flag = true;
   }
   
   public void endLesson(){
       if(flag){
           lesson.endLesson(attendances);
           lessonDB.addLesson(lesson);
           flag = false;
       }
       else
           System.out.println("Aula sem inicio");
   }
           
}

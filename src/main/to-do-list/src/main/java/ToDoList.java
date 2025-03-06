import dto.ToDo;
import service.ToDoService;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ToDoService toDoService = new ToDoService();
        ArrayList<ToDo>todolist = new ArrayList<>();
        todolist = toDoService.populate(todolist);
        int choice;
        boolean isRunning = true;

        while(isRunning){
            System.out.println("****************");
            System.out.println("   To Do List   ");
            System.out.println("****************");
            System.out.println("1 - View All");
            System.out.println("2 - Add");
            System.out.println("3 - Delete");
            System.out.println("4 - Exit");
            System.out.println("****************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    toDoService.viewToDos(todolist);
                    break;
                case 2:
                    todolist = toDoService.addToDos(todolist, scanner);
                    break;
                case 3:
                    todolist = toDoService.deleteToDos(todolist, scanner);
                    break;
                case 4:
                    isRunning = false;
            }
        }
        scanner.close();
    }
}
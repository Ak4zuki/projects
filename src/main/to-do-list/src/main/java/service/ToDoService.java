package service;

import dto.ToDo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoService {

    public ToDoService() {
    }

    public ArrayList<ToDo> populate(ArrayList<ToDo> list) {
        list.add(new ToDo("Drink Strawberry Milk 🥛", "Remember to drink Strawberry Milk"));
        list.add(new ToDo("Get Big 💪", "Remember to hit the gym and get your protein"));
        return list;
    }

    public void viewToDos(ArrayList<ToDo> toDos) {
        int i = 1;
        for (ToDo toDo : toDos) {
            System.out.println(i + " - " + toDo.toString());
            i++;
        }
    }

    public ArrayList<ToDo> addToDos(ArrayList<ToDo> list, Scanner scanner) {
        System.out.print("To Do Name:");
        String name = scanner.nextLine();
        System.out.println("What Is The Description:");
        String description = scanner.nextLine();
        list.add(new ToDo(name, description));
        return list;
    }

    public ArrayList<ToDo> deleteToDos(ArrayList<ToDo> list, Scanner scanner) {
        viewToDos(list);
        boolean batman = true;
        while (batman){
            try {
                System.out.print("Delete a To Do: ");
                int index = scanner.nextInt();
                if (index < 0 || index > list.size()) {
                    System.out.println("Number must be of list");
                }
                list.remove(index - 1);
                batman = false;
            } catch (InputMismatchException e) {
                System.out.println("Not an Integer");
                scanner.nextLine();
            }
        }
        return list;
    }
}

package dto;

import java.time.LocalDate;

public class ToDo {

    private String name;
    private String description;
    private LocalDate creationDate;

    public ToDo(String name, String description) {
        this.name = name;
        this.description = description;
        this.creationDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "To Do: " + name + "\n" + description + "\n" + creationDate;
    }

    //create exit message

}
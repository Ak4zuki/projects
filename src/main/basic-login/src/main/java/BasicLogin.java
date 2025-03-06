import dto.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicLogin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean batman = true;
        ObjectMapper objectMapper = new ObjectMapper();

        while (batman) {
            mainMenu();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            User user = new User(name, password);
            try {
                List<User> users = objectMapper.readValue(new File("src/main/basic-login/src/main/resources/db/users.json"),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));


                Optional<User> foundUser = users.stream().filter(user1 ->
                        user1.getName().equals(user.getName())).findFirst();
                if (foundUser.isPresent()){
                    User newUser = foundUser.get();
                    if (newUser.getPassword().equals(user.getPassword())){
                        System.out.println("Welcome " + newUser.getName());
                        batman = false;
                    }
                    else {
                        System.out.println("Bad Credentials");
                    }
                }else {
                    System.out.println("No User Found With Username");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void mainMenu() {
        System.out.println("***********");
        System.out.println("   Login   ");
        System.out.println("***********");
    }
}
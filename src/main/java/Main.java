public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(1, "John Doe", "john@example.com"));
        userRepository.addUser(new User(2, "Jane Smith", "jane@example.com"));

        // a. Пошук користувача за id
        int searchId = 1;
        userRepository.findUserById(searchId).ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("User with ID " + searchId + " not found.")
        );

        // b. Пошук користувача за email
        String searchEmail = "jane@example.com";
        userRepository.findUserByEmail(searchEmail).ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("User with email " + searchEmail + " not found.")
        );

        // c. Отримання списку всіх користувачів
        userRepository.findAllUsers().ifPresentOrElse(
                userList -> System.out.println("Total users: " + userList.size()),
                () -> System.out.println("No users found.")
        );
    }
}

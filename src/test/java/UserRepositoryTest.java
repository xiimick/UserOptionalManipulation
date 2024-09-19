import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryIT {
    private static UserRepository userRepository;

    @BeforeAll
    static void setUp() {
        userRepository = new UserRepository();
        userRepository.addUser(new User(1, "John Doe", "john@example.com"));
    }

    @Test
    void testFindUserById_UserExists() {
        Optional<User> user = userRepository.findUserById(1);
        assertTrue(user.isPresent(), "User with ID 1 should be present");
        assertEquals("John Doe", user.get().getName());
    }

    @Test
    void testFindUserById_UserDoesNotExist() {
        Optional<User> user = userRepository.findUserById(2);
        assertFalse(user.isPresent(), "User with ID 2 should not be present");
    }
}

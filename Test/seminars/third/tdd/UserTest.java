package seminars.third.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;
    @BeforeAll
    static void setUp(){
        repository = new UserRepository();
    }

    @Test
    void checkAuthenticateUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticateUserNegative(){
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthenticatedUserPositive(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

       assertThat(repository.data.size())
               .isEqualTo(currentCount + 1);

       User userInRepository =
               repository.data.get(repository.data.size() - 1);

       assertEquals(user, userInRepository);
    }

    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative(){
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount);
    }

    //*********************************
    // Домашняя работа к семинару от 23-10-16
    /*
    Добавьте функцию в класс UserRepository,
    которая разлогинивает всех пользователей, кроме администраторов.
    Для этого, вам потребуется расширить класс User новым свойством,
    указывающим, обладает ли пользователь админскими правами.
    Протестируйте данную функцию.
    */

    @Test
    void testRemoveUserPositive() {
        User user = new User("nameForRemove", "password", false);
        user.authenticate(user.name, user.password);
        repository.addUser(user);
        assertTrue(repository.removeUser(user));
    }

    @Test
    void testRemoveUserNegative() {
        User user = new User("nameNotAdded", "password", false);
        assertFalse(repository.removeUser(user));
    }

    @Test
    void testRemoveAllUserNotAdmin() {
        User simpleUser1 = new User("simpleUser1", "password", false);
        User simpleUser2 = new User("simpleUser2", "password", false);
        User adminUser = new User("adminUser", "password", true);
        simpleUser1.authenticate(simpleUser1.name, simpleUser1.password);
        simpleUser2.authenticate(simpleUser2.name, simpleUser2.password);
        adminUser.authenticate(adminUser.name, adminUser.password);
        repository.addUser(simpleUser1);
        repository.addUser(simpleUser2);
        repository.addUser(adminUser);
        repository.removeAllUser();
        assertTrue(repository.data.contains(adminUser)
                && repository.data.size() == 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"name1", "name2", "name3"})
    void testFindByNamePositive(String input) {
        User user1 = new User("name1", "password", false);
        User user2 = new User("name2", "password", false);
        User user3 = new User("name3", "password", true);
        user1.authenticate(user1.name, user1.password);
        user2.authenticate(user2.name, user2.password);
        user3.authenticate(user3.name, user3.password);
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        assertTrue(repository.findByName(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"name11", "name22", "name33"})
    void testFindByNameNegative(String input) {
        User user4 = new User("name4", "password", false);
        User user5 = new User("name5", "password", false);
        User user6 = new User("name6", "password", true);
        user4.authenticate(user4.name, user4.password);
        user5.authenticate(user5.name, user5.password);
        user6.authenticate(user6.name, user6.password);
        repository.addUser(user4);
        repository.addUser(user5);
        repository.addUser(user6);
        assertFalse(repository.findByName(input));
    }
}
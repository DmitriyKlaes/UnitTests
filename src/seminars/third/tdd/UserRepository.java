package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if(!user.isAuthenticate) return;
       data.add(user);
    }

    public boolean removeUser(User user) {
        for (User userData : this.data) {
            if (userData.name.equals(user.name)) {
                this.data.remove(user);
                return true;
            }
        }
        return false;
    }

    /*
    Добавьте функцию в класс UserRepository,
    которая разлогинивает всех пользователей, кроме администраторов.
    Для этого, вам потребуется расширить класс User новым свойством,
    указывающим, обладает ли пользователь админскими правами.
    Протестируйте данную функцию.
    */
    public void removeAllUser() {
        for (User user : this.data) {
            if (!user.isAdmin) {
                user.isAuthenticate = !user.isAuthenticate;
            }
        }
        this.data.removeIf(user -> !user.isAdmin);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
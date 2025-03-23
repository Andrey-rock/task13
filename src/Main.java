import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<User> users = new ArrayList<>();

        users.add(new User("Иван", 38));
        users.add(new User("Петр", 38));
        users.add(new User("Мария", 21));
        users.add(new User("Сергей", 31));
        users.add(new User("Андрей", 28));
        users.add(new User("Света", 25));
        users.add(new User("Иван", 37));
        users.add(new User("Иван", 38));
        users.add(new User("Андрей", 38));
        users.add(new User("Яков", 19));
        users.add(new User("Ольга", 22));

        System.out.println(getSortOldestUsers(users));
    }

    public static Collection<User> getSortOldestUsers(Collection<User> users) {
        return users.stream()
                .distinct()
                .sorted((u1, u2) -> {
                    int result = Integer.compare(u2.getAge(), u1.getAge());
                    if (result == 0) {
                        return u1.getName().compareTo(u2.getName());
                    }
                    return result;
                })
                .limit(5)
                .toList();
    }
}
package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {
    public static final List<User> users = Arrays.asList(
            new User(1, "User 1", "user1@mail.ru", "user1", Role.ADMIN, Role.USER),
            new User(2, "User 2", "user2@mail.ru", "user2", Role.ADMIN),
            new User(3, "User 3", "user3@mail.ru", "user3", Role.USER),
            new User(4, "User 4", "user6@mail.ru", "user4", Role.USER),
            new User(5, "User 4", "user5@mail.ru", "user5", Role.USER),
            new User(6, "User 4", "user4@mail.ru", "user6", Role.USER),
            new User(7, "User 7", "user7@mail.ru", "user7", Role.USER),
            new User(8, "User 8", "user8@mail.ru", "user8", Role.USER),
            new User(9, "User 9", "user9@mail.ru", "user9", Role.USER),
            new User(10, "User 10", "user10@mail.ru", "user10", Role.USER)
    );
}

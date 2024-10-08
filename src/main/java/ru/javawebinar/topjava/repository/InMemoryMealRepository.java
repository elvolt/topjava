package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealRepository implements Repository<Meal> {
    private final List<Meal> meals = new CopyOnWriteArrayList<>();
    private final AtomicInteger lastIndex = new AtomicInteger(0);

    {
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0),
                "Завтрак", 500));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0),
                "Обед", 1000));
        save(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0),
                "Ужин", 500));
        save( new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0),
                "Еда на граничное значение", 100));
        save(new Meal(5, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0),
                "Завтрак", 1000));
        save(new Meal(6, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0),
                "Обед", 500));
        save(new Meal(7, LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0),
                "Ужин", 410));
    }

    public List<Meal> getAll() {
        return new ArrayList<>(meals);
    }

    @Override
    public Meal save(Meal meal) {
        meal.setId(lastIndex.incrementAndGet());
        meals.add(meal);
        return meal;
    }
}

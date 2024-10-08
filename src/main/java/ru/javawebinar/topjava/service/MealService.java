package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.Repository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

public class MealService {
    private static final int CALORIES_PER_DAY = 2000;

    private final Repository<Meal> repository = new InMemoryMealRepository();

    public List<MealTo> getAll() {
        List<Meal> meals = repository.getAll();

        return MealsUtil.filteredByStreams(meals, CALORIES_PER_DAY);
    }

    public void save(Meal meal) {
        repository.save(meal);
    }
}

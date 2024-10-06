package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

public class MealService {
    private static final MealService INSTANCE = new MealService();

    private static final int CALORIES_PER_DAY = 2000;

    private MealService() {
    }

    public static MealService getInstance() {
        return INSTANCE;
    }

    public List<MealTo> getAll() {
        List<Meal> meals = InMemoryMealRepository.getInstance().getAll();

        return MealsUtil.filteredByStreams(meals, CALORIES_PER_DAY);
    }

    public void save(Meal meal) {
        InMemoryMealRepository.getInstance().save(meal);
    }
}

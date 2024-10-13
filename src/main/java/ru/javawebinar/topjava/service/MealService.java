package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Collection<Meal> getAll(Integer userId, String startDateStr, String endDateStr,
                                   String startTimeStr, String endTimeStr) {
        LocalDateTime startDate = (startDateStr == null || startDateStr.isEmpty()) ? null :
                LocalDateTime.of(LocalDate.parse(startDateStr), LocalTime.MIN);
        LocalDateTime endDate = (endDateStr == null || endDateStr.isEmpty()) ? null :
                LocalDateTime.of(LocalDate.parse(endDateStr), LocalTime.MAX);
        LocalTime startTime = (startTimeStr == null || startTimeStr.isEmpty()) ? null : LocalTime.parse(startTimeStr);
        LocalTime endTime = (endTimeStr == null || endTimeStr.isEmpty()) ? null : LocalTime.parse(endTimeStr);

        return repository.getAll(userId, startDate, endDate, startTime, endTime);
    }

    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    public Meal update(Meal meal) {
        return repository.save(meal);
    }

    public void delete(int id, int userId) {
        repository.delete(id, userId);
    }

    public Meal get(int id, int userId) {
        return repository.get(id, userId);
    }
}
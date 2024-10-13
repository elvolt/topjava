package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.Collection;

public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public Collection<MealTo> getAll(String startDate, String endDate, String startTime, String endTime) {
        log.info("getAll");
        int userId = SecurityUtil.authUserId();
        return MealsUtil.getTos(service.getAll(userId, startDate, endDate, startTime, endTime),
                SecurityUtil.authUserCaloriesPerDay());
    }

    public Meal get(int id) {
        log.info("get with id {}", id);
        int userId = SecurityUtil.authUserId();
        return service.get(id, userId);
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        ValidationUtil.checkNew(meal);
        return service.create(meal);
    }

    public Meal update(Meal meal) {
        log.info("update {}", meal);

        int userId = SecurityUtil.authUserId();
        if (!meal.getUserId().equals(userId)) {
            throw new IllegalArgumentException("Meal updated for other user");
        }

        return service.update(meal);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        service.delete(id, userId);
    }

    private Meal toEntity(MealTo to) {
        return new Meal(to.getId(), to.getDateTime(), to.getDescription(), to.getCalories(), SecurityUtil.authUserId());
    }
}
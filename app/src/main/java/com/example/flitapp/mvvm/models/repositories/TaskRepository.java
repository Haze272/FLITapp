package com.example.flitapp.mvvm.models.repositories;

import android.os.Build;

import com.example.flitapp.mvvm.models.Task;
import com.example.flitapp.mvvm.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TaskRepository {
    private static TaskRepository instance;
    private int orderCounter = 270000;

    public List<Task> tasks = new ArrayList<>();
    public HashMap<Task, ArrayList<User>> responders = new HashMap<>();

    public TaskRepository() {
        fillMockTasks();
    }

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public Task getTaskByHeader(String header){
        Task result = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = tasks.stream().filter(user -> user.getHeader().equals(header)).findFirst().get();
        }
        return result;
    }

    public void fillMockTasks() {
        tasks.add(new Task(
                orderCounter,
                "Вёрстка одностраничного лендинга",
                "13 000",
                new String[]{"html", "css", "javascript"},
                "Необходимо разработать дизайн небольшого лендинга на тему \"Разработка в сфере IT\".",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Добавить оплату Cryptobot api в бота автопродаж на PHP",
                "4 000",
                new String[]{"php"},
                "Имеется бот автопродаж написанный на PHP\n" +
                        "Нужно встроить в него оплату через API обменника CryptoBot\n" +
                        "Чем быстрее тем лучше.",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Нужно доделать интернет магазин на wordpress с использованием woocomem",
                "14 000",
                new String[]{"wordpress"},
                "Необходимо доработать WordPress шаблон, настроить интеграцию с 1с, исправить незначительные баги.",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Доработка бота для торговли на языке Rust",
                "100 000",
                new String[]{"rust"},
                "У нас написан специальный робот (арбитраж) для торговли на нескольких биржах на языке Rust.\n" +
                        "У вас должны быть глубокие знания в языке Rust и желательно небольшие знания в трейдинге.\n" +
                        "В настоящий момент у нас есть срочные доработки по боту.",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Настройки подмены WEBRTC и DNS через titanium web proxy или аналог C#",
                "Договорная",
                new String[]{"csharp"},
                "Нужен способ создания прокси titanium web proxy или аналог для C# с " +
                        "возможностью подмены или блокировки WEBRTC и или DNS от установленного прокси для C#\n" +
                        "Что бы работало для установки прокси в selenium или puppeteer",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Задачи по wordpress (связать два плагина + поработать с формами)",
                "6 700",
                new String[]{"wordpress", "php", "javascript"},
                "Есть проект на wordpress. Используются плагины Metfroms (на нем построены формы) и Лейка " +
                        "(принимает и управляет пожертвованиями). Нужно их связать: пусть в принятых данных с форм " +
                        "отмечается факт оплаты через плагин Лейка. Плюс поработать с формами: " +
                        "настроить расчет суммы пожертвования в зависимости от количества введенных строк текста в одно из окон формы.",
                new Date()));
        orderCounter++;
    }

    public ArrayList<Task> getLatestTasks() {
        ArrayList<Task> result = new ArrayList<>();
        result.addAll(tasks.subList(tasks.size()-3,tasks.size()));
        return result;
    }
}

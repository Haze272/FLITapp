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

        tasks.add(new Task(
                orderCounter,
                "Нужен парсер локально сохраненных HTML (структура у всех схожая) ",
                "6 000",
                new String[]{"html", "mysql", "php"},
                "Задачи\n" +
                        "1.1) Собрать в примитивную mysql БД данные из локально хранящихся HTML (структура у однотипная, но несколько полей с заморочками, нужно будет подумать как нормально извлечь)\n" +
                        "1.2) Некоторые строки разобрать на элементы по описанной логике (логика не проверена, возможно придется ВАМ найти решение как корректно разобрать)\n" +
                        "1.3) Поставить в некоторые колонки метки при определенных условиях (нужны хорошие навыки mysql)\n" +
                        "\n" +
                        "Требования\n" +
                        "2.1) скрипт должен быть написан на PHP, если для задачи возможно, то асинхронный (html много, обрабатывать должен быстро) + нужен GUI\n" +
                        "2.2) скрипт будет использоваться на буке, в OpenServer (позже возможно в Docker), БД лежит там же.\n" +
                        "2.3) позднее из этой БД нужно будет извлекать данные поисковыми запросами - учесть это сейчас, при работе с базой (индексы и т.п.)\n" +
                        "2.4) всю эту радость собрать на виртуалке и передать мне. настроить у меня, если что-то не \"взлетит\"",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Доработка проекта на Delphi",
                "Договорная",
                new String[]{"delphi"},
                "Есть проект RTC Portal VCL (аналог RAdmin)\n" +
                        "Есть второй проект того же разработчика RTC Portal X (в нем используется Desktop Duplication Library для получения содержимого экрана)\n" +
                        "Необходимо из второго проекта перенести эту часть в первый.\n" +
                        "\n" +
                        "RTC Portal VCL\n" +
                        "https://github.com/CloudDelphi/RTC-Portal-VCL\n" +
                        "RTC Portal X\n" +
                        "https://github.com/maciej-izak-tests/RTC-Portal-X",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Поддержка сайта Laravel",
                "50 000",
                new String[]{"php", "laravel"},
                "Движок: Lavarel\n" +
                        "Сайт: carloson.ru\n" +
                        "Задача: Поддержка сайта и внедрение новых доработок.",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Развернуть архив phyton",
                "1 000",
                new String[]{"python"},
                "Была изначально задача которую я опишу снизу\n" +
                        "Исполнитель ее выполнил и показал на своём сервере\n" +
                        "Но после оплаты пропал\n" +
                        "Есть архив с его работой нужно развернуть\n" +
                        "\n" +
                        "Ссвязь тг",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Написать два алгоритма на языке С++ оптимизированных под арх. Эльбрус",
                "25 000",
                new String[]{"cpp"},
                "Сравнительный анализ производительности вычислительных задач при использов" +
                        "ании технологии контейнеризации LXC в среде ОС “Эльбрус”.\n" +
                        "\n" +
                        "\n" +
                        "Нужно настроить контейнеризацию, затем написать два алгоритма: Алгоритм быст" +
                        "рого преобразования Фурье и алгоритм умножения квадратный матриц, оптимизиров" +
                        "анных под архитектуру эльбрус, затем, спомпилировать их и замерить время исполн" +
                        "ения данных алгоритмов в контейнерах и без них - одновременный запуск задач в не" +
                        "скольких контейнерах параллельно, и запуск параллельно на самой машине без конте" +
                        "йнеров. После этого, провести анализ, можно построить график, как влияют контейнеры" +
                        " на производительность, лучше или хуже. Если получится, то оформить это как один связанный" +
                        " текст, т.е. проект(диплом). Должно быть расписано, как именно производится оптимизация" +
                        " и как что настраивается. Цена договорная. Наработки по теории имеются и различная документация.",
                new Date()));
        orderCounter++;

        tasks.add(new Task(
                orderCounter,
                "Внести правки на сайте MODX Revo",
                "Договорная",
                new String[]{"modx", "php"},
                "На сайте реализована мультиязычность по ip(местонахождению, по стране)," +
                        " нужно прописать определённые номер для определённых стран, под каждую" +
                        " языковую версию, для этого уже всё реализовано.",
                new Date()));
        orderCounter++;
    }

    public ArrayList<Task> getLatestTasks() {
        ArrayList<Task> result = new ArrayList<>();
        result.addAll(tasks.subList(tasks.size()-12,tasks.size()));
        return result;
    }
}

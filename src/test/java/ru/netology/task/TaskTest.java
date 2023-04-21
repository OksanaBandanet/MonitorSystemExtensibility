package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void trueMatchesMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void trueMatchesMeetingTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void falseMatchesMeetingProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Супер предложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean actual = simpleTask.matches("озво");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean actual = simpleTask.matches("яблоко");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testMeetingTrue() {
        Meeting meeting = new Meeting(5, "Домашняя работа", "Джава", "20:00");


        boolean actual = meeting.matches("Джава");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingFalse() {
        Meeting meeting = new Meeting(5, "Домашняя работа", "Джава", "19:00");


        boolean actual = meeting.matches("Питон");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicTrue() {
        String[] subtasks = {"Поменять колеса", "Поздравить бабушку", "Купить хлеб"};
        Epic epic = new Epic(55, subtasks);

        Boolean actual = epic.matches("колеса");
        Boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicFalse() {
        String[] subtasks = {"Поменять колеса", "Поздравить бабушку", "Купить хлеб"};
        Epic epic = new Epic(55, subtasks);

        Boolean actual = epic.matches("машину");
        Boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
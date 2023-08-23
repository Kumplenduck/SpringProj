package ru.kram.springcourse.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.*;
public class Person {
    private int id;

    @NotEmpty(message = "ФИО не может быть пустым")
    @Size(min = 2, max = 100, message = "ФИО должно быть длинною от 2 до 100 символов")
    @Pattern(regexp = "[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+",
    message = "Ваши ФИО должны быть в формате: Фамилия Имя Отчество")
    private String fio;

    @Min(value = 1950, message = "Дата рождения не может быть раньше 1950")
    private int year_of_birth;

    public Person() {

    }

    public Person(int id, String fio, int year_of_birth) {
        this.id = id;
        this.fio = fio;
        this.year_of_birth = year_of_birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}

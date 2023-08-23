package ru.kram.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="Book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    @NotEmpty(message = "ФИО автора не может быть пустым")
    @Size(min = 2, max = 100, message = "ФИО автора должно быть длинною от 2 до 100 символов")
    @Pattern(regexp = "(([А-ЯЁ][а-яё]+[\\-\\s]?){3,})|(([А-ЯЁ][а-яё]+[\\-\\s]?){2,})",
            message = "ФИО автора должны быть в формате: Фамилия Имя Отчество / Фамилия Имя")
    private String author;

    @Column(name = "year")
    @Min(value = 1200, message = "Дата написания книги не может быть раньше 1200")
    private int year;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "taken_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenTime;

    @Transient
    private boolean overdue;

    public Book() {
    }

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(Date takenTime) {
        this.takenTime = takenTime;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }
}

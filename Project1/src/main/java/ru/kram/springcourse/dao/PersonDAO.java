package ru.kram.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kram.springcourse.models.Book;
import ru.kram.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

//    public Optional<Person> show(String email) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new Object[]{email}, new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny();
//    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
         jdbcTemplate.update("INSERT INTO Person(fio, year_of_birth) VALUES( ?, ?)",
                person.getFio(), person.getYear_of_birth());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET fio=?, year_of_birth=? WHERE id=?",
                updatedPerson.getFio(), updatedPerson.getYear_of_birth(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public List<Book> getListBook(int id){
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}

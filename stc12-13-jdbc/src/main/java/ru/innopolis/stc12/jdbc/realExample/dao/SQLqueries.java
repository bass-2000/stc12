package ru.innopolis.stc12.jdbc.realExample.dao;

public class SQLqueries {

    static final String INSERT_INTO_STUDENTS_VALUES = "INSERT  into students values(default , ?, ?, ?, ?,?)";
    static final String SELECT_STUDENT_BY_ID = "SELECT * from students WHERE id = ?";
    static final String UPDATE_STUDENTS_BY_ID = "UPDATE students SET name=?, family_name=?, age=?, contact=?, city=? WHERE id=?";
    static final String DELETE_FROM_STUDENTS_BY_ID = "DELETE FROM students WHERE id=?";


    static final String INSERT_INTO_CITIES_VALUES = "INSERT  into cities values(default , ?, ?)";
    static final String SELECT_CITY_BY_ID = "SELECT * from cities WHERE id = ?";
    static final String UPDATE_CITIES_BY_ID = "UPDATE cities SET name=?, population=? WHERE id=?";
    static final String DELETE_FROM_CITIES_BY_ID = "DELETE FROM cities WHERE id=?";


}

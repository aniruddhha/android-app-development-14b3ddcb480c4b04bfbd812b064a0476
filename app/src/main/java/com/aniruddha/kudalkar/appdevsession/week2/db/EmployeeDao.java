package com.aniruddha.kudalkar.appdevsession.week2.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    void saveEmployee(Employee emp);

    @Query("delete from emp_data where id = :id")
    void deleteEmployee(Long id);

    @Query("select * from emp_data")
    List<Employee> findAll();
}

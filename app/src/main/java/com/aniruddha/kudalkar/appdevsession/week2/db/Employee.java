package com.aniruddha.kudalkar.appdevsession.week2.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "emp_data")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "emp_name")
    private String name;

    @ColumnInfo(name = "emp_dep")
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

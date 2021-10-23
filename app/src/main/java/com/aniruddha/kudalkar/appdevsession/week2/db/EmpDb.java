package com.aniruddha.kudalkar.appdevsession.week2.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = { Employee.class }, version = 1)
public abstract class EmpDb extends RoomDatabase {

    public abstract EmployeeDao employeeDao();
}

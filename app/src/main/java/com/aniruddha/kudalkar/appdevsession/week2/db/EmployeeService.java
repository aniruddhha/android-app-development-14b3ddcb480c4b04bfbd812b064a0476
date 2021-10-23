package com.aniruddha.kudalkar.appdevsession.week2.db;


import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class EmployeeService {

    private final EmployeeDao dao;

    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public Observable<String> saveEmployee(Employee emp) {
        return Observable.create(emitter -> {
            dao.saveEmployee(emp);
            emitter.onNext("saved");
            emitter.onComplete();
        });
    }

    public Observable<List<Employee>> findAll() {
        return Observable.create(emitter -> {
           final List<Employee> employees = dao.findAll();
           emitter.onNext(employees);
           emitter.onComplete();
        });
    }

    public Observable<String> deleteEmployee(Long id) {
        return Observable.create(emitter -> {
            dao.deleteEmployee(id);
            emitter.onNext("deleted");
            emitter.onComplete();
        });
    }

}

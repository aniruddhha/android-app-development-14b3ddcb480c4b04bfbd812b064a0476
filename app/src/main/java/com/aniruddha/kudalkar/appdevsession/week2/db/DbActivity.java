package com.aniruddha.kudalkar.appdevsession.week2.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.aniruddha.kudalkar.appdevsession.R;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        final EmpDb db = initDb();

        final EmployeeDao dao = db.employeeDao();
        final EmployeeService service = new EmployeeService(dao);

        findViewById(R.id.btSv).setOnClickListener(v -> {

            final TextView txt = findViewById(R.id.txLg);
            final EditText etNm = findViewById(R.id.etEmpNm);
            final EditText etEmpDep = findViewById(R.id.etEmpDep);

            final Employee emp = new Employee();
            emp.setName(etNm.getText().toString());
            emp.setDepartment(etEmpDep.getText().toString());

            service.saveEmployee(emp)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .doOnNext(txt::setText)
                    .subscribe();
        });

        findViewById(R.id.btFnd).setOnClickListener( v -> {
            final TextView txt = findViewById(R.id.txLg);

            service.findAll()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .doOnNext( employees -> {
                        txt.setText("");
                        for (Employee e : employees) {
                            txt.append("Id: "+e.getId());
                            txt.append(" Nm: "+e.getName());
                            txt.append(" Dep: "+e.getDepartment());
                            txt.append(" \n ");
                        }
                    })
                    .subscribe();
        });

        findViewById(R.id.btDl).setOnClickListener( v -> {

            final TextView txt = findViewById(R.id.txLg);
            final EditText etNm = findViewById(R.id.etEmpNm);

            service.deleteEmployee(Long.parseLong(etNm.getText().toString()))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .doOnNext(txt::setText)
                    .subscribe();
        });
    }

    private EmpDb initDb() {
        return Room
                .databaseBuilder(this, EmpDb.class, "empdb")
                .build();
    }

    private void badThreadedApproach(EmployeeDao dao){

        final Employee emp1 = new Employee();
        emp1.setDepartment("dep1");
        emp1.setName("abc");

        new Thread(() -> { // bad approach
            dao.saveEmployee(emp1); // heavy operation -> bad to perform on main thread
        }).start();

        new Thread(() -> {
            final List<Employee> employees = dao.findAll();

            for (Employee e: employees ) {
                Log.i("@ani", "Name - "+e.getName());
                Log.i("@ani", "Department - "+e.getDepartment());
                Log.i("@ani", "Id - "+e.getId());
            }
        }).start();
    }

    private void goodRxApproach(EmployeeService service) {

        final TextView txt = findViewById(R.id.txLg);

        final Employee emp1 = new Employee();
        emp1.setDepartment("dep1");
        emp1.setName("abc");

        service.saveEmployee(emp1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext( str -> txt.setText(str) )
                .subscribe();

        service.findAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnNext( employees -> {
                    txt.setText("");
                    for (Employee e : employees) {
                        txt.append("Id: "+e.getId());
                        txt.append(" Nm: "+e.getName());
                        txt.append(" Dep: "+e.getDepartment());
                        txt.append(" \n ");
                    }
                })
                .subscribe();
    }
}
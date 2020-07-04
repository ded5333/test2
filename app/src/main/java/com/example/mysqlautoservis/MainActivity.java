package com.example.mysqlautoservis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Worker> workerArrayList = new ArrayList<>();
    public ArrayList<Car> carArrayList = new ArrayList<>();

    public String[] nameHuman = new String[]{"Oleg", "Valiriy", "Ivan", "Victor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBhelper mydBhelper = new MyDBhelper(this);

        SQLiteDatabase db = mydBhelper.getReadableDatabase();

        workerArrayList.add(new Worker(nameHuman[0], "Mehanic", 30));
        workerArrayList.add(new Worker(nameHuman[1], "Electic", 32));
        workerArrayList.add(new Worker(nameHuman[2], "Motorist", 35));
        workerArrayList.add(new Worker(nameHuman[3], "Mehanic", 20));

        carArrayList.add(new Car("Mercedes S-class", "Electrica", 2000));
        carArrayList.add(new Car("BMW 7 series", "Motor", 20000));
        carArrayList.add(new Car("Audi A8", "Electrica", 3000));
        carArrayList.add(new Car("VW Passta", "Electrica", 1000));
        //    carArrayList.add(new Car("Mercedes S-class","Motor",42000));


        saveCars(db);
      saveWorkers(db);

//        Cursor cursor = db.query("Worker",new String[]{"name","skill","age","carId"},null,
//                null,null,null,null);
//            while (cursor.moveToNext()){
//
//            }
    }

    void saveCars(SQLiteDatabase db) {
        for (int i = 0; i < carArrayList.size(); i++) {
            Car car = carArrayList.get(i);

            ContentValues values = new ContentValues();
            values.put("markaModel", car.markaModel);
            values.put("crash", car.crash);
            values.put("priceCrash", car.priceCrash);

            long carId = db.insert("Cars", "markaModel,crash,priceCrash", values);
            car.id = carId;
        }
    }

    List<Car> loadCars() {
        return null;
    }

    void saveWorkers(SQLiteDatabase db) {
        for (int i = 0; i < workerArrayList.size(); i++) {
            Worker worker = workerArrayList.get(i);
            worker.cars.add(carArrayList.get(i));

            ContentValues values = new ContentValues();
            values.put("name", worker.name);
            values.put("skill", worker.skill);
            values.put("age", worker.age);
            values.put("carId", worker.cars.get(0).id);

            db.insert("Worker","name,skill,age,carId",values);

            String detailInfo = worker.name + " " + worker.skill + " " + worker.age + " [";
            for (int j = 0; j < worker.cars.size(); j++) {
                Car car = worker.cars.get(j);
                detailInfo += car.markaModel + " " + car.crash
                        + " " + car.priceCrash + " ,";
            }

            detailInfo += "]";


            Log.d("TAG", detailInfo);



        }

    }

    List<Worker> loadWorkers() {
        return null;
    }
}

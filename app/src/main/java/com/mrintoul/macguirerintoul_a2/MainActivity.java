package com.mrintoul.macguirerintoul_a2;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView sensorRecyclerView;
    private RecyclerView.Adapter sensorAdapter;
    private RecyclerView.LayoutManager sensorLayoutManager;
    private SensorManager mySensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = mySensorManager.getSensorList(Sensor.TYPE_ALL);

        sensorRecyclerView = findViewById(R.id.sensorRecyclerView);

        // use a linear layout manager
        sensorLayoutManager = new LinearLayoutManager(this);
        sensorRecyclerView.setLayoutManager(sensorLayoutManager);

        // specify an adapter (see also next example)
        sensorAdapter = new MyAdapter(sensorList);
        sensorRecyclerView.setAdapter(sensorAdapter);



    }
}

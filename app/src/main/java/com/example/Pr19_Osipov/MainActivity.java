package com.example.Pr19_Osipov;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.Listener {

    TextView textView;
    Button btnDate, btnTime, btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
        btnCustom = findViewById(R.id.btnCustom);

        btnDate.setOnClickListener(v -> showDateDialog());
        btnTime.setOnClickListener(v -> showTimeDialog());
        btnCustom.setOnClickListener(v ->
                new MyDialogFragment().show(getSupportFragmentManager(), "dialog"));
    }

    private void showDateDialog() {
        Calendar c = Calendar.getInstance();

        new DatePickerDialog(this,
                (view, year, month, day) ->
                        textView.setText(day + "." + (month + 1) + "." + year),
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    private void showTimeDialog() {
        Calendar c = Calendar.getInstance();

        new TimePickerDialog(this,
                (view, hour, minute) ->
                        textView.setText(hour + ":" + minute),
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true
        ).show();
    }

    // получение данных из DialogFragment
    @Override
    public void onResult(String data) {
        textView.setText(data);
    }
}

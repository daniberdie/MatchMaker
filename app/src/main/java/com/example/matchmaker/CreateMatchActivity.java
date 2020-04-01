package com.example.matchmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.time.Clock;
import java.util.Calendar;
import java.util.Locale;

public class CreateMatchActivity extends AppCompatActivity {

    private EditText description_editText, location_editText, date_editText, time_editText, players_editText;
    private Spinner level_spinner;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_match);

        description_editText = findViewById(R.id.description_editText);
        location_editText = findViewById(R.id.ubication_editText);
        date_editText = findViewById(R.id.date_editText);
        time_editText = findViewById(R.id.time_editText);
        level_spinner = findViewById(R.id.level_spinner);
        players_editText = findViewById(R.id.players_editText);

        String [] level_options = {getString(R.string.all_level),getString(R.string.low_level),getString(R.string.mid_level),getString(R.string.high_level)};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(CreateMatchActivity.this, R.layout.spinner_item_level_options, level_options);
        level_spinner.setAdapter(adapter);

        //Mostrar calendari al apretar a sobre del editText de la data
        date_editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCalendar();
            }
        });

        //Mostrar rellotge al apretar a sobre del editText de la data
        time_editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayClock();
            }
        });

        //Escriure al EditText de la data
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth + "/" + month + "/" + year;
                date_editText.setText(date);
            }
        };

        //Escriure al EditText de la hora
        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = convertDate(hourOfDay) + ":" + convertDate(minute);
                time_editText.setText(time);
            }
        };
    }

    //Afegir 0 davant de els minuts o hores en cas de ser de una xifra.
    public String convertDate(int input) {
        if (input >= 10) {
            return String.valueOf(input);
        } else {
            return "0" + String.valueOf(input);
        }
    }

    private void displayClock() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(CreateMatchActivity.this,
                                                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                                        mTimeSetListener,
                                                        hour+2,minute,true);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void displayCalendar() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(CreateMatchActivity.this,
                                                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                                        mDateSetListener,
                                                        year,month,day);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}

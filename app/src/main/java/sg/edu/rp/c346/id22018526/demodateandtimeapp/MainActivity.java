package sg.edu.rp.c346.id22018526.demodateandtimeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;

    Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.datebtn);
        btnDisplayTime = findViewById(R.id.timebtn);
        tvDisplay = findViewById(R.id.TimeView);
        btnReset = findViewById(R.id.resetbtn);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                int timehour = tp.getHour();
                int timeminute = tp.getMinute();
                if (timeminute < 10) {
                   String time = String.format(Locale.ENGLISH,"%d:0%d",timehour, timeminute);
                    tvDisplay.setText("My time is " + time);
                }
                else {
                    String time = String.format(Locale.ENGLISH,"%d:%d",timehour, timeminute);
                    tvDisplay.setText("My time is " + time);
                }



            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dateYear = dp.getYear();
                int dateMonth = dp.getMonth() + 1;
                int dateDay = dp.getDayOfMonth();
                String date = String.format(Locale.ENGLISH,"%d/%d/%d",dateDay,dateMonth,dateYear);
                tvDisplay.setText("Date is " + date);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setHour(12);
                tp.setMinute(0);
                dp.updateDate(2020,1,1);

            }
        });
    }
}
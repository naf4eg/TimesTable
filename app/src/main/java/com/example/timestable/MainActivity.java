package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumbers;
    private SeekBar seekBar;

    private ArrayList<Integer> number;

    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNumbers = findViewById(R.id.listViewNumbers);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max); //максимальное значение сикбара

        number = new ArrayList<>();

        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, number);

        listViewNumbers.setAdapter(arrayAdapter);

        //слушатель события для seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //вызывается когда изменен прогресс на сикбаре
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                number.clear();

                if (progress < min){
                    seekBar.setProgress(min);
                }

                for (int i = min; i <= count; i++) {
                    number.add(seekBar.getProgress() * i);
                }

                arrayAdapter.notifyDataSetChanged(); //говорим адаптеру: обрати внимание что данные изменились
            }

            //когда начинает двигать кружочек
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //когда отпускает кружочек
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}

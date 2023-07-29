package com.bgkim.iotfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sp = getSharedPreferences("IoTFeedIP", MODE_PRIVATE);
//        Toast.makeText(getApplicationContext(), String.format("%d.%d.%d.%d:%d", sp.getInt("IoTFeedIP1", 0), sp.getInt("IoTFeedIP2", 0), sp.getInt("IoTFeedIP3", 0), sp.getInt("IoTFeedIP4", 0), sp.getInt("IoTFeedPORT", 0)), Toast.LENGTH_LONG).show();

        Button btnSetTime = (Button) findViewById(R.id.buttonTimeSel);
        Button btnFeed = (Button) findViewById(R.id.buttonFeed);
        Button btnSettings = (Button) findViewById(R.id.buttonSettings);

        TextView textViewTime = (TextView) findViewById(R.id.textViewTime);
        SeekBar seekBarTime = (SeekBar) findViewById(R.id.seekBar);
        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewTime.setText(String.format("%d시입니다.", seekBarTime.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewTime.setText(String.format("%d시입니다.", seekBarTime.getProgress()));
            }
        });


        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SetTimeActivity.class);
                intent.putExtra("t", seekBarTime.getProgress());
                startActivity(intent);
            }
        });
        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
                startActivity(intent);
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}
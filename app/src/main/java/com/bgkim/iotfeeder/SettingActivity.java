package com.bgkim.iotfeeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        SharedPreferences sp = getSharedPreferences("IoTFeedIP", MODE_PRIVATE);

        SharedPreferences.Editor spe = sp.edit();

        EditText ip1 = findViewById(R.id.editTextNumber);
        EditText ip2 = findViewById(R.id.editTextNumber4);
        EditText ip3 = findViewById(R.id.editTextNumber3);
        EditText ip4 = findViewById(R.id.editTextNumber5);
        EditText portedit = findViewById(R.id.editTextNumber6);

        Button buttonSave = findViewById(R.id.buttonSaveExit);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spe.putInt("IoTFeedIP1", Integer.parseInt(ip1.getText().toString()));
                spe.putInt("IoTFeedIP2", Integer.parseInt(ip2.getText().toString()));
                spe.putInt("IoTFeedIP3", Integer.parseInt(ip3.getText().toString()));
                spe.putInt("IoTFeedIP4", Integer.parseInt(ip4.getText().toString()));
                spe.putInt("IoTFeedPORT", Integer.parseInt(portedit.getText().toString()));
                spe.commit();
//                Toast.makeText(getApplicationContext(), String.format("%d.%d.%d.%d:%d", sp.getInt("IoTFeedIP1", 0), sp.getInt("IoTFeedIP2", 0), sp.getInt("IoTFeedIP3", 0), sp.getInt("IoTFeedIP4", 0), sp.getInt("IoTFeedPORT", 0)), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
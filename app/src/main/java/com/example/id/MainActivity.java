package com.example.id;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etId;
    Button btn1;
    TextView tV;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etId = findViewById(R.id.etID);
        btn1 = findViewById(R.id.btn1);
        tV   = findViewById(R.id.tV);

        btn1.setOnClickListener(view -> {
            String idNumber = etId.getText().toString().trim();
            String dob      = idNumber.substring(0,6);
            int gender      = Integer.parseInt(Character.toString(idNumber.charAt(6)));

            String sGender;

            if (gender < 5)
                sGender = "Female";
            else
                sGender = "Male";

            int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

            String snationality;

            if(nationality == 0)
                snationality = "SA Citizen";
            else
                snationality = "Permanent Resident";

            tV.setText(getString(R.string.date_of_birth)+dob+"\n"+
                        getString(R.string.gender)+sGender+"\n"+
                        getString(R.string.nationality) +snationality);
        });
    }
}
package com.example.vouchersteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpdateProfileSuccessActivity extends AppCompatActivity {

    private Button home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile_success);

        /** button kembali ke home page*/

        home_btn = (Button) findViewById(R.id.btn_backtohome);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backtohome();
            }
        });
    }

    public void backtohome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

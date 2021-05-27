package com.example.vouchersteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /** membuka logout activity*/

        btn_logout = (Button) findViewById(R.id.bt_logout3);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogoutActivity();
            }
        });
    }

    public void openLogoutActivity(){
        Intent intent = new Intent(this, LogoutActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slied_in_right, R.anim.slide_out_left);
    }
}

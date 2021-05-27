package com.example.vouchersteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private Button btn_editprofil;
    private Button btn_delete;
    private TextView txtemail;
    private TextView txtpassword;
    private FirebaseAuth fAuth;
    private TextView btnCashoutHome;
    private FirebaseAuth.AuthStateListener fStateListener;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtemail = (TextView) findViewById(R.id.et_email);
        txtpassword = (TextView) findViewById(R.id.et_password);
        fAuth = FirebaseAuth.getInstance();

        /** kembali main page */

        btnCashoutHome= (TextView) findViewById(R.id.btn_cashouthome);
        btnCashoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        /** membuka activity update profile success*/

        btn_editprofil = (Button) findViewById(R.id.btn_editprofile);
        btn_editprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfileActivity();
            }
        });

        account();
    }


    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openEditProfileActivity() {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }

    private void account() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            txtemail.setText(email);
        }
    }
}
package com.example.vouchersteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TransactionProduct20Activity extends AppCompatActivity {

    private ImageView btnTopUp;
    private TextView btnTopUp2;
    private Button btnPay;
    private TextView btnCashoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_product20);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /** kembali main page */

        btnCashoutHome= (TextView) findViewById(R.id.btn_cashouthome);
        btnCashoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        /** membuka top up page */

        btnTopUp = (ImageView) findViewById(R.id.btn_topUp);
        btnTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopUpActivity();
            }
        });

        /** membuka top up page */

        btnTopUp2 = (TextView) findViewById(R.id.btn_topUp2);
        btnTopUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopUpActivity2();
            }
        });

        /** membuka transaction complete page */
        
        btnPay = (Button) findViewById(R.id.btn_pay20);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactionCompleteActivity();
            }
        });
        
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openTransactionCompleteActivity(){
        Intent intent = new Intent(this, TransactionCompleteActivity.class);
        startActivity(intent);
    }

    public void openTopUpActivity2(){
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slied_in_right, R.anim.slide_out_left);
    }

    public void openTopUpActivity(){
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slied_in_right, R.anim.slide_out_left);
    }
}
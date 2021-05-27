package com.example.vouchersteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VoucherProduct20Activity extends AppCompatActivity {

    private Button btnBuy;
    private TextView btnCashoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_product20);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /** kembali main page */

        btnCashoutHome= (TextView) findViewById(R.id.btn_cashouthome);
        btnCashoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        /** tombol ke transaction page*/

        btnBuy = (Button) findViewById(R.id.btn_buy20);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactionProduct20Activity();
            }
        });

    }

    public void openTransactionProduct20Activity(){
        Intent intent = new Intent(this, TransactionProduct20Activity.class);
        startActivity(intent);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
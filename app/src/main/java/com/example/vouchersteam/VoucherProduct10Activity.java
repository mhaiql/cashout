package com.example.vouchersteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VoucherProduct10Activity extends AppCompatActivity {

    private Button btnBuy10;
    private TextView btnCashoutHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_product10);
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

        btnBuy10 = (Button) findViewById(R.id.btn_buy10);
        btnBuy10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactionProduct10Activity();
            }
        });

    }

    public void openTransactionProduct10Activity(){
        Intent intent = new Intent(this, TransactionProduct10Activity.class);
        startActivity(intent);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
package com.example.vouchersteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class MainActivity extends AppCompatActivity {
    private Button btCreateDB;
    private Button btViewDB;
    private Button btLogout;
    private TextView tvUser;
    private ImageView profile_btn;
    private ImageView settings_btn;
    private FirebaseAuth fAuth;
    private TextView btnVoucher5;
    private TextView btnVoucher10;
    private TextView btnVoucher20;
    private ImageView btnTopUp;
    private TextView btnTopUp2;
    private FirebaseAuth.AuthStateListener fStateListener;
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLogout = (Button)findViewById(R.id.bt_logout3);
        tvUser = (TextView) findViewById(R.id.tv_user);
        fAuth = FirebaseAuth.getInstance();

        /** method membuka menu profile*/

        profile_btn = (ImageView) findViewById(R.id.btn_profile);
        profile_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openProfileActivity();
            }
        });


        /** method membuka settings */

        settings_btn = (ImageView) findViewById(R.id.btn_settings);
        settings_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });

        /** membuka page product voucher steam $5*/

        btnVoucher5 = (TextView) findViewById(R.id.btn_voucher5);
        btnVoucher5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVoucherProduct5Activity();
            }
        });

        /** membuka page product voucher steam $10*/

        btnVoucher10 = (TextView) findViewById(R.id.btn_voucher10);
        btnVoucher10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVoucherProduct10Activity();
            }
        });

        /** membuka page product voucher steam $10*/

        btnVoucher20= (TextView) findViewById(R.id.btn_voucher20);
        btnVoucher20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVoucherProduct20Activity();
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

        /**
         * Cek apakah ada user yang sudah login
         */
        fStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User sedang login
                    Log.v(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    /**
                     * Method ini akan dipanggil apabila user berhasil logout
                     */
                    Toast.makeText(MainActivity.this, "User Logout\n",
                            Toast.LENGTH_SHORT).show();
                    Log.v(TAG, "onAuthStateChanged:signed_out");
                    startActivity(new Intent(MainActivity.this,
                            LoginActivity.class));
                    finish();
                }
            }
        };
        checkLogin();
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

    public void openVoucherProduct20Activity(){
        Intent intent = new Intent(this, VoucherProduct20Activity.class);
        startActivity(intent);
    }

    public void openVoucherProduct10Activity(){
        Intent intent = new Intent(this, VoucherProduct10Activity.class);
        startActivity(intent);
    }

    public void openVoucherProduct5Activity(){
        Intent intent = new Intent(this, VoucherProduct5Activity.class);
        startActivity(intent);
    }

    public void openSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slied_in_right, R.anim.slide_out_left);
    }

    public void openProfileActivity() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void logout(View v) {
        fAuth.signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
    private void checkLogin(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            tvUser.setText("Welcome, " + email);
        }
    }
}

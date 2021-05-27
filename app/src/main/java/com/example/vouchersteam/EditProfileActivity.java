package com.example.vouchersteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditProfileActivity extends AppCompatActivity {

    private Button btn_save;
    private Button btn_delete;
    private TextView btnCashoutHome;
    private ProgressBar progressBar;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_save = (Button) findViewById(R.id.bt_saveprofile2);

        btn_delete = (Button) findViewById(R.id.bt_deleteprofile);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(EditProfileActivity.this);
                dialog.setTitle("Are you sure?");
                dialog.setMessage("Deleting this account will result in completely removing your " +
                        "account from the system and you won't be able to access the app.");
                dialog.setPositiveButton("Delete", (dialog1, which) -> firebaseUser.delete().addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(EditProfileActivity.this,"Account Deleted"
                                ,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(EditProfileActivity.this,DeleteAcountActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                    }else {
                        Toast.makeText(EditProfileActivity.this,task.getException().getMessage()
                                ,Toast.LENGTH_LONG).show();
                    }
                }));

                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText updatepassword = new EditText(v.getContext());

                final AlertDialog.Builder passwordupdateDialog = new AlertDialog.Builder(v.getContext());
                passwordupdateDialog.setTitle("Update Password?");
                passwordupdateDialog.setMessage("Enter New Password.");
                passwordupdateDialog.setView(updatepassword);

                passwordupdateDialog.setPositiveButton("Yes",(dialog, which) -> {
                    String newPassword = updatepassword.getText().toString();
                    firebaseUser.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(EditProfileActivity.this, "Update Password Successfully.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(EditProfileActivity.this,UpdateProfileSuccessActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EditProfileActivity.this, "Update Password Failed", Toast.LENGTH_SHORT).show();
                        }
                    });

                });
                passwordupdateDialog.setNegativeButton("No",(dialog, which) -> {
                });
                passwordupdateDialog.create().show();
            }
        });
    }


    private void openUpdateProfileSuccessActivity() {
        Intent intent = new Intent(this, UpdateProfileSuccessActivity.class);
        startActivity(intent);
    }

}
package com.android.apps.ashu.alberticipher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.AlertDialog;
import android.widget.Toast;

public class Decription extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decription);

        final Button button = findViewById(R.id.deciptMessgeButton3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startRealDecryption(v);
            }
        });
    }
    public void startRealDecryption(View view) {
        final EditText message = (EditText) findViewById(R.id.deciptMessge3);
        final EditText initialKey = (EditText) findViewById(R.id.initialEncryptor3);
        final TextView tv = (TextView) findViewById(R.id.resultScreen3);
        builder = new AlertDialog.Builder(this);


        Intent intent = new Intent(this, EncriptionWithOneKey.class);
        startActivity(intent);
        String messageToEncript=message.getText().toString();
        String initialEncription=Character.toString(initialKey.getText().toString().toLowerCase().charAt(0));

        final String result = EncriptionDecriptionFunctions.getDecryptedTextWithOneKey(messageToEncript,initialEncription);
        tv.setText(result);

        builder.setMessage(result)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(),result,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Your Multiple encripted message");
        alert.show();

    }

}
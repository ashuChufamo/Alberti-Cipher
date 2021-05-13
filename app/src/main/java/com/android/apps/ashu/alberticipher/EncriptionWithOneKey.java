package com.android.apps.ashu.alberticipher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EncriptionWithOneKey extends AppCompatActivity {


    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encription_with_one_key);

        final Button button = findViewById(R.id.encryptWithOneKey1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startRealEncription(v);
            }
        });
    }



    public void startRealEncription(View view) {
        final EditText message = (EditText) findViewById(R.id.messageOneKey1);
        final EditText initialKey = (EditText) findViewById(R.id.initialEncryptor1);
        final EditText encriptionKey = (EditText) findViewById(R.id.encriptingKey1);
        final TextView tv = (TextView) findViewById(R.id.resultScreen1);
        builder = new AlertDialog.Builder(this);


        Intent intent = new Intent(this, EncriptionWithOneKey.class);
        startActivity(intent);
        String messageToEncript=message.getText().toString().toUpperCase();
        String initialEncription=Character.toString(initialKey.getText().toString().toLowerCase().charAt(0));
        String mainEncription=Character.toString(encriptionKey.getText().toString().toUpperCase().charAt(0));

        final String result = EncriptionDecriptionFunctions.getEncryptedTextWithOneKey(messageToEncript,initialEncription, mainEncription);
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
        alert.setTitle("Your encripted message");
        alert.show();
    }

}
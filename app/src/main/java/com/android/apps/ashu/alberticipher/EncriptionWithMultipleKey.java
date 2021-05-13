package com.android.apps.ashu.alberticipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.app.AlertDialog;
import android.widget.Toast;

public class EncriptionWithMultipleKey extends AppCompatActivity {


    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encription_with_multiple_key);

        final Button button = findViewById(R.id.encryptWithMultipleKey2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startMultipleRealEncription(v);
            }
        });
    }
    public void startMultipleRealEncription(View view) {
        final EditText message = (EditText) findViewById(R.id.messageMultipleKey2);
        final EditText initialKey = (EditText) findViewById(R.id.initialEncryptor2);
        final EditText encriptionKeys = (EditText) findViewById(R.id.listOfEncriptionKeys2);
        final EditText howMuchToJumpET = (EditText) findViewById(R.id.howMuchToJump2);
        final TextView tv = (TextView) findViewById(R.id.resultScreen2);
        builder = new AlertDialog.Builder(this);


        Intent intent = new Intent(this, EncriptionWithOneKey.class);
        startActivity(intent);
        String messageToEncript=message.getText().toString().toUpperCase();
        String initialEncription=Character.toString(initialKey.getText().toString().toLowerCase().charAt(0));
        int howMuchToJump=Integer.parseInt(howMuchToJumpET.getText().toString());
        String[] mainEncription=(encriptionKeys.getText().toString().split(" "));
        for (String character : mainEncription) {
            character=character.toUpperCase();
        }
        System.out.println(mainEncription);

        final String result = EncriptionDecriptionFunctions.getEncryptedTextWithMultipleKey(messageToEncript,initialEncription, mainEncription, howMuchToJump);
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
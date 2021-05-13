package com.android.apps.ashu.alberticipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.AlertDialog;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button helpButton;
    Button aboutUs;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helpButton = (Button) findViewById(R.id.help);
        aboutUs = (Button) findViewById(R.id.about);
        builder = new AlertDialog.Builder(this);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String help = "\n*This is a cipher application based on Alberti disk." +
                        "\n\n*You can Encript and decript with the help of the disk" +
                        "\n*NOTE. You can only encript CAPITAL letters and 1-4" +
                        "\n*If you give small letters it will be considerd as Upper case" +
                        "\n*To decript you can only use small letters and &" +
                        "\n*Other characters are scaped.";

                //Setting message manually and performing action on button click
                builder.setMessage(help)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Help",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Help ?");
                alert.show();
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String about = "\nAshenafi Chufamo     3774/10" +
                               "\nFasikaw Kindye          1026/10" +
                               "\nGetachew Tebikew     8583/10" +
                               "\nHermela Mulugeta     8006/10" +
                               "\nNaomi Tibe                 9390/10" +
                               "\nYared Solomon           4144/10";




                //Setting message manually and performing action on button click
                builder.setMessage(about)
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"About Us",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Help ?");
                alert.show();
            }
        });
    }

    public void startEncriptionOne(View view) {
        Intent intent = new Intent(this, EncriptionWithOneKey.class);
        startActivity(intent);
    }
    public void startEncriptionMultiple(View view) {
        Intent intent = new Intent(this, EncriptionWithMultipleKey.class);
        startActivity(intent);
    }
    public void startDecription(View view) {
        Intent intent = new Intent(this, Decription.class);
        startActivity(intent);
    }
}
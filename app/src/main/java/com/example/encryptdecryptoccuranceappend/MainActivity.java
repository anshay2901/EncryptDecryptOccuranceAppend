package com.example.encryptdecryptoccuranceappend;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import in.shadowfax.proswipebutton.ProSwipeButton;

public class MainActivity extends AppCompatActivity {

    ProSwipeButton enc_btn, dec_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enc_btn = findViewById(R.id.encryption_swipe);
        dec_btn = findViewById(R.id.decryption_swipe);

        encryptionSwipe();
        decryptionSwipe();

    }

    private void decryptionSwipe() {

        dec_btn.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // task success! show TICK icon in ProSwipeButton
                        dec_btn.showResultIcon(true, true); // false if task failed
                    }
                }, 2000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), DecryptionActivity.class));
                    }
                }, 2100);

                //lol

            }
        });


    }

    private void encryptionSwipe() {

        enc_btn.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // task success! show TICK icon in ProSwipeButton
                        enc_btn.showResultIcon(true, true); // false if task failed
                    }
                }, 2000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), EncryptionActivity.class));
                    }
                }, 2100);
            }
        });

    }
}

package com.example.encryptdecryptoccuranceappend;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class EncryptionActivity extends AppCompatActivity {

    EditText decryptedText_et;
    Button encrypt_btn;
    TextView resultEncryptedText_tv, enteredDecrypted_tv;
    ActionBar actionBar;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Encryption");
        encrypt_btn = findViewById(R.id.enc_button);

        encrypt();

    }

    private void encrypt() {

        encrypt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                decryptedText_et = findViewById(R.id.decrypted_text);
                resultEncryptedText_tv = findViewById(R.id.encryption_result);
                enteredDecrypted_tv = findViewById(R.id.to_encrypt);

                String decrypted_text_entered;
                String encrypted_text_result;
                decrypted_text_entered = decryptedText_et.getText().toString();
                encrypted_text_result = encFn(decrypted_text_entered);
                enteredDecrypted_tv.setText(decryptedText_et.getText().toString());
                resultEncryptedText_tv.setText(encrypted_text_result);
                decryptedText_et.setText("");
            }
        });


    }

    public static String encFn(String str) {
        int n = str.length();
        StringBuilder result = new StringBuilder();
        String temp1;
        String temp2;
        Character temptemp1;
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 &&
                    str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            // Update result
            temptemp1 = str.charAt(i);
            temp1 = temptemp1.toString();
            temp2 = Integer.toString(count);

            result.append(temp1);
            result.append(temp2);

        }
        return result.toString();
    }
}

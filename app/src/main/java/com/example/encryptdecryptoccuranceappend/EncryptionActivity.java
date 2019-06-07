package com.example.encryptdecryptoccuranceappend;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class EncryptionActivity extends AppCompatActivity {

    EditText decryptedText_et;
    Button encrypt_btn;
    TextView resultEncryptedText_tv, enteredDecrypted_tv;
    ActionBar actionBar;
    boolean iscleared = false;


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
        decryptedText_et = findViewById(R.id.decrypted_text);
        resultEncryptedText_tv = findViewById(R.id.encryption_result);
        enteredDecrypted_tv = findViewById(R.id.to_encrypt);


        decryptedText_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                encrypt_btn.setEnabled(false);
                if (!iscleared) {
                    enteredDecrypted_tv.setText("");
                    resultEncryptedText_tv.setText("");
                }
                iscleared = false;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.toString().trim().length() == 0)
                    encrypt_btn.setEnabled(false);
                else
                    encrypt_btn.setEnabled(true);

            }

            @Override
            public void afterTextChanged(Editable s) {


                if (s.toString().trim().length() == 0)
                    encrypt_btn.setEnabled(false);
                else
                    encrypt_btn.setEnabled(true);


            }
        });

        encrypt();

    }

    private void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void encrypt() {

        encrypt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String decrypted_text_entered;
                String encrypted_text_result;
                decrypted_text_entered = decryptedText_et.getText().toString();
                encrypted_text_result = encFn(decrypted_text_entered);
                enteredDecrypted_tv.setText(decryptedText_et.getText().toString());
                resultEncryptedText_tv.setText(encrypted_text_result);
                iscleared = true;
                decryptedText_et.getText().clear();

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

package com.example.encryptdecryptoccuranceappend;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecryptionActivity extends AppCompatActivity {

    EditText encryptedText_et;
    Button decrypt_btn;
    TextView resultDecryptedText_tv, enteredEncrypted_tv;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);

        actionBar = getSupportActionBar();
        decrypt_btn = findViewById(R.id.dec_button);
        encryptedText_et = findViewById(R.id.encrypted_text);
        encryptedText_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    decrypt_btn.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0)
                    decrypt_btn.setEnabled(false);
                else
                    decrypt_btn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().trim().length()==0)
                    decrypt_btn.setEnabled(false);
                else
                    decrypt_btn.setEnabled(true);
            }
        });

        actionBar.setTitle("Decryption");

        decrypt();

    }

    private void decrypt() {

        decrypt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                resultDecryptedText_tv = findViewById(R.id.decryption_result);
                enteredEncrypted_tv = findViewById(R.id.to_decrypt);

                String encrypted_text_entered;
                String decrypted_text_result;
                encrypted_text_entered = encryptedText_et.getText().toString();
                decrypted_text_result = decFn(encrypted_text_entered);
                enteredEncrypted_tv.setText(encryptedText_et.getText().toString());
                resultDecryptedText_tv.setText(decrypted_text_result);
                encryptedText_et.setText("");
            }

        });
        
    }

    public static String decFn(String str)
    {
        int n = str.length();
        StringBuilder result = new StringBuilder();

        if((str.charAt(0) >= 48 && str.charAt(0) <=57)) {
            return "Error: Cannot Start With Number";
        }
        for (int i = 0; i < n; i++) {

            if(!(str.charAt(i) >= 48 && str.charAt(i) <=57)) {
                //temptemp1 = str.charAt(i);
                //Not needed for current use.
            }
            else {

                for(int j = 0; j < Character.getNumericValue(str.charAt(i)); j++) {
                    result.append(str.charAt(i-1));
                }
            }

            // Update result


        }
        return result.toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //finish();
    }

}

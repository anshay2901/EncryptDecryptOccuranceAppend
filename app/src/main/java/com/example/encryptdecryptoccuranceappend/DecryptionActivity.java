package com.example.encryptdecryptoccuranceappend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecryptionActivity extends AppCompatActivity {

    EditText encryptedText_et;
    Button decrypt_btn;
    TextView resultDecryptedText_tv, enteredEncrypted_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);

        decrypt_btn = findViewById(R.id.dec_button);
        
        decrypt();

    }

    private void decrypt() {

        decrypt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                encryptedText_et = findViewById(R.id.encrypted_text);
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

        String temp2;
        Character temptemp1;
        if((str.charAt(0) >= 48 && str.charAt(0) <=57)) {
            return "Error: Cannot Start With Number";
        }
        for (int i = 0; i < n; i++) {

            if(!(str.charAt(i) >= 48 && str.charAt(i) <=57)) {
                temptemp1 = str.charAt(i);

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

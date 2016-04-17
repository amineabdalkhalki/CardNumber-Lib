package com.ccValidation.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.amine.creditcardEt.CardNumberEditText;

public class MainActivity extends AppCompatActivity {

    CardNumberEditText cardInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardInput = (CardNumberEditText)findViewById(R.id.cardInput);
        cardInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > cardInput.getMaxDigits()-2) {
                    if(!cardInput.getCardType().equals(""))
                    Toast.makeText(MainActivity.this, cardInput.getCardType(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

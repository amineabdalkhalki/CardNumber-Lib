package com.ccValidation.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.amine.cardnumberlib.CardNumberEditText;

public class MainActivity extends AppCompatActivity {

    CardNumberEditText cardInput;
    AppCompatButton btnValidate;
    String cardType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the button
        btnValidate = (AppCompatButton)findViewById(R.id.btnValidate);
        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Invalid card number";

                if (cardInput.isValid())
                    msg = "Valid "+cardInput.getCardType()+" card number";

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        //init the card number input edittext
        cardInput = (CardNumberEditText) findViewById(R.id.cardInput);
        cardInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!cardInput.getCardType().equals("") && !cardType.equals(cardInput.getCardType())) {
                    cardType = cardInput.getCardType();
                    Toast.makeText(MainActivity.this, cardInput.getCardType(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

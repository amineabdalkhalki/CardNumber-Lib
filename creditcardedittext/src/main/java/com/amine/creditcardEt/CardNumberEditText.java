package com.amine.creditcardEt;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by amine on 1/24/16.
 */
public class CardNumberEditText extends EditText {

    char space = ' ';
    String cardNumber;
    int keyDel;

    private Context mContext;
    public View viewSpinner;

    public CardNumberEditText(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CardNumberEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public CardNumberEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        init();
    }

    private void init() {
        this.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String sCardNumber = getText().toString().replace(" ", "");

                if (sCardNumber.length() > 12) {
                    String cardName = CCUtils.getNameByCardNumber(sCardNumber);
                    Toast.makeText(mContext, cardName, Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // Remove all spacing char
                int pos = 0;
                while (true) {
                    if (pos >= s.length()) break;
                    if (space == s.charAt(pos) && (((pos + 1) % 5) != 0 || pos + 1 == s.length())) {
                        s.delete(pos, pos + 1);
                    } else {
                        pos++;
                    }
                }

                // Insert char where needed.
                pos = 4;
                while (true) {
                    if (pos >= s.length()) break;
                    final char c = s.charAt(pos);
                    // Only if its a digit where there should be a space we insert a space
                    if ("0123456789".indexOf(c) >= 0) {
                        s.insert(pos, "" + space);
                    }
                    pos += 5;
                }


            }
        });
    }
}

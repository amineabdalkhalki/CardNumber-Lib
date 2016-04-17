package com.amine.creditcardEt;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by amine on 1/24/16.
 */
public class CardNumberEditText extends EditText {

    String space = " ";

    String cardType="";

    int maxDigits = 18;

    private Context mContext;

    private boolean isValidationEnabled;
    private String Separator;

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
        //set the default separator
        setSeparator(space);
        setEditTextMaxLength(this, maxDigits + 1);
        this.setInputType(InputType.TYPE_CLASS_PHONE);

        this.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String sCardNumber = getText().toString().replace(getSeparator(), "");

                //maxdigits minus the separtor replaced above
                if (sCardNumber.length() > maxDigits - 3) {
                    setCardType(CCUtils.getNameByCardNumber(sCardNumber));
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
                    if (space.toCharArray()[0] == s.charAt(pos) && (((pos + 1) % 5) != 0 || pos + 1 == s.length())) {
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
                        s.insert(pos, space);
                    }
                    pos += 5;
                }


            }
        });
    }

    public String getSeparator() {
        return Separator;
    }

    public void setSeparator(String separator) {
        Separator = separator;
    }

    public boolean isValidationEnabled() {
        return isValidationEnabled;
    }

    public void setIsValidationEnabled(boolean isValidationEnabled) {
        this.isValidationEnabled = isValidationEnabled;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getMaxDigits() {
        return maxDigits;
    }

    private void setEditTextMaxLength(final EditText editText, int length) {
        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(length);
        editText.setFilters(FilterArray);
    }
}

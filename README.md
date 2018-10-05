# CardNumber-Lib
Android EditText based view, that can validate a given card number and can detect the type of the card number AMEX/MasterCard/Visa..

The library is still in early stages, stable yet the code is a mess and the documentation inexistant, however the future updates will handle all this.

Thank you.

#How to Import?

Add this to your build.gradle:
```
repositories {
  jcenter() 
} 
```
and this to your dependencies:
```
compile 'com.amine.cardnumberlib:cardnumber-lib:0.7'
```

#Working Example

add the view as you would add a normal Edittext:

```
    <com.amine.cardnumberlib.CardNumberEditText
        android:id="@+id/cardInput"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/hint"/>
```

on the activity you need to find view and implement addTextChangedListener(TextWatcher tw) :
```
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
          
          //
          // add here the magic of android i.e: launch rockets and stuffs!!
          //
          
          }
        }
      });
```

the afterTextChanged() method  can be a good place to add some animation when you get the card type to give 
the user a better idea on what card type, a demo will be coming very soon!

#What's Coming
- Adding more cards types i.e: Discover
- using apache commmons routines instead of the CCUtils.java
- better code
- better UI/UX implmentation (i have an idea)

#Copyright and Stuff

the java that provides the types and validation has been found on the following link:

- http://www.rgagnon.com/javadetails/java-0034.html

If you are the owner of this code please contact me in order to thank you and to give the credits you deserve.

```
Copyright 2016 Amine ABDALKHALKI

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

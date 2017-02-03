package com.example.praveen.drawerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUp extends AppCompatActivity {

    EditText password;
    ImageView passImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        passImage=(ImageView)findViewById(R.id.fragment_login_password_visibility) ;
        password=(EditText)findViewById(R.id.password);

        passImage.setOnTouchListener(mPasswordVisibleTouchListener);

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                passImage.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }
        });
    }

    public void LoginDetails(View view) {
        Intent loginIntent=new Intent(getApplicationContext(),SignIn.class);
        startActivity(loginIntent);
    }

    public void LaunchHome(View view) {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

    private View.OnTouchListener mPasswordVisibleTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final boolean isOutsideView = event.getX() < 0 ||
                    event.getX() > v.getWidth() ||
                    event.getY() < 0 ||
                    event.getY() > v.getHeight();

            // change input type will reset cursor position, so we want to save it
            final int cursor = password.getSelectionStart();

            if (isOutsideView || MotionEvent.ACTION_UP == event.getAction())
                password.setInputType( InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PASSWORD);
            else
                password.setInputType( InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

            password.setSelection(cursor);
            return true;
        }
    };

}

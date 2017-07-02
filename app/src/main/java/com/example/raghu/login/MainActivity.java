package com.example.raghu.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText name;
    EditText password;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        b=(Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String mnamed=name.getText().toString();
                String mpassword=password.getText().toString();
                String type="Login";


                CheckLogin cl=new CheckLogin(MainActivity.this);

                cl.execute(type,mnamed,mpassword);

            }
        });

    }
}

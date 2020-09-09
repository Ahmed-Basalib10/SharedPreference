package com.e.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText d1 ,d2;
    TextView textView;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d1 =(EditText) findViewById(R.id.editTextTextEmailAddress4);
        d2 =(EditText)findViewById(R.id.editTextTextPassword);
        button =(Button)findViewById(R.id.button);
        checkBox =(CheckBox) findViewById(R.id.checkBox);
        sharedPreferences = getSharedPreferences("abc",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        // or
       // sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkSharedPreference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    editor.putString("checkbox","True");
                    editor.commit();

                    editor.putString("email",d1.getText().toString());
                    editor.commit();

                    editor.putString("password",d2.getText().toString());
                    editor.commit();
                }else{
                    editor.putString("checkbox","False");
                    editor.commit();

                    editor.putString("email","");
                    editor.commit();

                    editor.putString("password","");
                    editor.commit();
                }
            }
        });
    }
    private void checkSharedPreference(){
        String checkboxp = sharedPreferences.getString("checkbox","False");
        String gmail = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");
        d1.setText(gmail);
        d2.setText(password);
        if(checkboxp.equals("True")){
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }
    }
}
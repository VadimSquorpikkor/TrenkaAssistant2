package com.squorpikkor.android.app.trenkaassistant2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText edit;
    Button button1;
    Button button2;
    SomeClass sClass;
    SaveLoad saveLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        edit = (EditText) findViewById(R.id.edit);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        sClass = new SomeClass(this);
        saveLoad = new SaveLoad(this);

        SaveableArrayList<SomeClass_3> savList = new SaveableArrayList<>();
        savList.add(new SomeClass_3("First", 77, 2.7));
        savList.add(new SomeClass_3("Second", 88, 2.8));



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        sClass.param1 = edit.getText().toString();
                        sClass.saveParam();
                        break;
                    case R.id.button2:
                        sClass.loadParam();
                        text.setText(sClass.param1);
                        saveLoad.saveParamList(sClass);
                        saveLoad.saveObjList(sClass);
                        break;
                }
            }
        };

        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
    }
}

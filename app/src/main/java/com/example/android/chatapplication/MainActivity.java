package com.example.android.chatapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText edit_text;
    ListView list;
    ArrayList<String> addArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.chat_list_view);
        edit_text = (EditText)findViewById(R.id.edit_text);
        send = (Button) findViewById(R.id.send_button);
        send.setOnClickListener(new View.OnClickListener(){

            public void onClick(View V){
                String getInput = edit_text.getText().toString();

                if (getInput == null || getInput.trim().equals("")){

                    Toast.makeText(getBaseContext(), "Text field is empty", Toast.LENGTH_LONG).show();
                }
                else{

                    addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addArray );
                    list.setAdapter(adapter);
                    edit_text.setText("");

                }

            }
        });

    }

}




package com.moringaschool.asuper.items;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.asuper.R;

import java.util.ArrayList;
import java.util.Arrays;

public class RecievedActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText txtInput;
    public void onCreate(Bundle saveInstanceState) {
            super.onCreate(saveInstanceState);
            setContentView(R.layout.activity_recieved);
            ListView listView=(ListView)findViewById(R.id.listv);
            String items=("Apple, Banana, Grapes");
            arrayList=new ArrayList<>(Arrays.asList(items));
            adapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem,arrayList);
            listView.setAdapter(adapter);
            txtInput=(EditText) findViewById(R.id.txtinput);
            Button btAdd=(Button)findViewById(R.id.btadd);
            btAdd.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    String newItem=txtInput.getText().toString();
                    arrayList.add(newItem);
                    adapter.notifyDataSetChanged();
                }
            });
    }
}

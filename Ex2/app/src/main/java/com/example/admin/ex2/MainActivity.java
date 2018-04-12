package com.example.admin.ex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final double[] UnitConvert = new double[1];
        final TextView txt2,txt3;
        Button btn = (Button)findViewById(R.id.btn);
        final EditText editTxt1,editTxt2;
        editTxt1 =(EditText)findViewById(R.id.txtEdit2);
        editTxt2 =(EditText)findViewById(R.id.txtEdit3);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Choose_Arr,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItemTxt=(String) adapterView.getItemAtPosition(i);
                if(selectedItemTxt.equals("USD-VND")) {
                    txt2.setText("USD");
                    txt3.setText("VND");
                    UnitConvert[0] = 22795;
                    editTxt2.setText("");
                }
                else
                if(selectedItemTxt.equals("USD-EUR")) {
                    txt2.setText("USD");
                    txt3.setText("EUR");
                    UnitConvert[0] = 1.2369;
                    editTxt2.setText("");
                }
                else
                if(selectedItemTxt.equals("VND-USD")) {
                    txt2.setText("VND");
                    txt3.setText("USD");
                    UnitConvert[0] = (double)  1/22795;
                    editTxt2.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              double money;
                money = Double.parseDouble(editTxt1.getText().toString());
                editTxt2.setText(String.valueOf(Math.ceil(money*UnitConvert[0])));
            }
        });

    }

}

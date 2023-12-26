package com.example.healthhive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1: Full body checkup", "999" , "","",""},
            {"Package 1: Blood glucose fasting" ,"299","" ,"",""},
            {"Package 1: Thyroid testing" ,"399","" ,"",""},
            {"Package 1: Immunity Checkup","599","" ,"","" },
            {"Package 1: BP checkup","259" ,"" ,"","" }
    };

    private String[] package_details = { "Blood glucose testing\n" + "Complete haemogram\n" + "Iron Studies\n" , "Blood glucose fasting" , "Thyroid level" , "Covid 19 Chekckup" , "BP"};

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnLTGoToCart, btnLTBack;
    ListView LIstViewLT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnLTGoToCart = findViewById(R.id.btnLDGoToCart);
        btnLTBack = findViewById(R.id.BtnLTBack);
        LIstViewLT = findViewById(R.id.ListViewLT);

        btnLTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0 ; i< packages.length ; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", "Total Cost:" + packages[i][1] + "/-");
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this,list, R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"} ,
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        LIstViewLT.setAdapter(sa);


        LIstViewLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i,long l){
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages[i][1]);
                it.putExtra("text3", package_details[i]);
                startActivity(it);
            }
        });

        btnLTGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });

    }
}
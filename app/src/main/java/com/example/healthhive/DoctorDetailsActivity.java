package com.example.healthhive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    TextView tv;
    Button btn;

    private String[][] doct_details1 = {
            {"Doctor Name: Achal Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Achal Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "900"},
            {"Doctor Name: Achal Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Achal Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Achal Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Achal Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
    };

    private String[][] doct_details2 = {
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "900"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
    };

    private String[][] doct_details3 = {
            {"Doctor Name: Sharayu Tichkule", "Hospital Address : Gondia" , "Experience : 15yrs" , "Mobile No: 9869485967" , "1000"},
            {"Doctor Name: Sharayu Tichkule", "Hospital Address : Bramhapuri" , "Experience : 15yrs" , "Mobile No: 9869485967" , "800"},
            {"Doctor Name: Sharayu Tichkule", "Hospital Address : Nagpur" , "Experience : 15yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Sharayu Tichkule", "Hospital Address : Chandrapur" , "Experience : 15yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Sharayu Tichkule", "Hospital Address : Balaghat" , "Experience : 15yrs" , "Mobile No: 9869485967" , "600"},

    };

    private String[][] doct_details4 = {
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "900"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
    };

    private String[][] doct_details5 = {
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "900"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
            {"Doctor Name: Vijaya Adamane", "Hospital Address : Nagpur" , "Experience : 10yrs" , "Mobile No: 9869485967" , "600"},
    };

    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);


        tv = findViewById(R.id.textviewDDTitle);
        btn = findViewById(R.id.ButtonDDBack);


        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        if(title.compareTo("FAMILY PHYSICIAN") == 0)
            doctor_details = doct_details1;
        else if(title.compareTo("DIETITIAN") == 0)
            doctor_details = doct_details2;
        else if(title.compareTo("DENTIST") == 0)
            doctor_details = doct_details3;
        else if(title.compareTo("SURGEON") == 0)
            doctor_details = doct_details4;
        else
            doctor_details = doct_details5;




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctor.class));
            }
        });

        list = new ArrayList();
        for(int i=0 ; i<doctor_details.length ; i++){
            item = new HashMap<String, String>();
            item.put("line1" , doctor_details[i][0]);
            item.put("line2" , doctor_details[i][1]);
            item.put("line3" , doctor_details[i][2]);
            item.put("line4" , doctor_details[i][3]);
            item.put("line5" , "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list, R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"} ,
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst =findViewById(R.id.LIstViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i,long l){
                    Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                    it.putExtra("text1", title);
                    it.putExtra("text2", doctor_details[i][0]);
                    it.putExtra("text3", doctor_details[i][1]);
                    it.putExtra("text4", doctor_details[i][3]);
                    it.putExtra("text5", doctor_details[i][4]);
                    startActivity(it);
                }
        });
    }

}
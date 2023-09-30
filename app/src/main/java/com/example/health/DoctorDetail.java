package com.example.health;

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


public class DoctorDetail extends AppCompatActivity {
    Button btn;
    TextView tv;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        tv=findViewById(R.id.DDtitle);
        Intent it= getIntent();
        String s=it.getStringExtra("title");
        tv.setText(s);



        String[][] ct1= {{"Name : Gaurav Pandey","address : Nirala Nagar","Experience : 2 years","Mobile : 9919111798","Fees : 600"},
                {"Name : Sarvesh Sir","address : Jeera Basti","Experience : 17 years","Mobile : 8960871234","Fees : 1200"},
                {"Name : Gauri pandey","address : New Chwok","Experience : 5 years","Mobile : 7518754106","Fees : 1000"},
                {"Name : Ankit Yadav","address : Jeera Basti","Experience : 3 Years","Mobile : 7355773390","Fees : 700"},
                {"Name : Maya pandey","address : Nirala nagar","Experience : 30 Years","Mobile : 9792314331","Fees : 5000"}};

        String[][] ct2= {{"Name : Ravi Sashtri","address : Parmanda Pur","Experience : 4 years","Mobile : 9916342798","Fees : 550"},
                {"Name : Abdul","address : Banbihar","Experience : 1 Years","Mobile : 9748143317","Fees : 50"},
                {"Name : Pradeep Mishra","address : Pahadipur","Experience : 5 years","Mobile : 7673854106","Fees : 900"},
                {"Name : Priyanshu Yadav","address : Jeera Basti","Experience : 7 Years","Mobile : 7358574690","Fees : 2500"},
                {"Name : Abhishek","address : Kanpur","Experience : 18 years","Mobile : 7847587264","Fees : 1500"}};

        String[][] ct3= {{"Name : Ravi Srivastav","address : Naya chowk japlinganj ballia","experience : 5 years","Mobile : 9499192340","Fees : 6000"},
                {"Name : Sumedh singh","address : Noida delhi","experience : 3 Years","Mobile : 6306869120","Fees : 1500"},
                {"Name : Gauransh Pandey","address : Nirala  nagar","experience : 2 years","Mobile : 7518754610","Fees : 1200"},
                {"Name : Nitya pandey","address : Nirala nagar","experience : 4 Years","Mobile : 9919111989","Fees : 5000"},
                {"Name : Ritesh singh","address : Phepna buxar","experience : 2 years","Mobile : 7630677264","Fees : 1200"}};

        String[][] ct4= {{"Name : Ginni Shukla","address : Sector 27,delhi","experience : 6years","Mobile : 9234998716","Fees : 600"},
                {"Name : Mahima yadav","address : kadam chauraha ballia","experience : 07 Years","Mobile : 9888001234","Fees : 700"},
                {"Name : Gaurvi patel","address : Gandhinagar gujarat","experience : 15 years","Mobile : 7516668902","Fees : 1000"},
                {"Name : Ankita Yaduvansi","address : Sheeshmahal road, Ballia","experience : 13 Years","Mobile : 7389890202","Fees : 700"},
                {"Name : Rajini gupta","address : Patna bihar","experience : 7 years","Mobile : 7628289760","Fees : 1200"}};

        String[][] ct5= {{"Name : Sumit Kumar","address : lahatara varansi","experience : 3 years","Mobile : 8126268927","Fees : 1600"},
                {"Name :Viddhi updhay","address : lanka, varansi ","experience : 6 Years","Mobile : 9789265689","Fees : 3000"},
                {"Name : Shreya singh","address :  mahauli lucknow","experience : 5 years","Mobile : 8812688122","Fees : 2000"},
                {"Name : Aashi chauhan","address : pink City udaipur","experience : 4Years","Mobile : 7518609010","Fees : 1700"},
                {"Name : Ravi singh","address :td college chauraha ballia","experience : 2 years","Mobile : 9919220080","Fees : 1200"}};

//        MYhandler db = new MYhandler(getApplicationContext());
//        ct=db.getalldata();


        String[][] ct;

        if (s.compareTo("Physician")==0){
            ct=ct1;
        }
        else if(s.compareTo("Dietician")==0){
            ct=ct2;
        }
        else if(s.compareTo("Dentist")==0){
            ct=ct3;
        }
        else if(s.compareTo("Surgeon")==0){
            ct=ct4;
        }
        else {
            ct=ct5;
        }


        list=new ArrayList();
        for (String[] c : ct){
            h= new HashMap<>();
            h.put("line1",c[0]);
            h.put("line2",c[1]);
            h.put("line3",c[2]);
            h.put("line4",c[3]);
            h.put("line5",c[4]);
            list.add(h);
        }

        sa = new SimpleAdapter(this,list,R.layout.custom_lay,
                new String[]{"line1","line2","line3","line4","line5",},
                new int[]{R.id.line1,R.id.line2,R.id.line3,R.id.line4,R.id.line5});

        ListView lv= findViewById(R.id.listDD);
        lv.setAdapter(sa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent m = new Intent(getApplicationContext(),BookAppointmentActivity.class);
                m.putExtra("docname",ct[i][0]);
                m.putExtra("docadress",ct[i][1]);
                m.putExtra("docnmbr",ct[i][3]);
                m.putExtra("docfees",ct[i][4]);
                startActivity(m);

            }
        });

        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
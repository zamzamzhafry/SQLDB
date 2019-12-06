package com.lks.sqldb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn_Get;
    ListView LV_Data;
    SimpleAdapter AD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LV_Data=findViewById(R.id.lv_data);
        btn_Get=findViewById(R.id.btnGet);

        btn_Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Map<String, String>> MyDataList=null;
                GetData myData=new GetData();
                MyDataList=myData.getdata();


                String[] fromwhere ={"ID","name","email","password","hp"};
                int[] viewwhere ={R.id.ID,R.id.name,R.id.email,R.id.password,R.id.hp};


                AD = new SimpleAdapter(MainActivity.this,MyDataList,R.layout.listtemplate,fromwhere,viewwhere);
                LV_Data.setAdapter(AD);

            }
        });
    }
}

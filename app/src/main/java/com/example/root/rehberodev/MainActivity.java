package com.example.root.rehberodev;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Intent i;
    Button ekle,sil;
    ListView lv;
    Veritabani vt;
    int[] id;
    int pozisyon=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i=new Intent(this,ekle.class);
        ekle=findViewById(R.id.bekle);
        sil=findViewById(R.id.bsil);
        lv=findViewById(R.id.listview);
        lv.setClickable(true);
        vt=new Veritabani(this);
        doldur();

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sil();
                doldur();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pozisyon=position;
            }
        });

    }

    protected void doldur()
    {

        Cursor cursor=vt.getir();
        cursor.moveToFirst();

        String[] isimno= new String[cursor.getCount()];
        id=new int[cursor.getCount()];

        for(int i=0;i<cursor.getCount();i++)
        {
            id[i]=cursor.getInt(0);
            isimno[i]=cursor.getString(1);
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,isimno);
        lv.setAdapter(adapter);
    }

    protected void sil()
    {
        if(id.length>0&&pozisyon>-1)
        {
            vt.sil(id[pozisyon]+"");
            doldur();
            Toast.makeText(getApplicationContext(),"Başarıyla silindi!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Silinecek kayıt seçmediniz!",Toast.LENGTH_SHORT).show();
        }
    }

    protected void onResume()
    {
        super.onResume();
        doldur();
    }

    protected void onPause()
    {
        super.onPause();
        doldur();
    }

}

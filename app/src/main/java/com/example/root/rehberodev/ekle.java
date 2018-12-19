package com.example.root.rehberodev;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ekle extends AppCompatActivity {

    Button ekle;
    EditText isim,numara;
    Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        ekle=findViewById(R.id.bkaydet);
        isim=findViewById(R.id.eisim);
        numara=findViewById(R.id.enumara);
        vt=new Veritabani(this);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isim.getText().length()>0&&numara.getText().length()>0)
                {
                    vt.ekle(isim.getText().toString()+" - "+numara.getText().toString());
                    Toast.makeText(getApplicationContext(),"Kaydetme başarılı!",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {Toast.makeText(getApplicationContext(),"Alanlar boş bırakılamaz!",Toast.LENGTH_SHORT).show();}
            }
        });
    }


}

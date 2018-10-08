package com.example.erhan.kentsimgeleri;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Bitmap selectedImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);
        final ArrayList<String>Kentİsimleri=new ArrayList<>();
        Kentİsimleri.add("İstanbul Boğazı");
        Kentİsimleri.add("Colleseum");
        Kentİsimleri.add("Pisa");
        Bitmap bogaz= BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.bogaz);
        Bitmap coloesum= BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.coloesum);
        Bitmap pisa= BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.pisa);

        final ArrayList<Bitmap>Resimler=new ArrayList<>();
        Resimler.add(bogaz);
        Resimler.add(coloesum);
        Resimler.add(pisa);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Kentİsimleri);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("İsimler", Kentİsimleri.get(i));

                selectedImage = Resimler.get(i);

                startActivity(intent);
            }
        });


    }
}

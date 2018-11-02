package com.itpvt.fl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ItemRemoved extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_removed);



    Button btn=(Button) findViewById(R.id.main);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent i= new Intent(ItemRemoved.this, MainActivity.class);
            startActivity(i);


        }
    });
    }
}

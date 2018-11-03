package com.itpvt.fl;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Nothing extends AppCompatActivity {
Button btn;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nothing);

Toolbar tool=(Toolbar)findViewById(R.id.toolbar);


tool.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onBackPressed();
    }
});
        btn=(Button)findViewById(R.id.not);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(Nothing.this, MainActivity.class);
                startActivity(i);


            }
        });


        ImageView imm=(ImageView)findViewById(R.id.bag);
        imm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Nothing.this,My_Cart.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Nothing.this,MainActivity.class);
        startActivity(intent);
    }
}

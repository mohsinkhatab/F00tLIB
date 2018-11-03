package com.itpvt.fl;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


public class Formal extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all__products__design);
        setContentView(R.layout.activity_formal);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ImageView bbb=(ImageView)findViewById(R.id.bag);
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Formal.this,My_Cart.class);
                startActivity(intent);
            }
        });
        ImageView men=(ImageView)findViewById(R.id.formalmen);
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Formal.this,Sub_Categories.class);
                intent.putExtra("id", "12");
                intent.putExtra("title", "Hello");
                startActivity(intent);
            }
        });

        ImageView women=(ImageView)findViewById(R.id.formalwomen);
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Formal.this,Sub_Categories.class);
                intent.putExtra("id", "13");
                intent.putExtra("title", "Hello");
                startActivity(intent);
            }
        });

        FloatingActionButton whatsapp = (FloatingActionButton) findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                String smsNumber = "923113668542";

                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net");//phone number without "+" prefix
                startActivity(sendIntent);
            }
        });


        FloatingActionButton facebook=(FloatingActionButton) findViewById(R.id.fb);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/footlib/"));
                startActivity(myIntent);
            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Formal.this,MainActivity.class);
        startActivity(intent);
    }
}

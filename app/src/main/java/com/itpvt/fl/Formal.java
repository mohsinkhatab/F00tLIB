package com.itpvt.fl;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

public class Formal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal);
//        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);

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
                String smsNumber = "+923113668542";

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

}

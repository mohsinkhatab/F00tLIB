package com.itpvt.fl;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

public class Casual extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casual);

       // Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        ImageView mnmn=(ImageView)findViewById(R.id.bag);
        mnmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Casual.this,My_Cart.class);
                startActivity(intent);
            }
        });

        ImageView men=(ImageView)findViewById(R.id.casualmen);
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent(Casual.this,Sub_Categories.class);
                intent.putExtra("id", "10");
                intent.putExtra("title", "Hello");
                startActivity(intent);
            }
        });

    ImageView women=(ImageView)findViewById(R.id.casualwomen);
    women.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Casual.this,Sub_Categories.class);
            intent.putExtra("id", "11");
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

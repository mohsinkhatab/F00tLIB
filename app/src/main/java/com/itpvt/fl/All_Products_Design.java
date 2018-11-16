package com.itpvt.fl;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class All_Products_Design extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    ArrayList<Products_pojo> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    Recycler_Adapter_All_Products_new adapter;
    RecyclerView.LayoutManager layoutManager;
    private ProgressDialog loading;
    String id, Title, p_id, p_type, p_quantity;

    SliderLayout sliderLayout;
    HashMap<String, Integer> HashMapForURL;
    int[] images = {R.drawable.baner, R.drawable.banneer, R.drawable.bannerr};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all__products__design);


        sliderLayout = (SliderLayout) findViewById(R.id.slider);
//Adapter adapter= new Adapter(this);
//viewpg.setAdapter(adapter);
        //Remove notification bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_all__products__design);
//        TextView textView = (TextView) findViewById(R.id.textView4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(All_Products_Design.this, MainActivity.class);
                startActivity(intent);
            }
        });


        FloatingActionButton facebook = (FloatingActionButton) findViewById(R.id.fb);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = openFacebook(All_Products_Design.this);
                startActivity(facebookIntent);
            }
        });


//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://madame.pk/"));
//                startActivity(myIntent);
//            }
//        });
//


//        ImageView title=(ImageView)findViewById(R.id.title);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//       Button facebook=(Button)findViewById(R.id.facebook);
//       Button instagram=(Button)findViewById(R.id.insta);

//        TextView textView=(TextView)findViewById(R.id.textView4) ;
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://noorjahan.pk/index.php/"));
//                startActivity(myIntent);
//            }
//        });
//       LinearLayout footer=(LinearLayout)findViewById(R.id.footer);
//        footer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://itpvt.net/"));
//                startActivity(myIntent);
//            }
//        });
//        facebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/footlib/"));
//                startActivity(myIntent);
//            }
//        });
//        instagram.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/noorjahancollection/"));
//                startActivity(myIntent);
//            }
//        });


        FloatingActionButton whatsapp = (FloatingActionButton) findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String smsNumber = "923113668542";

                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net");//phone number without "+" prefix
                startActivity(sendIntent);
            }
        });
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(All_Products_Design.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        recyclerView = (RecyclerView) findViewById(R.id.model_recyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
//        ImageView whatsapp=(ImageView) findViewById(R.id.whatsapp);
//        whatsapp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uri  = Uri.parse("smsto:"+"+923000225587");
//                Intent intent =new Intent(Intent.ACTION_SENDTO,uri);
//                intent.setPackage("com.whatsapp");
//                startActivity(intent);
//            }
//        });


        ImageView bag = (ImageView) findViewById(R.id.bag);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(All_Products_Design.this, My_Cart.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        id = intent.getStringExtra("id");


//           Glide.with(All_Products_Design.this).load(Title).into(title);

        GetAllProducts();
        AddImagesUrlOnline();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    private void AddImagesUrlOnline()

    {

        HashMapForURL = new HashMap<String, Integer>();

        HashMapForURL.put(" ", R.drawable.baner);
        HashMapForURL.put("  ", R.drawable.banneer);
        HashMapForURL.put("   ", R.drawable.bannerr);

        callSlider();

    }

    private void callSlider() {

        for (String name : HashMapForURL.keySet()) {

            TextSliderView textSliderView = new TextSliderView(All_Products_Design.this.getApplicationContext());

            textSliderView
                    .description(name)
                    .image(HashMapForURL.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(8000);
    }


    private void GetAllProducts() {
        loading = ProgressDialog.show(All_Products_Design.this, "Loading...", "Please wait...", false, false);
        StringRequest request = new StringRequest(Request.Method.POST,
                Config.URL_ALL_PRODUCTS, new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    loading.dismiss();

                    JSONObject abc = new JSONObject(response);
                    int j = abc.length();
                    for (int i = j; i >= 1; i--) {
                        String num = String.valueOf(i);
                        JSONObject data = abc.getJSONObject(num);
                        if (!data.getString("type_id").equals("simple")) {
                            arrayList.add(new Products_pojo(data.getString("product_id"), data.getString("pro_name")
                                    , data.getString("img_url").replace("localhost", Config.ip), data.getString("sku")
                                    , data.getString("product_quantity"), data.getString("price").replace(".0000", "Rs")));
                        }

                    }

                    adapter = new Recycler_Adapter_All_Products_new(arrayList, All_Products_Design.this);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();


                    loading.dismiss();

                    Intent i = new Intent(All_Products_Design.this, none.class);
                    startActivity(i);
                    Toast.makeText(All_Products_Design.this, "Nothing is Available For Time Being", Toast.LENGTH_LONG).show();
                    finish();

                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                //  Log.e("Error",error.printStackTrace());
                Toast.makeText(All_Products_Design.this.getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                onBackPressed();

            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("category_id", id);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(All_Products_Design.this.getApplicationContext());
        requestQueue.add(request);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(All_Products_Design.this, MainActivity.class);
        startActivity(intent);
    }


    public static Intent openFacebook(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/1192767844126708?referrer=app_link"));
        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/footlib/"));
        }
//
//public void onResponse(String response){
//
//        try {
//            JSONObject object = new JSONObject(response);
//            p_type = object.getString("type_id");
//            String p_quantity = object.getString("product_quantity");
//            if (p_type.equals("simple") && !p_quantity.equals("0")){
//
//
//
//            }
//        }
//
//
    }
}



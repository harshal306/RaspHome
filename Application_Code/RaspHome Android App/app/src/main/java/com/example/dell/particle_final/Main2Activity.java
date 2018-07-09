package com.example.dell.particle_final;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import io.particle.android.sdk.cloud.ParticleCloud;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.cloud.ParticleEventVisibility;
import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;
import io.particle.android.sdk.utils.Async;
import io.particle.android.sdk.utils.Toaster;

public class Main2Activity extends AppCompatActivity {
    private TextView txvResult;

    String email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txvResult = (TextView) findViewById(R.id.txvResult);




    }
    public void getSpeechInput(View view) {



        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent i=getIntent();
        String email=i.getStringExtra("Email");
        String pass=i.getStringExtra("Pass");
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    if(txvResult.getText().toString().equals("lights on") || txvResult.getText().toString().equals("LIGHTS ON"))
                    {
                        @SuppressLint("StaticFieldLeak")
                        AsyncTask task = new AsyncTask() {
                            @Override
                            protected Object doInBackground(Object[] params) {
                                try {
                                    ParticleCloudSDK.getCloud().logIn(email, pass);

                                } catch (final ParticleCloudException e) {
                                    Runnable mainThread = () -> {
                                        Toaster.l(Main2Activity.this, e.getBestMessage());
                                        e.printStackTrace();
                                        Log.d("info", e.getBestMessage());
//                                            Log.d("info", e.getCause().toString());
                                    };
                                    runOnUiThread(mainThread);

                                }

                                return null;
                            }

                        };
                        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {

                            private ParticleDevice mDevice;

                            @Override
                            public Object callApi(@NonNull ParticleCloud harscloud) throws ParticleCloudException, IOException {
                                harscloud.logIn(email, pass);
                                harscloud.getDevices();
                                ParticleCloudSDK.getCloud().setAccessToken("ac82f902d546a19b044e8c7b32c46e73d0a2fea3");
                                mDevice = harscloud.getDevice("7ab711eb09279cbea70d7936");
                                Object obj;
                                ParticleCloudSDK.getCloud().publishEvent("Light_On", "",
                                        ParticleEventVisibility.PUBLIC, 60);
                                Toaster.l(Main2Activity.this, "success");

                                return -1;

                            }

                            @Override
                            public void onSuccess(@NonNull Object value) {
                                Toaster.l(Main2Activity.this, "Lights are On");

                            }

                            @Override
                            public void onFailure(@NonNull ParticleCloudException e) {
                                Toaster.l(Main2Activity.this, e.getBestMessage());
                                e.printStackTrace();
                                Log.d("info", e.getBestMessage());
                            }
                        });
                    }
                    else
                        if(txvResult.getText().toString().equals("lights off") || txvResult.getText().toString().equals("LIGHTS OFF"))
                    {
                        @SuppressLint("StaticFieldLeak")
                        AsyncTask task = new AsyncTask() {
                            @Override
                            protected Object doInBackground(Object[] params) {
                                try {
                                    ParticleCloudSDK.getCloud().logIn(email, pass);

                                } catch (final ParticleCloudException e) {
                                    Runnable mainThread = () -> {
                                        Toaster.l(Main2Activity.this, e.getBestMessage());
                                        e.printStackTrace();
                                        Log.d("info", e.getBestMessage());
//                                            Log.d("info", e.getCause().toString());
                                    };
                                    runOnUiThread(mainThread);

                                }

                                return null;
                            }

                        };
                        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {

                            private ParticleDevice mDevice;

                            @Override
                            public Object callApi(@NonNull ParticleCloud harscloud) throws ParticleCloudException, IOException {
                                harscloud.logIn(email, pass);
                                harscloud.getDevices();
                                ParticleCloudSDK.getCloud().setAccessToken("ac82f902d546a19b044e8c7b32c46e73d0a2fea3");
                                mDevice = harscloud.getDevice("7ab711eb09279cbea70d7936");
                                Object obj;
                                ParticleCloudSDK.getCloud().publishEvent("Light_Off", "",
                                        ParticleEventVisibility.PUBLIC, 60);
                                Toaster.l(Main2Activity.this, "success");

                                return -1;

                            }

                            @Override
                            public void onSuccess(@NonNull Object value) {
                                Toaster.l(Main2Activity.this, "Lights are Off");

                            }

                            @Override
                            public void onFailure(@NonNull ParticleCloudException e) {
                                Toaster.l(Main2Activity.this, e.getBestMessage());
                                e.printStackTrace();
                                Log.d("info", e.getBestMessage());
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(this,"Wrong Instruction",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

}

package com.example.dell.rasphome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import io.particle.android.sdk.cloud.ParticleCloud;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;
import io.particle.android.sdk.utils.Async;
import io.particle.android.sdk.utils.Toaster;

public class MainActivity extends AppCompatActivity {
Button login_button;
    Button on, off;



    int d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParticleCloudSDK.init(this);
        setContentView(R.layout.activity_main);


        Button login_button = (Button) findViewById(R.id.login_button);
        findViewById(R.id.login_button).setOnClickListener(
                v -> {
                    final String email = ((EditText) findViewById(R.id.email)).getText().toString();
                    final String password = ((EditText) findViewById(R.id.pass)).getText().toString();

                    // Don't:
                    @SuppressLint("StaticFieldLeak")
                    AsyncTask task = new AsyncTask() {
                        @Override
                        protected Object doInBackground(Object[] params) {
                            try {
                                ParticleCloudSDK.getCloud().logIn(email, password);

                            } catch (final ParticleCloudException e) {
                                Runnable mainThread = () -> {
                                    Toast.makeText(MainActivity.this,"Wrong Username or password",Toast.LENGTH_SHORT).show();
                                    Toaster.l(MainActivity.this, e.getBestMessage());
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
                        public Object callApi(@NonNull ParticleCloud sparkCloud) throws ParticleCloudException, IOException {
                            sparkCloud.logIn(email, password);
                            sparkCloud.getDevices();
                            mDevice = sparkCloud.getDevice("7ab711eb09279cbea70d7936");
                            Object obj;


                            return -1;

                        }

                        @Override
                        public void onSuccess(@NonNull Object value) {


                            Toaster.l(MainActivity.this, "Logged in");
                            Intent i=new Intent(MainActivity.this,Main2Activity.class);

                            i.putExtra("Email", email);
                            i.putExtra("Pass",password);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(@NonNull ParticleCloudException e) {
                            Toaster.l(MainActivity.this, e.getBestMessage());
                            e.printStackTrace();
                            Log.d("info", e.getBestMessage());
                        }
                    });
                }
        );
    }
}

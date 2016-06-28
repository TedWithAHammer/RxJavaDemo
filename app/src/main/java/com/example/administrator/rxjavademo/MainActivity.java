package com.example.administrator.rxjavademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Subscriber;

public class MainActivity extends BaseActivity {

    private Subscriber<String> subscriber;
    private TextView tvMessage;
    private Button btnActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnActivity2 = (Button) findViewById(R.id.btn_start_activity);
        tvMessage = (TextView) findViewById(R.id.message);
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        receiveMessage();
    }

    private void receiveMessage() {

        if (null != observable) {
            subscriber = new Subscriber<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String s) {
                    tvMessage.setText(s);
                }
            };
        }
    }
}

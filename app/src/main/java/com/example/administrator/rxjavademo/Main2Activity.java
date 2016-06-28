package com.example.administrator.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rx.Observable;
import rx.Subscriber;

public class Main2Activity extends BaseActivity {

    private EditText edtMessage;
    private Button btnSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtMessage = (EditText) findViewById(R.id.edt_message);
        btnSendMessage = (Button) findViewById(R.id.btn_send_message);
        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null == observable) {
                    observable = Observable.create(new Observable.OnSubscribe<String>() {

                        @Override
                        public void call(Subscriber<? super String> subscriber) {
                            subscriber.onNext(edtMessage.getText().toString());
                        }
                    });
                }
            }
        });
    }
}

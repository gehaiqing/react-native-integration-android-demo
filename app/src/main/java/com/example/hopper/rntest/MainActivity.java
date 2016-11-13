package com.example.hopper.rntest;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button jump =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jump = (Button) findViewById(R.id.button);
        jump.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyReactActivity.class);
                if (Build.VERSION.SDK_INT >= 23) {
                    if(!Settings.canDrawOverlays(MainActivity.this)) {
                        intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                        startActivity(intent);
                        return;
                    } else {
                        //绘ui代码, 这里说明6.0系统已经有权限了
                        startActivity(intent);
                    }
                } else {
                    //绘ui代码,这里android6.0以下的系统直接绘出即可
                    startActivity(intent);
                }
            }
        });
    }
}

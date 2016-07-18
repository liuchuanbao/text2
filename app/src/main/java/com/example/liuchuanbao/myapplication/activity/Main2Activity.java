package com.example.liuchuanbao.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.android.volley.VolleyError;
import com.example.liuchuanbao.myapplication.net.NetRequestUtil;
import com.example.liuchuanbao.myapplication.interfaces.VolleyInterface;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

//    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        tv = (TextView) findViewById(R.id.tv);
        geyProvinc();
    }

    public void geyProvinc() {
        new NetRequestUtil(Main2Activity.this, new VolleyInterface() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result.toString());
                    int code = jsonObject.getInt("code");
                    if (code == 200) {
                        Toast.makeText(this, "成功", 0).show();
                    } else if (code == -1) {
                        Toast.makeText(this, "成功 -1", 0).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(this, "成功 e", 0).show();
                }

            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(this, "失败", 0).show();
            }
        }).getProvince();

    }
}
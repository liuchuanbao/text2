package com.example.liuchuanbao.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.liuchuanbao.myapplication.R;
import com.example.liuchuanbao.myapplication.activity.Main2Activity;
import com.example.liuchuanbao.myapplication.net.NetRequestUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public static final int SHOW_RESPONSE = 0;

    private  Button send_request;
    private TextView  tvComent;

//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case SHOW_RESPONSE:
//                    String response = (String) msg.obj;
//                    Log.e("liu1= ",response);
//                    tvComent.setText(response);
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_request = (Button) findViewById(R.id.send_request);
        tvComent = (TextView) findViewById(R.id.tv_coment);
        send_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendRequestWithHttpURLConnection();
                Intent it = new Intent();
                it.setClass(this,Main2Activity.class);
                 startActivity(it);
            }
        });
    }


//    @OnClick(R.id.send_request)
//    public void onClick() {
//
//    }




//    private void sendRequestWithHttpURLConnection() {
//        //开启线程发起网络线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection = null;
//                try {
//                    URL url = new URL("http://www.baidu.com");
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    InputStream in = connection.getInputStream();
//                    //下面是对获取到的输入流进行读取
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//
//                    Message message = new Message();
//                    message.what = SHOW_RESPONSE;
//                    //将服务器返回的结果存放到message中
//                    message.obj = response.toString();
//                    Log.e("liu= ",response.toString());
//                    handler.sendMessage(message);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    if(connection != null ){
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//    }
}

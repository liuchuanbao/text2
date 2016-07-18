package com.example.liuchuanbao.myapplication.net;

import android.content.Context;
import com.example.liuchuanbao.myapplication.interfaces.VolleyInterface;
/**
 * Created by liuchuanbao on 2016/7/18.
 */
public class NetRequestUtil extends  NetWork{

    //构造函数，将接口对象话
    public NetRequestUtil(Context mContext, VolleyInterface vif) {
        this(mContext, vif, null);
    }

    public NetRequestUtil(Context mContext, VolleyInterface vif, String tag) {
        super(mContext, vif, tag);
    }
// 获取省
    public void getProvince() {
        requestGet(URLConstants.URL_RELEASE_SND + "/Api/Province/Province.ashx", "getprovince");
    }

}

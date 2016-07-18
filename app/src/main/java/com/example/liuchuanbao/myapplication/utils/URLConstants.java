package com.example.liuchuanbao.myapplication.utils;

/**
 * Created by liuchuanbao on 2016/7/18.
 */
public class URLConstants {
    //存放url网址

    public static final boolean Debug_online = false;

    public static final String URL_RELEASE_SND = false ? "http://192.168.0.121" : (Debug_online ? "http://139.129.108.200:6060" : "http://ldzpapi.x5x5.cn"); //服务器地址

    public static final String URL_MOBILE_NGJ_PIC = "http://ssnd.laodao.so/"; //图片服务器
    public static final String URL_ENDPOINT = "http://ssnd.laodao.so";

}

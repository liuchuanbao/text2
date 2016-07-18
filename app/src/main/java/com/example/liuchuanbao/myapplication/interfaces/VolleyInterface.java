package com.example.liuchuanbao.myapplication.interfaces;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by liuchuanbao on 2016/7/18.
 */
public  abstract class VolleyInterface {

    public Response.Listener<String> mListener;
    public Response.ErrorListener mErrorListtener;

    public VolleyInterface() {
    }

    public abstract void onSuccess(String result);

    public abstract void onError(VolleyError error);

    public Response.Listener<String> loadingListener() {
        mListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String result) {
                onSuccess(result);
            }
        };
        return mListener;
    }

    public Response.ErrorListener errorListener() {
        mErrorListtener = new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                onError(error);
            }
        };
        return mErrorListtener;
    }
}

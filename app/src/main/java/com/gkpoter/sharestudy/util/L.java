package com.gkpoter.sharestudy.util;

import android.util.Log;

/**
 * Created by "GKpoter" on 2017/5/17.
 */

public class L {
    private L(){}
    private final static boolean debug = true;
    public static void e(String TAG, String info){
        if(debug){
            Log.i(TAG,info);
        }
    }
}

package slingge.functionblock.application;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.orhanobut.logger.AndroidLogAdapter;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import slingge.functionblock.util.ImageLoaderUtil;

/**
 * Created by Slingge on 2017/1/6 0006.
 */

public class SApplication extends Application {
    //


    private static SApplication myApplication;

    public static SApplication getInstance() {
        // if语句下是不会走的，Application本身已单例
        if (myApplication == null) {
            synchronized (SApplication.class) {
                if (myApplication == null) {
                    myApplication = new SApplication();
                }
            }
        }
        return myApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        ImageLoaderUtil.configImageLoader(this);

        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    private OkHttpClient getClient() {
        Cache cache = new Cache(SApplication.getInstance().getCacheDir(), 1024 * 1024);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                //                .addInterceptor(new RequestLogInterceoptor())
                //                .addInterceptor(new ResponseLogInterceptor())
                //                .addInterceptor(new RequestLogInterceoptor())
                .build();
        return okHttpClient;
    }


}

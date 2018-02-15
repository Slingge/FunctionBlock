package slingge.functionblock.application;

import android.app.Application;

/**
 * Created by Slingge on 2017/1/6 0006.
 */

public class SApplication extends Application {

    private static SApplication myApplication;

    //

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
    }


}

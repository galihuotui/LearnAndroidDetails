package com.cky.learnandroiddetails;

import android.app.Activity;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

import com.cky.learnandroiddetails.ViewScreenShot.VIewScreenShotMainActivity;
import com.cky.learnandroiddetails.canvas.CanvasViewAct;
import com.cky.learnandroiddetails.customattrs.MyCustomViewAct;
import com.cky.learnandroiddetails.drawableSet.DrawableSetActivity;
import com.cky.learnandroiddetails.learnGcsSloopView.LearnGcsSloopViewMainActivity;
import com.cky.learnandroiddetails.recyclerViewDecoration.AddRecyclerViewDecorationAct;

/**
 * 作者：cky
 * 时间：2016/9/28 16:43
 * 描述：
 * https://segmentfault.com/u/chriszou/articles
 */

public class MyTest extends ActivityInstrumentationTestCase2<VIewScreenShotMainActivity> {

    private Activity mActivity;

    public MyTest() {
        super(VIewScreenShotMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();

    }

    //运行的函数即可测试
    public void testTextView() {
        /*
        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {

                    TextView textView = (TextView) mActivity.findViewById(R.id.text_view);
                    textView.setText("Hello World");

                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        */
        SystemClock.sleep(400000000);
    }
}

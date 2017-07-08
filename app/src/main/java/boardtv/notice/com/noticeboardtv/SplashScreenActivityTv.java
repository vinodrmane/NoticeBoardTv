package boardtv.notice.com.noticeboardtv;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by Vinod on 6/29/2017.
 */
public class SplashScreenActivityTv extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_layout_tv);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        final boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();

        }
        if (ranBefore==true){
            Log.v("SPLASH","true");
            startActivity(new Intent(SplashScreenActivityTv.this, SplashScreenActivityTv.class));
        }else{
            Log.v("SPLASH","false");
            Thread screenDisplayTimer = new Thread(){
                public void run(){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                    }finally{
                        startActivity(new Intent(SplashScreenActivityTv.this, SplashScreenActivityTv.class));

                    }
                    finish();
                }
            };
            screenDisplayTimer.start();
        }


    }
}
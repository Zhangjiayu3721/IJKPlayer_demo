package zjy.com.ijkplayer_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import zjy.com.ijkplayer_demo.common.PlayerManager;
import zjy.com.ijkplayer_demo.widget.media.IjkVideoView;

public class MainActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener{

    IjkVideoView vd;
    PlayerManager manager;
    private String url = "http://mp4.vjshi.com/2013-05-28/2013052815051372.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vd = findViewById(R.id.vd);
        manager = new PlayerManager(this);
        manager.setFullScreenOnly(true);
        manager.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        manager.playInFullScreen(true);
        manager.setPlayerStateListener(this);
        manager.play(url);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (manager.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStop() {
        super.onStop();
        manager.stop();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
}

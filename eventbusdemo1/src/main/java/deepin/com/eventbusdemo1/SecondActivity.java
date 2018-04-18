package deepin.com.eventbusdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        jumpActivity();
    }

    private void jumpActivity() {
        findViewById(R.id.id_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("从第二页返回，并显示第二页的结果 100% OK"));
                finish();
            }
        });
    }

}

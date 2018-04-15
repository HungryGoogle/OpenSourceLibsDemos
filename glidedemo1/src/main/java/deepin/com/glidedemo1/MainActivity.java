package deepin.com.glidedemo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MainActivity extends Activity {
    ImageView imageIv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageIv1 = findViewById(R.id.id_image_view_1);
        findViewById(R.id.id_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String girlUrl = "https://b-ssl.duitang.com/uploads/item/201502/25/20150225220925_5GBKm.png";
                String girlUrl = "https://ws1.sinaimg.cn/large/610dc034ly1fp9qm6nv50j20u00miacg.jpg";
                Glide
                        .with(MainActivity.this)
                        .load(girlUrl)
                        .thumbnail(0.1f)
                        .into(imageIv1);
            }
        });
    }


}

package deepin.com.rxjava1demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    Observable observable;
    Observer<String> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 观察者（接受者 接受事件）
        observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.i("Test","收到事件 = " + s);
//                Log.i("Test","传递面包事件");
            }
            @Override
            public void onCompleted() {
                Log.i("Test","onCompleted 传递面包事件完成");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("Test","onError 传递面包事件出错了");
            }
        };

        // 2 被观察者（发送事件的源）
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //subscriber.onNext("面包事件");
            }
        });

        // 3 将观察者和被观察者绑定起来
        observable.subscribe(observer);

        // 4 测试，让被观察者发送一个消息
        findViewById(R.id.id_observable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                observer.onNext("Event_1");
                observer.onNext("Event_2");
                observer.onNext("Event_3");
                observer.onCompleted();
                observer.onError(new NullPointerException("test rxjava"));
            }
        });


    }
}

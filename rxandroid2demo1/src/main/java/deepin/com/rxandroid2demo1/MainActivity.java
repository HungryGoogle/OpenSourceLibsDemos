package deepin.com.rxandroid2demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.function.Function;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建一个上游 Observable：
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //创建一个下游 Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.i(TAG, "onNext " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "complete");
            }
        };

        //建立连接
        observable.subscribe(observer);


    }

}

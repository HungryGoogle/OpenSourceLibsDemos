package deepin.com.retrofitdemo1;

import android.util.Log;
import android.widget.TextView;

/**
 * Created by Li on 2018/4/15.
 */

public class Translation {
    private int status;

    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show(TextView textView) {
        if(textView != null){
            textView.setText("我爱中国 翻译结果为： " + content.out);
        }

        System.out.println("leeTest---->" + status);
        System.out.println("leeTest---->" + content.from);
        System.out.println("leeTest---->" + content.to);
        System.out.println("leeTest---->" + content.vendor);
        System.out.println("leeTest---->" + content.out);
        System.out.println("leeTest---->" + content.errNo);
    }
}

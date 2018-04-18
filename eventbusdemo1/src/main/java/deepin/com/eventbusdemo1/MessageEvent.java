package deepin.com.eventbusdemo1;

/**
 * Created by Li on 2018/4/18.
 */

public class MessageEvent{
    private String message;
    public  MessageEvent(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

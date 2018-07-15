package deepin.com.greendaodemo1;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import deepin.com.greendaodemo1.dao.DaoMaster;
import deepin.com.greendaodemo1.dao.DaoSession;

public class MyApplication extends Application {

    private static MyApplication application;
    private MySQLiteOpenHelper openHelper;
    private Database db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    public static String database_name = "record-db";


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        setDatabase();
    }

    private void setDatabase() {
        openHelper = new MySQLiteOpenHelper(this, database_name, null);
        db = openHelper.getWritableDb();//获取可写数据库
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static MyApplication getMeApplication(){
        return application;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }


    public Database getDb() {
        return db;
    }
}

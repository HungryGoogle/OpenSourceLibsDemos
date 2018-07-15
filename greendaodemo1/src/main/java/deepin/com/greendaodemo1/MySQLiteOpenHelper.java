package deepin.com.greendaodemo1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import deepin.com.greendaodemo1.dao.DaoMaster;
import deepin.com.greendaodemo1.dao.UserDao;

public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}

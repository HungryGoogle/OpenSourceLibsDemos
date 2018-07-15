package deepin.com.greendaodemo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import deepin.com.greendaodemo1.dao.DaoMaster;
import deepin.com.greendaodemo1.dao.DaoSession;
import deepin.com.greendaodemo1.dao.UserDao;
import deepin.com.greendaodemo1.data.User;

public class MainActivity extends Activity {
    private  UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //绑定初始化ButterKnife
        ButterKnife.bind(this);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "my-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getEncryptedReadableDb("123456"));
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }

    @OnClick(R.id.id_addData)
    public void onClickAdd(View v) {
        User user = new User();
        user.setAddress("address1");
        user.setAge(18);
        user.setSex(true);
        user.setUsername("zhangsan");
        long retu = userDao.insert(user);
        Log.i("leeTest------>", "insert id = " + retu);
    }
    @OnClick(R.id.id_deleteData)
    public void onClickid_deleteData(View v) {
         userDao.deleteByKey((long) 1);
    }

    @OnClick(R.id.id_deleteAll)
    public void onClickid_deleteAll(View v) {
        userDao.deleteAll();
    }

    @OnClick(R.id.id_updateData)
    public void onClickid_updateData(View v) {
        User findUser = userDao.queryBuilder().where(UserDao.Properties.Id.eq("1")).build().unique();
        if(findUser != null){
            findUser.setUsername("lisi");
//            findUser.setId((long) 100);
            userDao.update(findUser);
        }
    }
    @OnClick(R.id.id_queryUser)
    public void onClickid_queryUser(View v) {
        Log.i("leeTest------>", "-----------------------------------------------");
        List<User> findUser = userDao.queryBuilder().where(UserDao.Properties.Id.gt(0)).build().list();
        for(int i = 0; i < findUser.size(); ++i){
            findUser.get(i).print();
        }
    }
}

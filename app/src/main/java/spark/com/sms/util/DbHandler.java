package spark.com.sms.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

import spark.com.sms.model.User;

/**
 * Created by root on 4/16/16.
 */
public class DbHandler extends SQLiteOpenHelper {


    private static final String DB_Name = "sms";
    private static final String TABLE_USER = "user";
    private static final String COL_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_EMAIL = "email";


    public DbHandler(Context context) {
        super(context, DB_Name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + "(" +
                "" + COL_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT ," +
                "" + COL_USERNAME + " TEXT ," +
                "" + COL_EMAIL + " TEXT" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public long addUser(User user){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME ,user.getUsername());
        contentValues.put(COL_EMAIL ,user.getEmail());
        long id = db.insert(TABLE_USER ,null,contentValues);
        db.close();
        return  id;
    }

    public List<User> getAllUsers() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from  " + TABLE_USER;
        Cursor res = db.rawQuery(sql, null);

        List<User> users = new ArrayList<>();
        if(res.moveToFirst()){
            do{
                User user = new User();
                user.setUsername(res.getString(1));
                user.setEmail(res.getString(2));

                users.add(user);
                res.moveToNext();
            }while (res.moveToNext());
        }
        Log.d("User List: " , users.toString());
        db.close();
        return users;
    }


}

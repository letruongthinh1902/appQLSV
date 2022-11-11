package com.example.studentmanagement.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context,"QLSinhVien2", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS " +
                " SinhVien(MaSV INTEGER PRIMARY KEY AUTOINCREMENT," +
                "HoTen VARCHAR(200)," +
                "GioiTinh INTEGER," +
                "DienThoai VARCHAR(13)," +
                "Email VARCHAR(50))";
        sqLiteDatabase.execSQL(sqlSVCreate);

        String sqlInsertSV = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) " +
                " values ('Lê Trường Thịnh','1','0775543227','letruongthinh@gmail.com')," +
                        "('Lê Trường Tú','1','0775543227','abc@gmail.com')," +
                        "('Lê Trường Tân','1','0975543286','abc2002@gmail.com')," +
                        "('Lê Trường Thắng','0','0985543213','abcdfr@gmail.com')," +
                        "('Lê Trường Tuệ','0','0962543332','kjghfd@gmail.com')," +
                        "('Lê Trường Than','1','0705543143','dadaa@gmail.com')," +
                        "('Lê Trường Phục','1','0950543860','letruongson@gmail.com')" ;
        sqLiteDatabase.execSQL(sqlInsertSV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.example.studentmanagement.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.studentmanagement.database.DbHelper;
import com.example.studentmanagement.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private DbHelper csdl;
    public SinhVienDao(Context context){
        csdl = new DbHelper(context);
    }

    public List<SinhVien> getAllStudent(){
        String sql = "select * from SinhVien";
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String dienthoai = cursor.getString(3);
            String email = cursor.getString(4);
            SinhVien sv = new SinhVien(masv,hoten,gioitinh,dienthoai,email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
        return sinhVienList;

    }
    public void AddStudent(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen",sv.getHoTen());
        values.put("GioiTinh",sv.getGioiTinh());
        values.put("DienThoai",sv.getDienThoai());
        values.put("Email",sv.getEmail());
        database.insert("SinhVien","",values);
    }
//    public void UpdateStudent(SinhVien sv){
//        String sql = "UPDATE SinhVien SET HoTen '=" + sv.getHoTen() + "'";
//        SQLiteDatabase database = csdl.getWritableDatabase();
//        database.execSQL(sql);
//    }
    //Cach 2
    public void UpdateStudent(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen",sv.getHoTen());
        values.put("Email",sv.getEmail());
        values.put("DienThoai",sv.getDienThoai());
        values.put("GioiTinh",sv.getGioiTinh());
        String masv = String.valueOf(sv.getMasv());
        String thamso[] = {masv};
        database.update("SinhVien",values,"MaSV=?",thamso);

    }

}

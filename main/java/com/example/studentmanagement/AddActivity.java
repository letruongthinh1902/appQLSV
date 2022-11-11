package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.studentmanagement.dao.SinhVienDao;
import com.example.studentmanagement.model.SinhVien;

public class AddActivity extends AppCompatActivity {
    EditText edtHoTen, edtEmail, edtDienThoai;
    RadioGroup rgGioiTinh;
    Button them, thoat;
    SinhVienDao svDao;
    SinhVien sv;
    int gioitinh = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Anhxa();
        svDao = new SinhVienDao(AddActivity.this);
        rgGioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam){
                    gioitinh = 1;
                }
                else
                    gioitinh =0;
            }
        });

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtHoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String dienthoai = edtDienThoai.getText().toString();
                SinhVien sv = new SinhVien(hoten,gioitinh,dienthoai,email);
                svDao.AddStudent(sv);
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa(){
        edtHoTen = (EditText) findViewById(R.id.edt_hoten);
        edtEmail = (EditText) findViewById(R.id.edit_email);
        edtDienThoai = (EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_gioitinh);
        them = (Button) findViewById(R.id.btn_them);
        thoat = (Button) findViewById(R.id.btn_thoat);
    }
}
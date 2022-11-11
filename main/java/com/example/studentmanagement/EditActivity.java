package com.example.studentmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.studentmanagement.dao.SinhVienDao;
import com.example.studentmanagement.model.SinhVien;

public class EditActivity extends AppCompatActivity {
    private EditText edtHoTen,edtEmail,edtDienThoai;
    private RadioGroup rgGioiTinh;
    private RadioButton rbNam,rbNu;
    private Button btnluu, btnthoat;
    private SinhVienDao dao;
    int gioitinh ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        dao = new SinhVienDao(EditActivity.this);
        Intent intent = getIntent();
        SinhVien sv =(SinhVien) intent.getSerializableExtra("Data");

        AnhXa();

        edtHoTen.setText(sv.getHoTen());
        edtEmail.setText(sv.getEmail());
        edtDienThoai.setText(sv.getDienThoai());
        if(sv.getGioiTinh()==1)
        {
            rbNam.setChecked(true);
            gioitinh =1;
        }
        else {
            rbNu.setChecked(true);
            gioitinh =0;
        }
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuyenHuong();
            }
        });

        rgGioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_nam)
                {
                    gioitinh =1;
                }
                else
                {
                    gioitinh =0;
                }
            }
        });

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.setHoTen(edtEmail.getText().toString());
                sv.setEmail(edtEmail.getText().toString());
                sv.setDienThoai(edtDienThoai.getText().toString());
                sv.setGioiTinh(gioitinh);
                dao.UpdateStudent(sv);
                Toast.makeText(EditActivity.this, "Computer id must be selected", Toast.LENGTH_SHORT).show();
                chuyenHuong();
            }
        });
    }
    public void AnhXa(){
        edtHoTen = (EditText) findViewById(R.id.edt_hoten);
        edtEmail = (EditText) findViewById(R.id.edit_email);
        edtDienThoai = (EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_gioitinh);
        rbNu = (RadioButton) findViewById(R.id.rb_nu);
        rbNam = (RadioButton) findViewById(R.id.rb_nam);
        btnluu = (Button) findViewById(R.id.btn_luu);
        btnthoat = (Button) findViewById(R.id.btn_thoat_edit);
    }

    public void chuyenHuong(){
        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
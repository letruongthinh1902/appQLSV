package com.example.studentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.studentmanagement.adapter.SinhVienAdapter;
import com.example.studentmanagement.dao.SinhVienDao;
import com.example.studentmanagement.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvSinhVien;
    private List<SinhVien> sinhVienList;
    private SinhVienAdapter adapter;
    private SinhVienDao svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien = (ListView) findViewById(R.id.list_student);

        sinhVienList = new ArrayList<>();
        svDao = new SinhVienDao(MainActivity.this);
        sinhVienList = svDao.getAllStudent();

        adapter = new SinhVienAdapter(getApplicationContext(),sinhVienList);
        lvSinhVien.setAdapter(adapter);
        listViewClick();
    }
    public void listViewClick(){
        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = sinhVienList.get(i);
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("Data",sv);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_them){
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        }
        if(id == R.id.menu_thoat){
            finish();
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList.clear();
        sinhVienList.addAll(svDao.getAllStudent());
        adapter.notifyDataSetChanged();
    }
}
package com.example.studentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentmanagement.R;
import com.example.studentmanagement.model.SinhVien;

import org.w3c.dom.Text;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> sinhVienList;
    private Context context;
    public SinhVienAdapter(Context context, List<SinhVien> listsv)
    {
        this.context = context;
        this.sinhVienList = listsv;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder;
        if(view == null){
            viewHoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_sinhvien, null);

            viewHoder.tvMaSV = view.findViewById(R.id.tv_masv);
            viewHoder.tvHoTen = view.findViewById(R.id.tv_hoTen);
            viewHoder.tvDienThoai = view.findViewById(R.id.tv_soDT);
            viewHoder.tvEmail = view.findViewById(R.id.tv_email);
            viewHoder.imGioiTinh = view.findViewById(R.id.im_gioitinh);


        }
        else
        {
            viewHoder = (ViewHoder) view.getTag();

        }
        SinhVien sv = sinhVienList.get(i);
        viewHoder.tvMaSV.setText("Mã sv: " + sv.getMasv());
        viewHoder.tvHoTen.setText("Họ tên: " + sv.getHoTen());
        viewHoder.tvDienThoai.setText("Số DT: " + sv.getDienThoai());
        viewHoder.tvEmail.setText("Email: "  + sv.getEmail());
        if(sv.getGioiTinh()==0)
        {
            viewHoder.imGioiTinh.setImageResource(R.drawable.boy123);
        }
        else
        {
            viewHoder.imGioiTinh.setImageResource(R.drawable.girl123);
        }
        return view;
    }

    class ViewHoder{
        ImageView imGioiTinh;
        TextView tvMaSV, tvHoTen,tvDienThoai, tvEmail;
    }
}

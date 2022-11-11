package com.example.studentmanagement.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int Masv;
    private String HoTen;
    private int GioiTinh;
    private String DienThoai;
    private String Email;

    public SinhVien() {
    }

    public SinhVien(String hoTen, int gioiTinh, String dienThoai, String email) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        DienThoai = dienThoai;
        Email = email;
    }

    public SinhVien(int masv, String hoTen, int gioiTinh, String dienThoai, String email) {
        Masv = masv;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        DienThoai = dienThoai;
        Email = email;
    }

    public int getMasv() {
        return Masv;
    }

    public void setMasv(int masv) {
        Masv = masv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

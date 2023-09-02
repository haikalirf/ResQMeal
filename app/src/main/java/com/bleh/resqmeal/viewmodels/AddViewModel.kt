package com.bleh.resqmeal.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class AddViewModel(): ViewModel() {
    private val _namaProduk = MutableStateFlow("")
    val namaProduk = _namaProduk

    fun setNamaProduk(namaProduk: String) {
        _namaProduk.value = namaProduk
    }

    private val _deskripsi = MutableStateFlow("")
    val deskripsi = _deskripsi

    fun setDeskripsi(deskripsi: String) {
        _deskripsi.value = deskripsi
    }

    private val _tanggalProduksi = MutableStateFlow("")
    val tanggalProduksi = _tanggalProduksi

    fun setTanggalProduksi(tanggalProduksi: String) {
        _tanggalProduksi.value = tanggalProduksi
    }

    private val _tanggalKadaluarsa = MutableStateFlow("")
    val tanggalKadaluarsa = _tanggalKadaluarsa

    fun setTanggalKadaluarsa(tanggalKadaluarsa: String) {
        _tanggalKadaluarsa.value = tanggalKadaluarsa
    }

    private val _jumlah = MutableStateFlow("")
    val jumlah = _jumlah

    fun setJumlah(jumlah: String) {
        _jumlah.value = jumlah
    }

    private val _berat = MutableStateFlow("")
    val berat = _berat

    fun setBerat(berat: String) {
        _berat.value = berat
    }

    private val _satuan = MutableStateFlow("")
    val satuan = _satuan

    fun setSatuan(satuan: String) {
        _satuan.value = satuan
    }

    private val _komposisi = MutableStateFlow("")
    val komposisi = _komposisi

    fun setKomposisi(komposisi: String) {
        _komposisi.value = komposisi
    }

    private val _alamat = MutableStateFlow("")
    val alamat = _alamat

    fun setAlamat(alamat: String) {
        _alamat.value = alamat
    }

    private val _waktu = MutableStateFlow("")
    val waktu = _waktu

    fun setWaktu(waktu: String) {
        _waktu.value = waktu
    }

    private val _kontak = MutableStateFlow("")
    val kontak = _kontak

    fun setKontak(kontak: String) {
        _kontak.value = kontak
    }
}
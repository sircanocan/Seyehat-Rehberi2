package com.example.seyehatproje

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.seyehatproje.databinding.ActivityMainKayitOlBinding


private lateinit var binding: ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)

        setContentView(binding.root)

        enableEdgeToEdge()

        binding.btnKaydet.setOnClickListener{
            var kullaniciBilgisi = binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola = binding.kayitParola.text.toString()
            //bilgiler adında data oluşturma
            var SharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            //veri ekleme ve
            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("parola","$kullaniciParola").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()
        }



        val button3 = findViewById<Button>(R.id.btnGiriseDon)

        button3.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)

            startActivity(intent)

        }




        }
    }
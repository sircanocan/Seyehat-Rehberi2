package com.example.seyehatproje

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seyehatproje.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var preferences: SharedPreferences
        val binding = ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // xmlden veri çekme
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliKullanici = preferences.getString("kullanici","")
        var kayitliParola = preferences.getString("parola","")

       // textviewlere kayıtlı bilgileri aktarma
        binding.kullaniciBilgisi.text = "Kullanıcı Adı :" + kayitliKullanici.toString()
        binding.kullaniciParola.text = "Kullancıı Parolası :" + kayitliParola.toString()



        //devam et
        val button4 = findViewById<Button>(R.id.btnDevamEt)
        button4.setOnClickListener {
            val intent = Intent(this,Sehir::class.java)
            startActivity(intent)
            finish()

        }


        //çıkış yap
        val button = findViewById<Button>(R.id.btnCikisYap)
        button.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }


        }
    }

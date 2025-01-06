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
import com.example.seyehatproje.databinding.ActivityMainBinding
import com.example.seyehatproje.databinding.ActivityMainKayitOlBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val preferences : SharedPreferences //data verisini çekmek için değişken oluştur
        enableEdgeToEdge()
        setContentView(binding.root)
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)//bilgiler dosyasındaki dataları çek

        val button = findViewById<Button>(R.id.btnGirisYap)

        button.setOnClickListener {
            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliParola = preferences.getString("parola","")

            var girisKullanici = binding.girisKullaniciAdi.text.toString()
            var girisParola = binding.girisParola.text.toString()

            if((kayitliKullanici==girisKullanici) && (kayitliParola==girisParola))
            {
                val intent = Intent(this,MainHosgeldiniz::class.java)


                startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext,"Girişiniz hatalı",Toast.LENGTH_LONG).show()
            }



        }

        val button2 = findViewById<Button>(R.id.btnKayitOl)

        button2.setOnClickListener {
            val intent = Intent(this,MainKayitOl::class.java)

            startActivity(intent)
        }







        }
    }

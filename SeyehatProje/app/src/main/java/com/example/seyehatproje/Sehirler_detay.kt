 package com.example.seyehatproje

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sehirler_detay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sehirler_detay)

        var bundle: Bundle? = intent.extras
        var adi = bundle!!.getString("constAdi")
        var aciklama = bundle!!.getString("constAciklama")
        var resim = bundle!!.getInt("constResim")
        var restorant = bundle!!.getString("constRestorant")
        var otel = bundle!!.getString("constOtel")
        var gezi = bundle!!.getString("constGezi")

        //resim değişkenleri
        val adanaResim = R.drawable.adana2
        val ankaraResim = R.drawable.ankara
        val eskisehirResim = R.drawable.eskisehir
        val istanbulResim = R.drawable.istanbul


        //bundle verilerini çekme
        findViewById<TextView>(R.id.detayAdi).text = adi
        findViewById<TextView>(R.id.detayAciklama).text = aciklama
        findViewById<TextView>(R.id.detayLink1).text = "Restoranlar için tıklayınız : "
        findViewById<TextView>(R.id.detayLink2).text = "Otel örnekleri için tıklayınız : "
        findViewById<TextView>(R.id.detayLink3).text = "Gezilecek yerler için tıklayınız : "

        resim?.let {
            findViewById<ImageView>(R.id.detayResim).setImageResource(it)
        }

        findViewById<TextView>(R.id.detayLink1).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(restorant))
            startActivity(intent)
        }

        // Otel linkine tıklanabilirlik ekleme
        findViewById<TextView>(R.id.detayLink2).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(otel))
            startActivity(intent)
        }

        // Gezi linkine tıklanabilirlik ekleme
        findViewById<TextView>(R.id.detayLink3).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gezi))
            startActivity(intent)
        }




        if(resim == adanaResim)
        {
            findViewById<TextView>(R.id.detayAciklama).text = "Adana, Türkiye'nin Adana ilinin merkezi olan şehridir. Seyhan, Yüreğir, Çukurova ve Sarıçam olmak üzere 4 ilçeye bölünür. Türkiye'deki altıncı büyük metropolitan alan olup ülkenin önde gelen tarım, ticaret ve kültür merkezlerinden biridir. Türkiye'deki maden zengini 4. bölge olan Adana; krom, demir, manganez, kurşun ve çinko yatakları açısından önem taşımaktadır.\n" +
                    "\n"





        }

        if(resim == ankaraResim)
        {
            findViewById<TextView>(R.id.detayAciklama).text = "5 milyonu aşkın nüfusu ile Türkiye’nin başkenti ve 2. Büyük şehri olan Ankara, 20’den fazla üniversiteye ev sahipliği yapması bakımından bir öğrenci şehri niteliğindedir. 25 ilçeden oluşan Ankara İli, sanayi bölgelerinin, üst düzey bürokrasinin, uluslararası kurumların ve sivil toplum kuruluşlarının faaliyetleri ve yıl boyu devam eden sosyal, kültürel, sportif ve sanatsal etkinliklerle zengin ve canlı bir şehir hayatı fırsatı sunmaktadır."
        }

        if (resim == R.drawable.eskisehir) {
            findViewById<TextView>(R.id.detayAciklama).text = "Eskişehir, Türkiye'nin en gelişmiş şehirlerinden biridir. Öğrenci şehri olarak bilinen Eskişehir, iki büyük üniversitesi ile genç ve dinamik bir nüfusa sahiptir. Şehir, modern yapıları, geniş parkları ve canlı sosyal hayatıyla dikkat çeker."
        }

        if (resim == R.drawable.istanbul) {
            findViewById<TextView>(R.id.detayAciklama).text =
                "İstanbul, Türkiye'nin en büyük şehri ve eski başkentidir. Hem Asya hem de Avrupa kıtalarında yer alan İstanbul, tarihi ve kültürel zenginlikleri ile ünlüdür. Dünyanın dört bir yanından gelen turistler, İstanbul'un eşsiz atmosferini yaşamak için buraya akın eder."
        }
}
}
package com.example.seyehatproje

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.persistableBundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seyehatproje.databinding.ActivityMainBinding

class Sehir : AppCompatActivity() {


    var constList = ArrayList<Sehir_sinif>()
    var adapter: SehirlerAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sehir)


        constList.add(
            Sehir_sinif("Adana", "Giriş için tıklayınız", R.drawable.adana2,
            "https://www.oggusto.com/gastronomi/turkiye/adana-en-iyi-restoranlar",
            "https://www.etstur.com/Adana-Otelleri",
            "https://www.bugunnereyegidelim.com/adana-gezilecek-yerler"
            ))

        constList.add(Sehir_sinif("Ankara", "Giriş için tıklayınız", R.drawable.ankara,
            "https://yemek.com/ankara-mekanlari/",
            "https://www.etstur.com/Ankara-Otelleri",
            "https://www.kulturportali.gov.tr/turkiye/ankara/gezilecekyer"
        ))

        constList.add(Sehir_sinif("Eskişehir", "Giriş için tıklayınız", R.drawable.eskisehir,
            "https://www.oggusto.com/gastronomi/turkiye/eskisehir-restoranlari",
            "https://www.etstur.com/Eskisehir-Otelleri",
            "https://kulturportali.gov.tr/turkiye/eskisehir/gezilecekyer"
        ))
        constList.add(Sehir_sinif("İstanbul", "Giriş için tıklayınız", R.drawable.istanbul,
            "https://www.oggusto.com/gastronomi/turkiye/istanbul-restoranlari",
            "https://www.etstur.com/Istanbul-Otelleri",
            "https://kulturportali.gov.tr/turkiye/istanbul/gezilecekyer"
        ))

        adapter = SehirlerAdapter(this,constList)
        findViewById<ListView>(R.id.listView).adapter = adapter


        }



    class SehirlerAdapter: BaseAdapter
    {
        var constList = ArrayList<Sehir_sinif>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<Sehir_sinif>):super(){
            this.constList = constList
            this.context = context
        }

        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(position: Int): Any{
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
             return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val sehir = constList[position]

            val view = convertView?: LayoutInflater.from(context).inflate(R.layout.sehir_karti,parent,false)
            val sehirAdiTextView = view.findViewById<TextView>(R.id.kartAdi)
            val aciklamaTextView = view.findViewById<TextView>(R.id.kartAciklama)
            val resimImageView = view.findViewById<ImageView>(R.id.kartResim)

            sehirAdiTextView.text = sehir.constAdi
            aciklamaTextView.text = sehir.constAciklama
            sehir.constResim?.let { resimImageView.setImageResource(it) }?:resimImageView.setImageResource(R.drawable.adana2)


            resimImageView.setOnClickListener {
                val intent = Intent(context, Sehirler_detay::class.java).apply {
                    putExtra("constAdi",sehir.constAdi)
                    putExtra("constAciklama",sehir.constAciklama)
                    putExtra("constResim",sehir.constResim)
                    putExtra("constRestorant", sehir.constRestorant)
                    putExtra("constOtel", sehir.constOtel)
                    putExtra("constGezi", sehir.constGezi)
                }
                context!!.startActivity(intent)
            }


            return view
        }

    }

    }

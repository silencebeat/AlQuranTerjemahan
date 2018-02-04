package silencebeat.com.alquranterjemahanindonesia.Views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import freeapk.com.alqurantranslation.Views.ViewHolders.SurahViewHolder
import java.util.*
import kotlinx.android.synthetic.main.activity_list_surah.*
import silencebeat.com.alquranterjemahanindonesia.Entities.Lists.Surah
import silencebeat.com.alquranterjemahanindonesia.Entities.Models.SurahModel
import silencebeat.com.alquranterjemahanindonesia.R
import silencebeat.com.alquranterjemahanindonesia.Supports.Utils.Adapter

/**
 * Created by Candra Triyadi on 01/02/2018.
 */
class ListSurahActivity: AppCompatActivity(){


    lateinit var  adapter : Adapter<SurahModel, SurahViewHolder>
    val surah = Surah()
    val listSurah: ArrayList<SurahModel>
        get() = surah.surahList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_surah)
        setToolbar()
        setList()
    }

    private fun setToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    private fun setList(){
        val manager = LinearLayoutManager(this)
        adapter = object : Adapter<SurahModel, SurahViewHolder>(R.layout.list_surah, SurahViewHolder::class.java,
                SurahModel::class.java, listSurah){
            override fun bindView(holder: SurahViewHolder, tipeData: SurahModel, position: Int) {
                holder.onBind(applicationContext, tipeData)
            }
        }

        list_surah.layoutManager = manager
        list_surah.adapter = adapter
    }

}
package com.alvinsaputra.tugashero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.alvinsaputra.tugashero.model.SuperHero
import com.alvinsaputra.tugashero.network.RetrofitInstance
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchSuperHero("1")  // Contoh ID superhero
    }

    private fun fetchSuperHero(id: String) {
        val call = RetrofitInstance.api.getSuperHero(id)
        call.enqueue(object : Callback<SuperHero> {
            override fun onResponse(call: Call<SuperHero>, response: Response<SuperHero>) {
                if (response.isSuccessful) {
                    val superHero = response.body()
                    superHero?.let { displaySuperHero(it) }
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.failed_retrieve_data), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SuperHero>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displaySuperHero(superHero: SuperHero) {
        val imageViewHero: ImageView = findViewById(R.id.imageViewHero)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewBiodata: TextView = findViewById(R.id.textViewBiodata)
        val textViewPowerStats: TextView = findViewById(R.id.textViewPowerStats)

        //Alvin Saputra_10121063

        Picasso.get().load(superHero.image.url).into(imageViewHero)
        textViewName.text = superHero.name
        textViewBiodata.text = """
            ${getString(R.string.publisher)}: ${superHero.biography.publisher}
            ${getString(R.string.alignment)}: ${superHero.biography.alignment}
        """.trimIndent()
        textViewPowerStats.text = """
            ${getString(R.string.intelligence)}: ${superHero.powerstats.intelligence}
            ${getString(R.string.strength)}: ${superHero.powerstats.strength}
            ${getString(R.string.speed)}: ${superHero.powerstats.speed}
            ${getString(R.string.durability)}: ${superHero.powerstats.durability}
            ${getString(R.string.power)}: ${superHero.powerstats.power}
            ${getString(R.string.combat)}: ${superHero.powerstats.combat}
        """.trimIndent()
    }
}

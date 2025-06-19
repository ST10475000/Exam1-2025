package za.ac.iie.exam1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var Results: TextView
    private lateinit var btnDisplay: Button
    private lateinit var btnAverage: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)


        val Results = findViewById<TextView>(R.id.txtResults)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // 🔘 Show All Items
        btnDisplay.setOnClickListener {
            val result = StringBuilder()
            for (i in MainActivity.NameofSong.indices) {
                result.append("song: ${MainActivity.NameofSong[i]}\n")
                result.append("ArtistName: ${MainActivity.ArtistNames[i]}\n")
                result.append("ratings: ${MainActivity.Ratings[i]}\n")
                result.append("Comment: ${MainActivity.Comments[i]}\n\n")
            }
            Results.text = result.toString()
        }


        btnAverage.setOnClickListener {
            val result = StringBuilder()
            for (i in MainActivity.NameofSong.indices) {
                if (MainActivity.Ratings[i] >= 1) {
                    result.append("NameofSong:${MainActivity.ArtistNames[i]}\n")
                    result.append("ArtistName: ${MainActivity.NameofSong[i]}\n")
                    result.append("Ratings: ${MainActivity.Ratings[i]}\n\n")
                }
            }
            Results.text = result.toString()
        }

        // 🔙 Back to Main Screen
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()




            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}
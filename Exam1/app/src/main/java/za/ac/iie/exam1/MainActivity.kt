package za.ac.iie.exam1

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Audio.Artists
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

        companion object {
            val ArtistNames = mutableListOf<String>()
            val NameofSong = mutableListOf<String>()
            val Ratings = mutableListOf<Int>()
            val Comments = mutableListOf<String>()
        }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)


            val songInput = findViewById<EditText>(R.id.edtSong)
            val ArtistInput = findViewById<EditText>(R.id.edtArtist)
            val RatingInput = findViewById<EditText>(R.id.edtRating)
            val commentInput = findViewById<EditText>(R.id.edtComment)

            val addButton = findViewById<Button>(R.id.btnAdd)
            val viewButton = findViewById<Button>(R.id.btnMove)
            val exitButton = findViewById<Button>(R.id.btnExit)

            addButton.setOnClickListener {
                try {
                    val name = songInput.text.toString()
                    val category = ArtistInput.text.toString()
                    val Rating = RatingInput.text.toString().toInt()
                    val comment = commentInput.text.toString()

                    if (name.isNotEmpty() && category.isNotEmpty()) {
                        ArtistNames.add(name)
                        NameofSong.add(category)
                        Ratings.add(Rating)
                        Comments.add(comment)

                        Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show()
                        songInput.text.clear()
                        ArtistInput.text.clear()
                        RatingInput.text.clear()
                        commentInput.text.clear()
                    } else {
                        Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                    }

                } catch (e: Exception) {
                    Toast.makeText(this, "Invalid input ", Toast.LENGTH_SHORT).show()
                }
            }

            viewButton.setOnClickListener {
                startActivity(Intent(this, SecondActivity::class.java))
            }

            exitButton.setOnClickListener {
                finish()

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(
                        systemBars.left,
                        systemBars.top,
                        systemBars.right,
                        systemBars.bottom
                    )
                    insets

                }
            }
        }
    }
package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.rollDiceButton)
        val fragment1 = DieFragment.newInstance(100)
        supportFragmentManager.beginTransaction().add(R.id.DiceContainer, fragment1).commit()
         button.setOnClickListener{
             (supportFragmentManager.findFragmentById(R.id.DiceContainer) as DieFragment).throwDie()


         }

    }
}
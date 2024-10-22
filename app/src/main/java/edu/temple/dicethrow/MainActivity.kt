package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), ButtonFragment.buttonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val button = findViewById<Button>(R.id.rollDiceButton)
         supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, )
        val dieFrag = DieFragment.newInstance(100)
        supportFragmentManager.beginTransaction().add(R.id.DiceContainer, dieFrag).commit()

//        button.setOnClickListener {
//            (supportFragmentManager.findFragmentById(R.id.DiceContainer) as DieFragment).throwDie()
//        }

    }

    override fun buttonClicked() {

    }

}
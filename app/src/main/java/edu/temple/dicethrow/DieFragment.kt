package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import kotlin.random.Random

    const val DIESIDE = "sidenumber"
    var dieRoll = 101
    const val DIEKEY = "diekey"
class DieFragment : Fragment() {


    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DIEKEY, dieRoll)
        //dieRoll = this.getInt(DIEKEY, dieRoll)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //if there is a saved instance

       //if (savedInstanceState){
       //     //why is this not possible
       // }
        savedInstanceState?.run {
            dieRoll= getInt(DIEKEY)
            throwDie()
        }
        if (dieRoll > 100){
            throwDie()
        }else{
            dieTextView.text = dieRoll.toString()
        }
    }

    fun throwDie()  {
        var tempRoll =(Random.nextInt(dieSides) + 1)
        dieTextView.text = tempRoll.toString()
        dieRoll =  tempRoll
    }

    companion object{
        fun newInstance(sides: Int): DieFragment {
            val frag = DieFragment()
            val bundle = Bundle()
            bundle.putInt(DIESIDE, sides)
            frag.arguments = bundle

            return frag
        }


    }
}
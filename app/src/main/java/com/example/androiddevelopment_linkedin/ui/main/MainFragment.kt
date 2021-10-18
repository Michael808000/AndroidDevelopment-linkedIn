package com.example.androiddevelopment_linkedin.ui.main
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androiddevelopment_linkedin.R
import java.lang.StringBuilder
import kotlinx.android.synthetic.main.fragment_main.message




class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.monsterData.observe(viewLifecycleOwner, Observer {
            val monsterNames = StringBuilder()
            for(monster in it){
//                Log.i(LOG_TAG, "${monster.monsterName} (\$${monster.price})")
                monsterNames.append(monster.monsterName).append("\n")
            }
            message.text=monsterNames

        })

        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}

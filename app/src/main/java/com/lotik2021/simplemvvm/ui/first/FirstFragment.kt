package com.lotik2021.simplemvvm.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.lotik2021.simplemvvm.R
import com.lotik2021.simplemvvm.data.model.Simple
import com.lotik2021.simplemvvm.di.Injectable
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject

class FirstFragment : DaggerFragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: FirstViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.simpleById(1).observe(this, Observer<Simple> { entity ->
//            println(entity)
//        })

        btn_add.setOnClickListener(View.OnClickListener {
            viewModel.addSimple()
        })

        btn_get_all.setOnClickListener(View.OnClickListener {
            viewModel.simpleAll().observe(this, Observer { all ->
                tv_data.setText(all.toString())
            })
        })

        btn_get.setOnClickListener(View.OnClickListener {
            viewModel.simpleById(et_id.text.toString().toInt()).observe(this, Observer { entity ->
                tv_data.setText(entity.toString())
            })
        })
    }
}
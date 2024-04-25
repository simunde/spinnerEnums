package com.msid.spinnerenums.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.msid.spinnerenums.R
import com.msid.spinnerenums.databinding.ActivityMainBinding
import com.msid.spinnerenums.viewModel.SpinnerViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: SpinnerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(SpinnerViewModel::class.java)
        binding.viewModel = viewModel // Set the viewModel instance
        binding.lifecycleOwner = this

        binding.itemSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.selectedSpinnerItem.value =
                    SpinnerViewModel.SpinnerItem.values()[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }

        }
        viewModel.selectedSpinnerItem.observe(this) { itemName ->
            Toast.makeText(this, "Selected item: $itemName", Toast.LENGTH_SHORT).show()
        }
    }
}
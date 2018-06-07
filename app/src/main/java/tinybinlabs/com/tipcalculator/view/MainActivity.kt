package tinybinlabs.com.tipcalculator.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import tinybinlabs.com.tipcalculator.R
import tinybinlabs.com.tipcalculator.databinding.ActivityMainBinding
import tinybinlabs.com.tipcalculator.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       binding.vm = CalculatorViewModel(application)
    }
}

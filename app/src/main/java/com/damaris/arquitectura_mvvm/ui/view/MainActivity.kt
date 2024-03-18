// A- ARQUITECTURA MVVM
// 1- creamos el model (data class) dentro de la carpeta model -> después tendríamos que llamar a una api o room
// 2- crear el viewmodel -> llama al model y hace "algo"
// 3- view (MainActivity) recibe ese "algo" y lo muestra en el layout

// B- ARQUITECTURA MVVM - CLEAN ARCHITECTURE, RETROFIT2, Y CORRUTINAS
/*

    Tenemos entonces:
    1- en "core" se llama a una API con Reotrofit
    2- en "data"
        "model"
            a- el modelo de la Quote
            b- var quotes que es una lista de tipo del modelo
        "network"
            c- se hace un get a la api d- se retorna el response y e- se lo mete a var quotes

 */

// C- INYECCIÓN DE DEPENDENCIAS DAGGER HILT

// D- ROOM

// E- TESTING

package com.damaris.arquitectura_mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.damaris.arquitectura_mvvm.databinding.ActivityMainBinding
import com.damaris.arquitectura_mvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.texto1.text = it.quote
            binding.texto2.text = it.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}
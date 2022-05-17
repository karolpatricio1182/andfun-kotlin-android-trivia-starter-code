package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    /*
En nuestra actividad, usamos DataBindingUtil.setContentView para obtener la clase de enlace de un diseño,
pero como estamos en un fragmento, debemos llamar a DataBindingUtil.inflate en onCreateView con el inflador de
diseño proporcionado, el ID de recurso de diseño, el viewgroup a proporcionado. será alojado por y false para
no adjuntarlo al viewgroup. Retorna binding.root. El código debería verse así:

Notas
1.- El método inflate() crea una instancia de la clase de vinculación para la actividad que se usará.
 */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }
    /*
    devuelve verdadero si NavigationUI.onNav...  devuelve verdadero, de lo contrario, devuelve super.onOptionsItemSelected
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())  || super.onOptionsItemSelected(item)
    }
}
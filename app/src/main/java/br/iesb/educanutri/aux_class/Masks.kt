package br.iesb.educanutri.aux_class

import android.widget.TextView
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher

class Masks (mask: String, input: TextView){

    /*
        * N - for numbers.
        * L - for letters.
        * A - for numbers and letters.
        * l - for lowercase letters.
        * U - for uppercase letters.
        * */

    init{
        val mascara = SimpleMaskFormatter(mask);
        val mtw = MaskTextWatcher(input, mascara)
        input.addTextChangedListener(mtw);
    }
}
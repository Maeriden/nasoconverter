package it.meridian.nasoconverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment

class FragmentCoins2Money
    : Fragment()
{
    private lateinit var moneyView: TextView

    private lateinit var t0 : EditText
    private lateinit var t1 : EditText
    private lateinit var t2 : EditText
    private lateinit var t3 : EditText
    private lateinit var t4 : EditText


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View?
    {
        val root = inflater.inflate(R.layout.fragment_coins2money, container, false)
        this.moneyView = root.findViewById(R.id.money)

        this.t0 = root.findViewById<EditText>(R.id.t0).apply{ doAfterTextChanged{ updateMoney() } }
        this.t1 = root.findViewById<EditText>(R.id.t1).apply{ doAfterTextChanged{ updateMoney() } }
        this.t2 = root.findViewById<EditText>(R.id.t2).apply{ doAfterTextChanged{ updateMoney() } }
        this.t3 = root.findViewById<EditText>(R.id.t3).apply{ doAfterTextChanged{ updateMoney() } }
        this.t4 = root.findViewById<EditText>(R.id.t4).apply{ doAfterTextChanged{ updateMoney() } }

        return root
    }


    @Suppress("UNUSED_PARAMETER")
    private fun updateMoney()
    {
        // 1 Scudiera = 5000 Legni
        // 1 Garzub   = 250  Legni
        // 1 Draco    = 100  Legni
        // 1 Torcia   = 20   Legni
        // 1 Legno    = 1    $
        var money = 0L
        money += (this.t4.text.toString().toLongOrNull() ?: 0L) * 5000
        money += (this.t3.text.toString().toLongOrNull() ?: 0L) * 250
        money += (this.t2.text.toString().toLongOrNull() ?: 0L) * 100
        money += (this.t1.text.toString().toLongOrNull() ?: 0L) * 20
        money += (this.t0.text.toString().toLongOrNull() ?: 0L) * 1
        this.moneyView.text = money.toString()
    }
}
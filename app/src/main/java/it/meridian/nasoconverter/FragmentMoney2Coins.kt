package it.meridian.nasoconverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment

class FragmentMoney2Coins
    : Fragment()
{
    private lateinit var moneyEdit : EditText

    private lateinit var c0 : ToggleCoin
    private lateinit var c1 : ToggleCoin
    private lateinit var c2 : ToggleCoin
    private lateinit var c3 : ToggleCoin
    private lateinit var c4 : ToggleCoin

    private lateinit var t0 : TextView
    private lateinit var t1 : TextView
    private lateinit var t2 : TextView
    private lateinit var t3 : TextView
    private lateinit var t4 : TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View?
    {
        val root = inflater.inflate(R.layout.fragment_money2coins, container, false)
        this.moneyEdit = root.findViewById<EditText>(R.id.money).apply{ doAfterTextChanged{ updateCoins() } }

        this.c0 = root.findViewById<ToggleCoin>(R.id.c0).apply{ setOnCheckedChangeListener{ _, _ -> updateCoins() } }
        this.c1 = root.findViewById<ToggleCoin>(R.id.c1).apply{ setOnCheckedChangeListener{ _, _ -> updateCoins() } }
        this.c2 = root.findViewById<ToggleCoin>(R.id.c2).apply{ setOnCheckedChangeListener{ _, _ -> updateCoins() } }
        this.c3 = root.findViewById<ToggleCoin>(R.id.c3).apply{ setOnCheckedChangeListener{ _, _ -> updateCoins() } }
        this.c4 = root.findViewById<ToggleCoin>(R.id.c4).apply{ setOnCheckedChangeListener{ _, _ -> updateCoins() } }

        this.t0 = root.findViewById(R.id.t0)
        this.t1 = root.findViewById(R.id.t1)
        this.t2 = root.findViewById(R.id.t2)
        this.t3 = root.findViewById(R.id.t3)
        this.t4 = root.findViewById(R.id.t4)

        return root
    }


    private fun updateCoins()
    {
        // 1 Scudiera = 5000 Legni
        // 1 Garzub   = 250  Legni
        // 1 Draco    = 100  Legni
        // 1 Torcia   = 20   Legni
        // 1 Legno    = 1    $
        var money = this.moneyEdit.text.toString().toLongOrNull() ?: 0L

        if(!this.c4.isChecked)
        {
            this.t4.text = (money / 5000).toString()
            money %= 5000
        }
        else
        {
            this.t4.text = "0"
        }

        if(!this.c3.isChecked)
        {
            this.t3.text = (money / 250).toString()
            money %= 250
        }
        else
        {
            this.t3.text = "0"
        }

        if(!this.c2.isChecked)
        {
            this.t2.text = (money / 100).toString()
            money %= 100
        }
        else
        {
            this.t2.text = "0"
        }

        if(!this.c1.isChecked)
        {
            this.t1.text = (money / 20).toString()
            money %= 20
        }
        else
        {
            this.t1.text = "0"
        }

        this.t0.text = money.toString()
    }
}
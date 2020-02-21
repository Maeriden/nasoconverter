package it.meridian.nasoconverter

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View
import android.widget.*


class ToggleCoin(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
    : ImageView(context, attributeSet, defStyleAttr, defStyleRes)
{
    private var callback  : ((view : ToggleCoin, isChecked : Boolean) -> Unit)? = null
    private var checkable : Boolean
    private var checked   : Boolean


    init
    {
        val attrs: TypedArray? = context.obtainStyledAttributes(attributeSet, R.styleable.ToggleCoin, defStyleAttr, defStyleRes)
        this.checkable = attrs?.getBoolean(R.styleable.ToggleCoin_checkable, false) ?: false
        this.checked   = attrs?.getBoolean(R.styleable.ToggleCoin_checked, false) ?: false
        attrs?.recycle()

        this.applyTint()
        this.setOnClickListener(::onClick)
    }


    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : this(context, attributeSet, defStyleAttr, 0)
    constructor(context: Context, attributeSet: AttributeSet?)                    : this(context, attributeSet, 0)
    constructor(context: Context)                                                 : this(context, null)


    val isChecked : Boolean
        get() = this.checked


    private fun applyTint()
    {
        if(this.checked)
            this.setColorFilter(Color.rgb(64, 64, 64), PorterDuff.Mode.MULTIPLY)
        else
            this.clearColorFilter()
    }


    @Suppress("UNUSED_PARAMETER")
    private fun onClick(view : View)
    {
        if(!this.checkable)
            return
        this.checked = !this.checked
        this.applyTint()
        this.callback?.invoke(this, this.checked)
    }


    fun setOnCheckedChangeListener(callback : ((view : ToggleCoin, isChecked : Boolean) -> Unit)?)
    {
        this.callback = callback
    }
}
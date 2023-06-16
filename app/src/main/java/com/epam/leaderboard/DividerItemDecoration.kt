package com.epam.leaderboard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val dividerHeight: Int
    private val dividerPaint: Paint

    init {
        // Initialize the divider height and paint
        dividerHeight = context.resources.getDimensionPixelSize(R.dimen.divider_height)
        dividerPaint = Paint()
        dividerPaint.color = ContextCompat.getColor(context, R.color.divider_color)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        // Set the bottom offset for each item to the divider height
        outRect.bottom = dividerHeight
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        val leftOffset = parent.context.resources.getDimensionPixelSize(R.dimen.divider_offset)
        val rightOffset = parent.width - leftOffset

        for (i in 0 until childCount - 1) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + dividerHeight

            canvas.drawRect(
                leftOffset.toFloat(),
                top.toFloat(),
                rightOffset.toFloat(),
                bottom.toFloat(),
                dividerPaint
            )
        }
    }

}

package com.epam.leaderboard

import androidx.core.content.ContextCompat
import com.epam.leaderboard.databinding.ItemPersonBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun personAdapterDelegate() =
    adapterDelegateViewBinding<Person, Person, ItemPersonBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemPersonBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            binding.titleTextView.text = item.name
            binding.subtitleTextView.text = item.username
            binding.textViewScore.text = item.score.toString()
            binding.textViewScore.setCompoundDrawablesWithIntrinsicBounds(
                null,
                null,
                null,
                ContextCompat.getDrawable(
                    context,
                    when (item.trend) {
                        Person.Trend.UP -> R.drawable.ic_triangle_up
                        Person.Trend.DOWN -> R.drawable.ic_triangle_bottom
                    }
                )
            )
        }
    }

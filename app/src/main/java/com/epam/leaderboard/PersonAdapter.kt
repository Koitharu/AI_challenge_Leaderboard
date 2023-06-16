package com.epam.leaderboard

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class PersonAdapter(
    dataset: List<Person>
) : ListDelegationAdapter<List<Person>>() {

    init {
        delegatesManager.addDelegate(personAdapterDelegate())
        setItems(dataset)
    }
}

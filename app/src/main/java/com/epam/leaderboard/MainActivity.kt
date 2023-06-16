package com.epam.leaderboard

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.epam.leaderboard.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var personAdapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personAdapter = PersonAdapter(generateRandomPersons(this))
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this))
        binding.recyclerView.adapter = personAdapter
        binding.tab1.setOnClickListener(this)
        binding.tab2.setOnClickListener(this)
        binding.tab3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        sequenceOf(binding.tab1, binding.tab2, binding.tab3)
            .forEach {
                it.isChecked = it == v
            }
        personAdapter.items = generateRandomPersons(this)
        personAdapter.notifyDataSetChanged()
    }

    private fun generateRandomPersons(context: Context): List<Person> {
        val names = context.resources.getStringArray(R.array.random_names).toList()
        val usernames = listOf(
            "user1",
            "user2",
            "user3",
            "user4",
            "user5",
            "user6",
            "user7",
            "user8",
            "user9",
            "user10"
        )
        val avatarUrls = listOf(
            "https://example.com/avatar1.jpg",
            "https://example.com/avatar2.jpg",
            "https://example.com/avatar3.jpg",
            "https://example.com/avatar4.jpg",
            "https://example.com/avatar5.jpg"
        )
        val scores = (0..100).toList()
        val trends = listOf(Person.Trend.UP, Person.Trend.DOWN)

        val random = Random(System.currentTimeMillis())
        val personList = mutableListOf<Person>()

        repeat(20) {
            val name = names.random(random)
            val username = usernames.random(random)
            val avatarUrl = avatarUrls.random(random)
            val score = scores.random(random)
            val trend = trends.random(random)

            val person = Person(name, username, avatarUrl, score, trend)
            personList.add(person)
        }

        return personList
    }
}

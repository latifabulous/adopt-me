package com.example.adoptme

object FishData {
    private val fishNames = arrayOf(
        "Angelfish",
        "Mullet",
        "Barracuda",
        "Arapaima",
        "Halibut",
        "Pumppano"
    )

    private val fishDetails = arrayOf(
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet"
    )

    private val fishImages = intArrayOf(
        R.drawable.ikan1,
        R.drawable.ikan2,
        R.drawable.ikan3,
        R.drawable.ikan4,
        R.drawable.ikan5,
        R.drawable.ikan6,
    )

    val listData: ArrayList<Fish>
        get() {
            val list = arrayListOf<Fish>()
            for (position in fishNames.indices) {
                val fish = Fish()
                fish.name = fishNames[position]
                fish.detail = fishDetails[position]
                fish.photo = fishImages[position]

                list.add(fish)
            }
            return list
        }
}

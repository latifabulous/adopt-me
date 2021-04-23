package com.example.adoptme

object FishData {
    private val fishNames = arrayOf(
        "Tabi",
        "Mochy",
        "Macarons"
    )

    private val fishDetails = arrayOf(
        "Buntel",
        "Oren",
        "Kitty"
    )

    private val fishImages = intArrayOf(
        R.drawable.kucing1,
        R.drawable.kucing2,
        R.drawable.kucing3
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

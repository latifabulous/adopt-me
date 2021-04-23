package com.example.adoptme

object DogData {
    private val dogNames = arrayOf(
        "Tabi",
        "Mochy",
        "Macarons"
    )

    private val dogDetails = arrayOf(
        "Buntel",
        "Oren",
        "Kitty"
    )

    private val dogImages = intArrayOf(
        R.drawable.kucing1,
        R.drawable.kucing2,
        R.drawable.kucing3
    )

    val listData: ArrayList<Dog>
        get() {
            val list = arrayListOf<Dog>()
            for (position in dogNames.indices) {
                val dog = Dog()
                dog.name = dogNames[position]
                dog.detail = dogDetails[position]
                dog.photo = dogImages[position]

                list.add(dog)
            }
            return list
        }
}

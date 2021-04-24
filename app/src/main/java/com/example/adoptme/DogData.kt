package com.example.adoptme

object DogData {
    private val dogNames = arrayOf(
        "Abert",
        "Berkely",
        "Dixie",
        "Islen",
        "Fuzzy",
        "Aiko"
    )

    private val dogDetails = arrayOf(
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet"
    )

    private val dogImages = intArrayOf(
        R.drawable.anjing1,
        R.drawable.anjing2,
        R.drawable.anjing3,
        R.drawable.anjing4,
        R.drawable.anjing5,
        R.drawable.anjing6
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

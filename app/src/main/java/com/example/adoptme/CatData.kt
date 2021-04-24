package com.example.adoptme

object CatData {
    private val catNames = arrayOf(
        "Tabi",
        "Mochy",
        "Vivi",
        "Rapunzel",
        "Ruby",
        "Macarons"
    )

    private val catDetails = arrayOf(
        "Buntel",
        "Oren",
        "Kitty",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet",
        "Lorem ipsum dolor sit amet"
    )

    private val catImages = intArrayOf(
            R.drawable.kucing1,
            R.drawable.kucing2,
            R.drawable.kucing3,
            R.drawable.kucing4,
            R.drawable.kucing5,
            R.drawable.kucing6
    )

    val listData: ArrayList<Cat>
        get() {
            val list = arrayListOf<Cat>()
            for (position in catNames.indices) {
                val cat = Cat()
                cat.name = catNames[position]
                cat.detail = catDetails[position]
                cat.photo = catImages[position]

                list.add(cat)
            }
            return list
        }
}

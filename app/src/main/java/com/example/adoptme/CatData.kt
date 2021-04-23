package com.example.adoptme

object CatData {
    private val catNames = arrayOf(
        "Tabi",
        "Mochy",
        "Macarons"
    )

    private val catDetails = arrayOf(
        "Buntel",
        "Oren",
        "Kitty"
    )

    private val catImages = intArrayOf(
        R.drawable.kucing1,
        R.drawable.kucing2,
        R.drawable.kucing3
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

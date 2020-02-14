package com.astashin.bookvoed.entity

class User(
    var userName: String,
    private var passphrase: String,
    var myBooks: MutableList<String> = mutableListOf(),
    var avatar: String? = null
)
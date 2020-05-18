package com.georgcantor.storetest.model.data

data class Company(
    var id: Int,
    var name: String,
    var img: String,
    var description: String,
    var lat: Float,
    var lon: Float,
    var www: String,
    var phone: String
)
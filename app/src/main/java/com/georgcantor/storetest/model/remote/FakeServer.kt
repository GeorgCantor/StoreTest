package com.georgcantor.storetest.model.remote

import com.georgcantor.storetest.model.Product

class FakeServer {

    companion object {
        fun getProducts(): List<Product> {
            return listOf(
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Samsung Galaxy S Duos S7562", 7230, 2),
                Product(hashCode(), "Canon EOS 600D Kit", 15659, 4),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5),
                Product(hashCode(), "Apple iPod touch 5 32Gb", 8888, 5)
            )
        }
    }

}
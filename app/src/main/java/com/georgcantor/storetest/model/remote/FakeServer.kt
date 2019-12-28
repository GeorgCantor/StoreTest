package com.georgcantor.storetest.model.remote

import com.georgcantor.storetest.model.Product

class FakeServer {

    companion object {
        fun getProducts(): List<Product> {
            return listOf(
                Product((0..100000).random(), "Apple iPod touch 5 32Gb", 8888F, 5),
                Product((0..100000).random(), "Samsung Galaxy S Duos S7562", 7230F, 2),
                Product((0..100000).random(), "Canon EOS 600D Kit", 15659F, 4),
                Product((0..100000).random(), "Samsung Galaxy Tab 2 10.1 P5100 16Gb", 13290F, 9),
                Product((0..100000).random(), "PocketBook Touch", 5197F, 2),
                Product((0..100000).random(), "Samsung Galaxy Note II 16Gb", 17049.50F, 2),
                Product((0..100000).random(), "Nikon D3100 Kit", 12190F, 4),
                Product((0..100000).random(), "Canon EOS 1100D Kit", 10985F, 2),
                Product((0..100000).random(), "Sony Xperia acro S", 11800.99F, 1),
                Product((0..100000).random(), "Lenovo G580", 8922F, 1)
            )
        }
    }

}
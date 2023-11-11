package com.mak.walmartapp

class Product(
    val logoName: String,
    val imageName: String,
    val productName: String,
    val productModel: String,
    val productDescription: String,
    val cost: Double
) {
    override fun toString(): String {
        //return "Product(logoName='$logoName', imageName='$imageName', productName='$productName', productModel='$productModel', productDescription='$productDescription', cost=$cost)"
        return "$productModel : $$cost"
    }
}
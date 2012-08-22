package com.alvinalexander.scalatra1

class Stock (var symbol: String, var price: Double) {
  override def toString = symbol + ", " + price
}

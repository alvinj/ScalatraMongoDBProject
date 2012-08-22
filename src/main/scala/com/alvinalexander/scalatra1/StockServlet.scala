package com.alvinalexander.scalatra1

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet
import com.google.gson.Gson
import Control._
import com.mongodb.casbah.Imports._

class StockServlet extends ScalatraServlet with ScalateSupport {

  /**
   * Incoming string looks like this:
   * {"symbol":"GOOG","price":"600.00"}
   */
  post("/saveJsonStock") {
    val jsonString = params.get("JSON")
    try {
      val gson = new Gson
      // jsonString is actually a Some, need to use get() here
      val stock = gson.fromJson(jsonString.get, classOf[Stock])
      println(stock)
      val mongoObj = convertStockToMongoDbObject(stock)
      using(MongoFactory.getConnection) { conn =>
        MongoFactory.getCollection(conn).save(mongoObj)
      }
      response.addHeader("ACK", "GOT IT")
    } catch {
        case e: Exception => 
          e.printStackTrace
          response.addHeader("ACK", "BOOM!")
    }
  }
  
  def convertStockToMongoDbObject(stock: Stock): MongoDBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "symbol" -> stock.symbol
    builder += "price" -> stock.price
    builder.result
  }

}










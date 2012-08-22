package com.alvinalexander.scalatra1

import com.mongodb.casbah.MongoCollection
import com.mongodb.casbah.MongoConnection

object MongoFactory {
  
  private val SERVER = "localhost"
  private val DATABASE = "investing"
  private val COLLECTION = "stocks"

  def getConnection = MongoConnection(SERVER) 

  def getCollection(conn: MongoConnection) = conn(DATABASE)(COLLECTION)

  def closeConnection(conn: MongoConnection) {
    conn.close
  }

}
package com.alvinalexander.scalatra1

import java.util.ArrayList
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair
import org.apache.http.NameValuePair

import com.google.gson.Gson

object StockServletTester extends App {

  // create our object as a json string
  val stock = new Stock("AAPL", 650.00)
  val stockAsJson = new Gson().toJson(stock)

  // add name value pairs to a post object
  val post = new HttpPost("http://localhost:8080/stocks/saveJsonStock")
  val nameValuePairs = new ArrayList[NameValuePair]()
  nameValuePairs.add(new BasicNameValuePair("JSON", stockAsJson))
  post.setEntity(new UrlEncodedFormEntity(nameValuePairs))

  // send the post request
  val client = new DefaultHttpClient
  val response = client.execute(post)
  println("--- HEADERS ---")
  response.getAllHeaders.foreach(arg => println(arg))

}



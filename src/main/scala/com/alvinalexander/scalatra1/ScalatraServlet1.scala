package com.alvinalexander.scalatra1

import org.scalatra._
import scalate.ScalateSupport
import Control._
import scala.math.BigDecimal
import com.mongodb.casbah.Imports._

class ScalatraServlet1 extends ScalatraServlet with ScalateSupport {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

  // call like this:
  // http://localhost:8080/saveName?fname=Alvin&lname=Alexander
  // prints: Some(Alvin), Some(Alexander)
  get("/saveName") {
    val firstName = params.get("fname")
    val lastName = params.get("lname")
    <p>{firstName}, {lastName}</p>
  }
  
  // call like this:
  // http://localhost:8080/hello/Alvin/Alexander
  get("/hello/:fname/:lname") {
    <p>Hello, {params("fname")}, {params("lname")}</p>
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound() 
  }
}













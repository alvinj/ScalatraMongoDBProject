A Scalatra Web Service With MongoDB Support
===========================================

This is a template for a basic, beginning Scalatra project that works with a MongoDB database.

A few notes:

* It uses a standard SBT directory strucure.
* Check out the build.sbt file for all the dependencies. I left the logging stuff in there because you'll probably want logging in a real project, and the Casbah line includes the Scala Casbah driver for MongoDB support.
* In SBT, start the container with "container:start", then get auto-recompiling going with "~ aux-compile".
* Change your database settings in the MongoFactory class.
* The StockServletTester class can be used to test your POST servlets.
* I left the ScalatraServlet1 class in the project because it shows how to handle GET request parameters. Of course, feel free to delete it.

Checkout a Copy
---------------

You can checkout a read-only copy of this project with this command:

<pre>
git clone <git: url here>
</pre>

Notes
-----

Note: All the little ".gitignore" files are in the empty subdirectories so those directories would be checked into Git. (Git doesn't like empty directories, so you have to do something to get it to keep empty directories in the repo.)

Alvin Alexander  
http://devdaily.com


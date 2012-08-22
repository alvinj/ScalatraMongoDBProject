
import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import com.alvinalexander.scalatra1.ScalatraServlet1
import com.alvinalexander.scalatra1.StockServlet

class Scalatra extends LifeCycle {

  override def init(context: ServletContext) {
    context mount (new StockServlet, "/stocks/*")
    context mount (new ScalatraServlet1, "/*")
  }
}


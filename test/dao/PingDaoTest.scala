package dao

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import dao.framework.MongoProp._
import com.github.simplyscala.MongoEmbedDatabase
import model.Ping

class PingDaoTest extends FunSuite with ShouldMatchers with MongoEmbedDatabase {

    implicit val dbName: MongoDbName = "test"

    test("should save Ping") {
        val ping = Ping(Some("version"), Some("ccVersion"), Some("ccuid"), Some("login"), Some("pingType"), Some("detectedOs"))

        withEmbedMongoFixture(port = 27017) { mongodProps =>
            PingDao.savePing(ping)
            PingDao.countPings() should be (1L)

            PingDao.savePing(ping)
            PingDao.countPings() should be (2L)
        }
    }
}
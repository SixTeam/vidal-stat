package dao

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import dao.framework.MongoProp._
import com.github.simplyscala.MongoEmbedDatabase
import model.Ping

class PingDaoTest extends FunSuite with ShouldMatchers with MongoEmbedDatabase {

    implicit val dbName: MongoDbName = "test"
    implicit val dbPort: MongoDbPort = 22000

    test("should save Ping") {
        val ping = Ping(Some("version"), Some("ccVersion"), Some("ccuid"), Some("login"), Some("pingType"), Some("detectedOs"))

        withEmbedMongoFixture(dbPort) { mongodProps =>
            PingDao.savePing(ping)
            PingDao.countPings() should be (1L)

            PingDao.savePing(ping)
            PingDao.countPings() should be (2L)
        }
    }

    test("should retrieve all Pings") {
        val ping1 = Ping(Some("version1"), Some("ccVersion1"), Some("ccuid1"), Some("login1"), Some("pingType1"), Some("detectedOs1"))
        val ping2 = Ping(Some("version2"), Some("ccVersion2"), Some("ccuid2"), Some("login2"), Some("pingType2"), Some("detectedOs2"))

        withEmbedMongoFixture(dbPort) { mongodProps =>
            PingDao.savePing(ping1)
            PingDao.allPings() should be(List(ping1))

            PingDao.savePing(ping2)
            PingDao.allPings() should be(List(ping1, ping2))
        }
    }
}
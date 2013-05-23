package dao

import framework.MongoOperations
import framework.MongoConnectionPool
import framework.MongoProp._
import model.{PingMongoMapper, Ping}

object PingDao extends PingDaoTrait with MongoOperations with PingMongoMapper with MongoConnectionPool {
    def savePing(ping: Ping)(implicit dbName: MongoDbName) = save(ping)

    //def allPings()(implicit dbName: MongoDbName) {}
    def countPings()(implicit dbName: MongoDbName): Long = count
}
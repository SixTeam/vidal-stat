package dao

import framework.MongoOperations
import framework.MongoConnectionPool
import framework.MongoProp._
import model.{PingMongoMapper, Ping}
import com.mongodb.casbah.commons.MongoDBObject

object PingDao extends PingDaoTrait with MongoOperations with PingMongoMapper with MongoConnectionPool {
    def savePing(ping: Ping)(implicit dbName: MongoDbName, port: MongoDbPort = 27017) = save(ping)

    def allPings()(implicit dbName: MongoDbName, port: MongoDbPort = 27017): List[Ping] = find[Ping](MongoDBObject())

    def countPings()(implicit dbName: MongoDbName, port: MongoDbPort = 27017): Long = count
}
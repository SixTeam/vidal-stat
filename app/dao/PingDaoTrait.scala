package dao

import model.Ping
import dao.framework.MongoProp._

trait PingDaoTrait {
    def savePing(ping: Ping)(implicit dbName: MongoDbName, port: MongoDbPort)
    def allPings()(implicit dbName: MongoDbName, port: MongoDbPort): List[Ping]
    def countPings()(implicit dbName: MongoDbName, port: MongoDbPort): Long
}
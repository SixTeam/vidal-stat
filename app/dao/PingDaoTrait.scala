package dao

import model.Ping
import dao.framework.MongoProp.MongoDbName

trait PingDaoTrait {
    def savePing(ping: Ping)(implicit dbName: MongoDbName)
    //def allPings()(implicit dbName: MongoDbName)
    def countPings()(implicit dbName: MongoDbName): Long
}
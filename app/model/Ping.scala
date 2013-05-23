package model

import dao.framework.MongoDbModel

case class Ping(version: Option[String], ccVersion: Option[String], ccuid: Option[String],
                login: Option[String], pingType: Option[String], detectedOs: Option[String])

trait PingMongoMapper {
    import com.mongodb.casbah.Imports._

    implicit object PingMongoModel extends MongoDbModel[Ping] {
        def collectionName: String = "pings"

        def write(ping: Ping): DBObject = DBObject(
            "version" -> ping.version,
            "ccVersion" -> ping.ccVersion,
            "ccuid" -> ping.ccuid,
            "login" -> ping.login,
            "pingType" -> ping.pingType,
            "detectedOs" -> ping.detectedOs
        )

        def read(dbo: DBObject): Ping = Ping(
            version = dbo.getAs[String]("version"),
            ccVersion = dbo.getAs[String]("ccVersion"),
            ccuid = dbo.getAs[String]("ccuid"),
            login = dbo.getAs[String]("login"),
            pingType = dbo.getAs[String]("pingType"),
            detectedOs = dbo.getAs[String]("detectedOs")
        )
    }
}
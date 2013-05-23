package dao.framework

import com.mongodb.{MongoOptions, ServerAddress}
import com.mongodb.casbah.{MongoCollection, MongoDB, MongoConnection}
import dao.framework.MongoProp._

trait MongoConnectionPool {
    implicit def retrieveMongoCollection(collectionName: MongoCollectionName)
                                        (implicit dbName: MongoDbName): MongoCollection = {
        val pool: MongoDB = MongoPool()
        pool(collectionName)
    }

    private object MongoPool {
        def apply()(implicit dbName: MongoDbName): MongoDB = connection(dbName)

        private val connection: MongoConnection = {
            val options: MongoOptions = new MongoOptions()
            options.setConnectionsPerHost(100)
            MongoConnection(new ServerAddress("127.0.0.1"),options)
        }
    }
}
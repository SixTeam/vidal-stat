package controllers

import play.api._
import play.api.mvc._
import model.Ping
import dao.PingDao
import dao.framework.MongoProp._

object Application extends Controller {

    implicit val dbName: MongoDbName = "vidal-stat"

    def index = Action {
        Ok(views.html.index("Your new application is ready."))
    }

    // PUT /ping?version=1&ccVersion=2&ccuid=112233&login=toto&pingType=ping&detectedOs=genou
    def ping = Action { request =>
        val version = request.getQueryString("version")
        val ccVersion = request.getQueryString("ccVersion")
        val ccuid = request.getQueryString("ccuid")
        val login = request.getQueryString("login")
        val pingType = request.getQueryString("pingType")
        val detectedOs = request.getQueryString("detectedOs")

        PingDao.savePing(Ping(version, ccVersion, ccuid, login, pingType, detectedOs))

        Ok("ping received")
    }

    def showPings = Action {
        val response1 = s"nb de ping en base : ${PingDao.countPings().toString} \n \n"
        val response2 = "pings : \n \n" + PingDao.allPings().mkString("\n")

        Ok(response1 + response2)
    }
}
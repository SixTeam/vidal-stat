package controllers

import play.api._
import play.api.mvc._
import model.Ping

object Application extends Controller {

    var pings = List[Ping]()

    def index = Action {
        Ok(views.html.index("Your new application is ready."))
    }

    /*String product,
    String version,
    String ccVersion,
    String ccuuid,
    String login,
    String pingType,
    String detectedOs)*/

    // PUT /ping?version=1&ccVersion=2&ccuid=112233&login=toto&pingType=ping&detectedOs=genou
    def ping = Action { request =>
        val version = request.getQueryString("version")
        val ccVersion = request.getQueryString("ccVersion")
        val ccuid = request.getQueryString("ccuid")
        val login = request.getQueryString("login")
        val pingType = request.getQueryString("pingType")
        val detectedOs = request.getQueryString("detectedOs")

        pings = Ping(version, ccVersion, ccuid, login, pingType, detectedOs) :: pings

        Ok("ping received")
    }

    def showPings = Action { Ok(pings.toString()) }

    def clear = Action { pings = Nil; Ok(pings.toString()) }
}
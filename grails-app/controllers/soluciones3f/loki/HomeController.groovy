package soluciones3f.loki

import grails.plugin.springsecurity.annotation.Secured
import soluciones3f.loki.auth.AuthenticationToken

class HomeController {
    def springSecurityService

    def index() {
        if (!(springSecurityService.isLoggedIn())) {
            log.info "index for NOT logged"
            return redirect(controller: "login")
        }
        log.info "index for logged"
    }

    def userJson() {
        def user = springSecurityService.currentUser
        def tokens = AuthenticationToken.list()

        def res = [ "user": user, "tokens": tokens ]
        respond res
    }

}


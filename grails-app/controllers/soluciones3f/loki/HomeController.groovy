package soluciones3f.loki

import com.odobo.grails.plugin.springsecurity.rest.token.generation.TokenGenerator
import com.odobo.grails.plugin.springsecurity.rest.token.storage.TokenStorageService
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import soluciones3f.loki.auth.AuthenticationToken

class HomeController {
    def springSecurityService
    TokenGenerator tokenGenerator
    TokenStorageService tokenStorageService

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

    def generateToken() {
        String tokenValue = tokenGenerator.generateToken()
        log.debug "Generated token: ${tokenValue}"

        tokenStorageService.storeToken(tokenValue, springSecurityService.principal)
        def r = [ username: springSecurityService.principal, access_token: tokenValue ]
        respond r
    }
}


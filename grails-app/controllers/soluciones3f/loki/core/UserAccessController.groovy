package soluciones3f.loki.core


import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.web.servlet.ModelAndView
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException

import soluciones3f.loki.*

class UserAccessController extends grails.plugin.springsecurity.oauth.SpringSecurityOAuthController {
	def createAccount() {
		// This is a new user or a legacy user not yet associated.
		// As legacy users were identified by their email, we first look for a user
		// with the same username than the socialId to link them together.

		// Should check only for not logged in users?

		def oAuthToken = session[SPRING_SECURITY_OAUTH_TOKEN]
		if(!oAuthToken) throw Exception("There is no oauth token.")

		def User = springSecurityOAuthService.lookupUserClass()
		def user = User.findByUsername(oAuthToken.socialId)
		if(!user) throw Exception("This version of loki does not support new users registrations")

		user.addToOAuthIDs(provider: oAuthToken.providerName, accessToken: oAuthToken.socialId, user: user)
        if (user.validate() && user.save()) {
            oAuthToken = springSecurityOAuthService.updateOAuthToken(oAuthToken, user)
        }
        else {
        	throw Exception("There was a problem updating the user")
        }

        authenticateAndRedirect(oAuthToken, getDefaultTargetUrl())
	}
}



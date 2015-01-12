// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

grails.config.locations = [ "classpath:${appName}-config.properties",
                            "classpath:${appName}-config.groovy",
                            "file:${userHome}/.grails/${appName}-config.properties",
                            "file:${userHome}/.grails/${appName}-config.groovy"]

if (System.properties["${appName}.config.location"]) {
    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
}

// change this to alter the default package name and Maven publishing destination
grails.project.groupId = soluciones3f.loki

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
        grails.plugin.springsecurity.debug.useFilter = true
        grails.serverURL = "http://127.0.0.1:8080/loki"
    }
    production {
        grails.logging.jul.usebridge = false
        grails.serverURL = "http://loki.soluciones3f.com.ar"
    }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    appenders {
        console name:'stdout', layout:pattern(conversionPattern: '"%5r %-5p %c{3} %l %m%n')
    }

    // info 'grails.plugin.springsecurity.web.filter.DebugFilter'

    debug 'grails.app.controllers.soluciones3f.loki',
          'grails.app.service.soluciones3f.loki',
          'grails.app.domain.soluciones3f.loki'
          // 'grails.plugin.springsecurity'

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

grails.assets.less.compile = 'less4j'
grails.assets.excludes = ["**/*.less", "/icons/**"]
grails.assets.plugin."twitter-bootstrap".excludes = ["**/*.less"]
grails.assets.plugin."twitter-bootstrap".includes = ["bootstrap.less"]
grails.assets.minifyJs = false

grails.plugins.twitterbootstrap.fixtaglib = true

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'soluciones3f.loki.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'soluciones3f.loki.auth.UserRole'
grails.plugin.springsecurity.authority.className = 'soluciones3f.loki.auth.Role'

// this introuces an infinite loop in /login/auth
// grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
    '/springSecurityOAuth/**':        ['permitAll'],
    '/assets/**':                     ['permitAll'],
    '/login/**':                      ['permitAll'],
    '/logout/**':                     ['permitAll'],
    '/oauth/**':                      ['permitAll'],
    '/userAccess/**':                 ['permitAll'],
    '/**':                            ['isFullyAuthenticated()'],

]

environments {
    development {
      grails.plugin.springsecurity.controllerAnnotations.staticRules['/dbconsole/**'] = ['permitAll']
    }
}


// Added by the Spring Security OAuth plugin:
def appName = grails.util.Metadata.current.'app.name'
def baseURL = grails.serverURL ?: "http://127.0.0.1:8080/${appName}"

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.oauth.domainClass = 'soluciones3f.loki.auth.OAuthID'
grails.plugin.springsecurity.oauth.registration.askToLinkOrCreateAccountUri = '/userAccess/createAccount'

oauth {
  debug = true
  providers {
    google {
      api = org.grails.plugin.springsecurity.oauth.GoogleApi20
      key = "replace-with-google-developer-key"
      secret = 'replace-with-google-developer-secret'
      successUri = '/oauth/google/success'
      failureUri = '/oauth/google/failure'
      callback = "${baseURL}/oauth/google/callback"
      scope = 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email'
    }
  }
}

loki {
    allow_user_registration = false
}

grails.gorm.failOnError = true
# Loki

[![Build Status](https://travis-ci.org/soluciones3f/loki.svg?branch=master)](https://travis-ci.org/soluciones3f/loki)

Simple and easy quotation manager

## Requirements

This are the versions we are using for development and testing since this is a simple project other versions might (or might not :bowtie: ) work.
 * Grails 2.4.3
 * Chrome 39.0.x
 * MySQL Server 5.6.x
 * Google Key for Google OpenID support, create your project [here](https://console.developers.google.com/project)

## Local setup
 
I prefer using a local setup to minimize commiting files that are not really my own. You should create a file
```bash
~/.grails/loki-config.groovy
```

With this content

```groovy

grails.serverURL = "http://loki.local.com:8080/loki"

loki {
    allow_user_registration = true
}

// Added by the Spring Security OAuth plugin:
def appName = grails.util.Metadata.current.'app.name'
def baseURL = grails.serverURL ?: "http://127.0.0.1:8080/${appName}"

oauth {
  debug = true
  providers {
    google {
      api = org.grails.plugin.springsecurity.oauth.GoogleApi20
      key = "your_google_key"
      secret = 'your_google_secret'
      successUri = '/oauth/google/success'
      failureUri = '/oauth/google/failure'
      callback = "${baseURL}/oauth/google/callback"
      scope = 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email'
    }
  }
}


environments {
    development {
        dataSource {
            // dialect = org.hibernate.dialect.MySQLInnoDBDialect
            driverClassName = 'com.mysql.jdbc.Driver'
            url = 'jdbc:mysql://localhost/loki'
            dbCreate = 'create-drop'
            username = "db_username"
            password = "db_password"
        }

    }
}
```




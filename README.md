# Loki

[![Build Status](https://travis-ci.org/soluciones3f/loki.svg?branch=master)](https://travis-ci.org/soluciones3f/loki)

Timesheet WebApp that will, eventually, support basic CRM features. It is completly designed to be API based and is build using well-known frameworks like:
 * AngularJS
 * Bootstrap
 * SpringSecurity

## Requirements

This are the versions we are using for development and testing since this is a simple project other versions might (or might not :bowtie: ) work.
 * Grails 2.4.4
 * Chrome 41.0.x
 * MySQL Server 5.6.x
 * Google Key for Google OAuth support, create your project [here](https://console.developers.google.com/project)

## Local setup
 
I prefer using a local setup to minimize commiting files that are not really my own. You should create a file
```bash
~/.grails/loki-config.groovy
```

With this content

```groovy
dataSource.username = "<database-username>"
dataSource.password = "<database-password>"
dataSource.url = 'jdbc:mysql://localhost/loki_v2'

grails.serverURL = "http://loki.local.comdd:8080/loki"
loki {
    allow_user_registration = true
}

oauth {
  providers {
    google {
      key = "<your-google-key>"
      secret = "<your-google-secret>"
    }
  }
}
```




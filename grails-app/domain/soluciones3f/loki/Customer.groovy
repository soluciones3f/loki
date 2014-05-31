package soluciones3f.loki

import grails.rest.Resource

@Resource(uri="/customer")
class Customer {

    String name
    String email
    String VAT
    String address

    static constraints = {
    }
}

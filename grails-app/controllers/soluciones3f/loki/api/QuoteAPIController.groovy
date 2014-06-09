package soluciones3f.loki.api

import groovy.json.JsonOutput

class QuoteAPIController {
    def quoteLineService

    static namespace = "api"
    static responseFormats = ['json', 'xml']
    static defaultAction = "get"
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def save() {
        def json = request.JSON
        log.debug "Cotizacion: ${JsonOutput.prettyPrint(json.toString())}"

        def ql = quoteLineService.create(json)

        respond ql
    }

    def forCustomer() {
        log.debug "forCustomer ${params}"
        def customerId = params.id

    }
}

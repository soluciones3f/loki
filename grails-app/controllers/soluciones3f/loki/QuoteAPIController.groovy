package soluciones3f.loki

import groovy.json.JsonOutput

class QuoteAPIController {
    static namespace = "api"
    static responseFormats = ['json', 'xml']
    static defaultAction = "get"
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def save() {
        def json = request.JSON
        log.debug "Cotizacion: ${JsonOutput.prettyPrint(json.toString())}"

        respond json
    }
}

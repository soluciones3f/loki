package soluciones3f.loki
import grails.converters.*

class TimesheetController {

    //
    // retrieve timesheet information for currently logged user.
    //
    def list(String from, String to) {
        def result = [
            from: from, 
            to: to, 
            projects: [
                [
                    id: 1, 
                    days: [
                        20141001: 0,
                        20141002: 7,
                        20141003: 0,
                        20141004: 8,
                        20141005: 0,
                        20141006: 3,
                        20141007: 0,
                        20141009: 3,
                        20141010: 0,
                        20141011: 0,
                        20141012: 0,
                        20141013: 0,
                        20141014: 0,
                    ]
                ],
                [
                    id: 2, 
                    days: [
                        20141001: 2,
                        20141002: 5,
                        20141003: 7,
                        20141004: 2,
                        20141005: 5,
                        20141006: 3,
                        20141007: 3,
                        20141008: 3,
                        20141009: 5,
                        20141010: 7,
                        20141011: 5,
                        20141012: 0,
                        20141013: 0,
                        20141014: 0,
                    ]
                ],
            ]
        ]
        render result as JSON
    }

    def index() { }

    def partialShow() {
    	
    }
}

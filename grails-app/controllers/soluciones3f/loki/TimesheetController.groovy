package soluciones3f.loki
import grails.converters.*

class TimesheetController {

    //
    // retrieve timesheet information for currently logged user.
    //
    def list(String from, String to) {
        def result = [
            projects: [
                [id: 1, days: [0, 7, 0, 8, 0, 3, 0, 3, 3, 0, 0, 0, 0, 0]],
                [id: 2, days: [1, 2, 4, 0, 5, 2, 5, 0, 0, 0, 6, 0, 0, 0]],
            ]
        ]
        render result as JSON
    }

    def index() { }

    def partialShow() {
    	
    }
}

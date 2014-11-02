package soluciones3f.loki

import grails.converters.*
import org.joda.time.LocalDate
import org.joda.time.format.ISODateTimeFormat

class TimesheetController {

    //
    // retrieve timesheet information for currently logged user.
    //
    def list(String from, String to) {
        // TODO: limit to only one user not hardcoded
        def hours = Work.findAllByDateBetweenAndIdUser(
            LocalDate.parse(from, ISODateTimeFormat.basicDate()).toDate(),
            LocalDate.parse(to, ISODateTimeFormat.basicDate()).toDate(),
            3 // userid
        )

        // Group hours by project and transform to final array
        def projects = hours.groupBy { it.project }
        def days = projects.collect { project, work ->
            [
                id: project.id,
                days: work.collectEntries { [ it.date.format("yyyyMMdd"), it.hours ] }
            ]
        }

        def result = [ from: from, to: to, projects: days ]
        render result as JSON
    }

    def index() { }

    def partialShow() {
    	
    }
}

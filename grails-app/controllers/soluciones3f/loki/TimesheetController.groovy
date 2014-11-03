package soluciones3f.loki

import grails.converters.*
import org.joda.time.LocalDate
import org.joda.time.format.ISODateTimeFormat

class TimesheetController {
    private getIdUser() { return 3; }

    //
    // retrieve timesheet information for currently logged user.
    //
    def list(String from, String to) {
        // TODO: limit to only one user not hardcoded
        def hours = Work.findAllByDateBetweenAndIdUser(
            LocalDate.parse(from, ISODateTimeFormat.basicDate()).toDate(),
            LocalDate.parse(to, ISODateTimeFormat.basicDate()).toDate(),
            getIdUser()
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

    def saveHour() {
        assert params.idProject && params.date

        // create or update this value in database
        def project = Project.get(params.idProject)
        def work = Work.findByProjectAndDateAndIdUser(
            project, 
            LocalDate.parse(params.date, ISODateTimeFormat.basicDate()).toDate(),
            getIdUser()
        )
        
        if(work) work.hours = params.int("hours")
        work.save(failOnError: true, flush: true)

        render ([result: "success"]) as JSON
    }

    def index() { }

    def partialShow() {
    	
    }
}

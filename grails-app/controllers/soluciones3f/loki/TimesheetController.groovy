package soluciones3f.loki

import grails.converters.*
import org.joda.time.LocalDate
import org.joda.time.format.ISODateTimeFormat

class TimesheetController {
    def springSecurityService

    private getIdUser() { 
        // Le pedimos a spring secrity que nos diga cual es id del usuario actual
        def principal = springSecurityService.principal
        principal.id
    }

    //
    // retrieve timesheet information for currently logged user.
    //
    def list(String from, String to) {
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

        def publicHolidays = PublicHoliday.findAllByDateBetween(
            LocalDate.parse(from, ISODateTimeFormat.basicDate()).toDate(),
            LocalDate.parse(to, ISODateTimeFormat.basicDate()).toDate(),
        ).collect { it.date.format("yyyyMMdd") }

        def result = [ from: from, to: to, projects: days, publicHolidays: publicHolidays ]
        render result as JSON
    }

    def saveHour() {
        assert params.idProject && params.date

        def project = Project.get(params.idProject)
        Date date = LocalDate.parse(params.date, ISODateTimeFormat.basicDate()).toDate()

        // create or update this value in database
        def work = Work.findByProjectAndDateAndIdUser(
            project, 
            date,
            getIdUser()
        )
        
        if(!work) work = new Work(date: date, idUser: getIdUser(), project: project)
        work.hours = params.int("hours")
        
        work.save()
        def result = [result: "success"]

        render result as JSON
    }

    def index() { }

    def partialShow() {
    	
    }
}

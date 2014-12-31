package soluciones3f.loki

import grails.converters.*
import groovy.time.TimeCategory
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
        Date fromDate = LocalDate.parse(from, ISODateTimeFormat.basicDate()).toDate()
        Date toDate = LocalDate.parse(to, ISODateTimeFormat.basicDate()).toDate()

        def hours = Work.findAllByDateBetweenAndIdUser( fromDate, toDate, getIdUser() )

        // Group hours by project and transform to final array
        def projects = hours.groupBy { it.project }
        def days = projects.collect { project, work ->
            [
                id: project.id,
                name: project.name,
                days: work.collectEntries { [ it.date.format("yyyyMMdd"), it.hours ] }
            ]
        }

        // Add top five projects from previous month if they were not added already
        def otherProjects = Work.createCriteria().list {
            eq("idUser", getIdUser())
            use(TimeCategory) {
                between("date", fromDate - 1.month, fromDate)
            }
            
            projections {
                groupProperty("project")
                sum("hours", "hours")
            }

            order("hours", "desc")
            maxResults(10)
        }
        otherProjects.each { project ->
            if(!projects.containsKey(project[0]))
                days << [id: project[0].id, name: project[0].name ,days: []]
        }

        // Alfabetic ordering of projects
        days.sort { it.name }

        def publicHolidays = PublicHoliday.findAllByDateBetween(fromDate, toDate).collect { 
            it.date.format("yyyyMMdd") 
        }

        def result = [ from: from, to: to, projects: days, publicHolidays: publicHolidays ]
        render result as JSON
    }

    def saveHour() {
        assert params.idProject && params.date

        def project = Project.get(params.idProject)
        Date date = LocalDate.parse(params.date, ISODateTimeFormat.basicDate()).toDate()

        // create or update this value in database
        def work = Work.findOrCreateByProjectAndDateAndIdUser(
            project, 
            date,
            getIdUser()
        )
        work.hours = params.int("hours")
        
        if(work.hours == 0) work.delete()
        else work.save()

        def result = [result: "success"]
        render result as JSON
    }

    def index() { }

    def partialShow() {
    	
    }
}

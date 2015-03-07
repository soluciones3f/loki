package soluciones3f.loki.api

import soluciones3f.loki.Work
import soluciones3f.loki.auth.User
import org.joda.time.LocalDate
import org.joda.time.format.ISODateTimeFormat

class ReportAPIController {
	static namespace = "api"
    static responseFormats = ['json', 'xml']

	def work(String from, String to) {
		Date fromDate = LocalDate.parse(from, ISODateTimeFormat.date()).toDate()
		Date toDate = LocalDate.parse(to, ISODateTimeFormat.date()).toDate()

		def value = Work.findAllByDateBetween(fromDate, toDate)
		def username = { id -> User.get(id).username }.memoize()

		// TODO: use a custom marsaller or rendrer to avoid converting the structure here.
		def adaptedValue = value.collect {
			[date: it.date, hours: it.hours, username: username(it.idUser), project: [
				id: it.project.id,
				name: it.project.name
			]]
		}

		respond adaptedValue
	}
}
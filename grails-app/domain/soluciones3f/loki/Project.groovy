package soluciones3f.loki

class Project {
    String name

    Date dateCreated
    Date lastUpdate

    static belongsTo = [ customer: Customer ]

    static constraints = {

    }
}

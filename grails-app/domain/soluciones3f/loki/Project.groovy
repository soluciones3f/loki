package soluciones3f.loki

class Project {
    String name

    Date dateCreated
    Date lastUpdated

    static belongsTo = [ customer: Customer ]

    static constraints = {

    }
}

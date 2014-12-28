package soluciones3f.loki

class Project {
    String name
    String status

    // Date dateCreated
    Date lastUpdated

    // static belongsTo = [ customer: Customer ]

    static constraints = {
    }

    static mapping = {
      // mapping to legacy schema
      table 'proyecto'
      name column: 'nombre'
      status column: 'estado'
    }
}

package soluciones3f.loki
import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes="id")
class Project {
    long id;
    String name
    String status
    String color = "0" // legacy field, but required nonetheless

    // Date dateCreated
    Date lastUpdated

    // static belongsTo = [ customer: Customer ]

    static constraints = {
      id()
      name blank: false
      status inList: ['activo', 'inactivo', 'suspendido']
      color display: false
    }

    static mapping = {
      // mapping to legacy schema
      table 'proyecto'
      name column: 'nombre'
      status column: 'estado'
      color column: 'color'
    }
}

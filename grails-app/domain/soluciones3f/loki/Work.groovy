package soluciones3f.loki

/**
 * Amount of work done on a project.
 */
class Work {
    Date date
    int hours
    int adjustedHours

    Project project
    long idUser

    Date dateCreated
    Date lastUpdated

    static mapping = {
      // mapping to legacy schema
      table 'carga_horaria'
      date column: 'fecha'
      hours column: 'horas'
      project column: 'proyecto_id'
      idUser column: 'usuario_id'
      adjustedHours column: 'horas_ajustadas'
    }

    String toString() {
        "[Work: ${id} (${date.format("dd-MM-yyyy")}, ${project.name}, ${hours})]"
    }
}
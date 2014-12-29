package soluciones3f.loki

/**
 * Given days off
 */
class PublicHoliday {
	long id // without this field, automatic scaffolding does not work
    Date date

    static mapping = {
      // mapping to legacy schema
      table 'feriado'
      date column: 'fecha'
    }

    String toString() {
        "[PublicHoliday: ${id} (${date.format("dd-MM-yyyy")}})]"
    }
}
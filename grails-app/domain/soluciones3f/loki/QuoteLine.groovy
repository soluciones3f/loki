package soluciones3f.loki

class QuoteLine {
    String description

    double amount
    Currency currency

    Date dateCreated
    Date lastUpdated

    static belongsTo = [ customer: Customer ]

    static hasMany = [ transactions: Transaction ]

    static constraints = {

    }

    def beforeInsert() {

    }
}

package soluciones3f.loki

class Customer {

    String name
    String email
    String VAT
    String address

    Date dateCreated
    Date lastUpdated

    static hasMany = [ quoteLines: QuoteLine, transactions: Transaction ]

    static constraints = {

    }
}

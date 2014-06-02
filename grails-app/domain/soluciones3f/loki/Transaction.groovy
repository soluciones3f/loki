package soluciones3f.loki

class Transaction {

    double amount
    Currency currency

    // conversion rate for international currency so it can be converted to local currency
    // if aplies
    // @see convertedAmount() method for more info
    double rate

    Date dateCreated
    Date lastUpdated

    static belongsTo = [ customer : Customer ]

    static hasOne = [ quoteLine: QuoteLine ]

    static constraints = {

    }

    double convertedAmount() {
        if (rate == 0)
            amount
        else
            amount * rate;
    }
}

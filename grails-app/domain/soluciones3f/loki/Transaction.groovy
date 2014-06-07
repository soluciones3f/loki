package soluciones3f.loki

class Transaction {
    def transactionService

    double amount
    Currency currency

    // conversion rate for international currency so it can be converted to local currency
    // if aplies
    // @see convertedAmount() method for more info
    double rate

    TransactionType type // define the type of the transaction
    Long parentId

    Date dateCreated
    Date lastUpdated

    static belongsTo = [ customer : Customer ]

    static hasOne = [ quoteLine: QuoteLine ]

    static constraints = {
        parentId nullable: true
    }

    double convertedAmount() {
        if (rate == 0)
            amount
        else
            amount * rate;
    }
}

// natural flow for transactions
// approve -> wip -> delivered -> invoiced -> paid
// approve -> wip -> delivered (partially) -> invoiced (partially) -> paid
public enum TransactionType { APPROVED, WIP, DELIVERED, INVOICED, PAID }

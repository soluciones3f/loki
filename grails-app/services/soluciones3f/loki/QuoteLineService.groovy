package soluciones3f.loki

import grails.transaction.Transactional

@Transactional
class QuoteLineService {

    def create() {

    }

    def aprove(QuoteLine ql) {

        def t = new Transaction(
                quoteLine: ql,
                currency: ql.currency,
                amount: ql.amount,
                customer: ql.customer,
                type: TransactionType.APPROVED
        )
        t.save()
    }
}

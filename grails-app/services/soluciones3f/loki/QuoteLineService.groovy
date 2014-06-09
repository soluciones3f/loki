package soluciones3f.loki

import grails.transaction.Transactional
import soluciones3f.loki.core.*

@Transactional
class QuoteLineService {

    def create(data) {
        Customer cus = Customer.get(data.customer.id)

        def ql = new QuoteLine(customer: cus)
        ql.amount = data.amount.toDouble()
        ql.currency = Currency.getInstance(data.currency)
        ql.description = data.description

        ql.save()
    }

    def aprove(QuoteLine ql) {
        log.debug("will aprove for ${ql.id}")
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

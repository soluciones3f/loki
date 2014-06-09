package soluciones3f.loki

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteLineService)
@Mock([Transaction, QuoteLine, Customer, QuoteLineService])
class QuoteLineServiceSpec extends Specification {
    def customer = null

    def setup() {
        customer = TestFixtures.createStdCus().save()
    }

    def cleanup() {
    }

    void "save quote"() {
        when: 'quote data'
            def data = [:]
            data.customer = [ id: customer.id ]
            data.currency = "EUR"
            data.amount = 100f
            data.description = "this is a description"

            service.create(data)

        then: 'verifiy quote creation'
            QuoteLine.list().size == 1
            def ql = QuoteLine.list()[0]
            ql.customer.id == customer.id
            ql.currency == Currency.getInstance("EUR")
            ql.amount == 100f
            ql.description == "this is a description"

    }

    void "test aproval of quote"() {
        when: 'aprove quote'
            def q = new QuoteLine()
            q.currency = Currency.getInstance("EUR")
            q.amount = 100
            q.description = "This is a test quote"
            q.customer = customer
            q.save()

            service.aprove(q)

        then: 'verify transaction creation'
            Transaction.list().size() == 1


    }
}

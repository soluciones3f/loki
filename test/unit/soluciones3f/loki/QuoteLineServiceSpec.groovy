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

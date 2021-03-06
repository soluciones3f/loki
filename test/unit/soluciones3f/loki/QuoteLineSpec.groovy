package soluciones3f.loki

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(QuoteLine)
@Mock([Transaction, QuoteLine, Customer])
class QuoteLineSpec extends Specification {
    def customer = null

    def setup() {
        customer = TestFixtures.createStdCus().save()
    }

    def cleanup() {
    }

    void "test transaction due to QuoteLine"() {

        when: 'save quote'
            log.info "save quote"
            def q = new QuoteLine()
            q.currency = Currency.getInstance("EUR")
            q.amount = 100
            q.description = "This is a test quote"
            q.customer = customer
            q.save()



        then: 'verify transaction creation'
            QuoteLine.list().size() == 1

    }
}
package soluciones3f.loki

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Transaction)
class TransactionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "save transaction for quote"() {
        when:
            Transaction tr = new Transaction()

        then: 'verify status'
            // log.info tr.validate()

    }
}

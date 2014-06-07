package soluciones3f.loki

import grails.transaction.Transactional

@Transactional
class TransactionService {

    def aprove(Transaction t) {
        log.error("aprove")
    }

    def reject(Transaction t) {
        log.error("reject")

    }

    def reduce(Transaction t) {
        log.error("reduce")

    }

    def invoice(Transaction t) {
        log.error("invoice")

    }

    def invoicePartial(Transaction t) {
        log.error("invoicePartial")
    }
}

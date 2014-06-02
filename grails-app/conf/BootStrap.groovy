import soluciones3f.loki.*

class BootStrap {

    def init = { servletContext ->
        def cus1 = new Customer(
                name: "Brenda & Brandon",
                address: "90210 Beverly Hills, CA",
                VAT:"223456711",
                email: "bb@spelling.tv"
        ).save()

        def cus2 = new Customer(
                name: "Amanda Woodward",
                address: "4616 Greenwood Place, Los Feliz, Los Angeles, California, USA",
                VAT:"441656711",
                email: "amanda@spelling.tv"
        ).save()

        new QuoteLine(
                description: "Something that the customer really needs",
                amount: 1000,
                currency: Currency.getInstance("EUR"),
                customer: cus1
        )

    }
    def destroy = {
    }
}

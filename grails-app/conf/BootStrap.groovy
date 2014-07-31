import soluciones3f.loki.*
import soluciones3f.loki.auth.Role
import soluciones3f.loki.auth.User
import soluciones3f.loki.auth.UserRole

class BootStrap {
    public static createStdCus() {
        def cus1 = new Customer(
                name: "Brenda & Brandon",
                address: "90210 Beverly Hills, CA",
                VAT:"223456711",
                email: "bb@spelling.tv"
        )
        return cus1;
    }

    def init = { servletContext ->
        def cus1 = createStdCus().save()

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
        ).save()

        User user = new User(username: "test@test.com", password: "12345678")
        user.save()

        Role roleUser = new Role(authority: "ROLE_USER")
        roleUser.save()

        new UserRole(user: user, role: roleUser).save()

    }

    def destroy = {
    }
}

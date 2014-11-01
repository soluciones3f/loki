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

    public void bootstrapData() {
        def cus1 = createStdCus().save()

        def cus2 = new Customer(
                name: "Amanda Woodward",
                address: "4616 Greenwood Place, Los Feliz, Los Angeles, California, USA",
                VAT:"441656711",
                email: "amanda@spelling.tv"
        ).save()

        // TODO: Create dummy data only if it does not exists.
        /*
        def proj1 = new Project(
            name: "Project1-Cust1",
            customer: cus1
        ).save()

        def proj2 = new Project(
                name: "Project2-Cust1",
                customer: cus1
        ).save()

        def proj3 = new Project(
                name: "Project3-Cust2",
                customer: cus2
        ).save()
        */

        new QuoteLine(
                description: "Something that the customer really needs",
                amount: 1000,
                currency: Currency.getInstance("EUR"),
                customer: cus1
        ).save()
    }

    def init = { servletContext ->
        bootstrapData()

        User user = new User(username: "test@test.com", password: "12345678")
        user.save()

        Role roleUser = new Role(authority: "ROLE_USER")
        roleUser.save()

        new UserRole(user: user, role: roleUser).save()

    }

    def destroy = {
    }
}

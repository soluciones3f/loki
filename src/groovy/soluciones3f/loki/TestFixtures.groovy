package soluciones3f.loki

/**
 * Created by fafa on 07/06/14.
 */
class TestFixtures {
    public static createStdCus() {
        def cus1 = new Customer(
                name: "Brenda & Brandon",
                address: "90210 Beverly Hills, CA",
                VAT:"223456711",
                email: "bb@spelling.tv"
        )
        return cus1;
    }
}

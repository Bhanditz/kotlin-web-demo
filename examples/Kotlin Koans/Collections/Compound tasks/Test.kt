import org.junit.Assert
import org.junit.Test as test

class K_Compound_Tasks {

    @test fun testMostExpensiveDeliveredProduct() {
        val testShop = shop("test shop for 'most expensive delivered product'",
                customer(lucas, Canberra,
                        order(isDelivered = false, products = idea),
                        order(reSharper)
                )
        )
        Assert.assertEquals(reSharper, testShop.customers[0].getMostExpensiveDeliveredProduct())
    }

    @test fun testNumberOfTimesEachProductWasOrdered() {
        Assert.assertEquals(3, shop.getNumberOfTimesProductWasOrdered(reSharper))
    }
}

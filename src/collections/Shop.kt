package collections

data class City(val name: String) {
    override fun toString() = name
}

data class Product(val name: String, val price: Double) {
    override fun toString() = "'$name' for '$price'"
}

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}

data class Shop(val name: String, val customers: List<Customer>)

//Return set of customers
fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()

//Return the set of cities the customers are from
fun Shop.getCitiesOfCustomers(): Set<City> = customers.map { it.city }.toSet()

//Return a list of customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = customers.filter { it.city == city }

//Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all { it.city == city }

//Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = customers.any { it.city == city }

//Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = customers.count { it.city == city }

//Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.find { it.city == city }

//Return all products this customer has ordered
val Customer.orderedProducts: Set<Product> get() {
    return orders.flatMap {
        it.products
    }.toSet()
}

//Return all products that were ordered by at least one customer
val Shop.allOrderedProducts: Set<Product> get() {
    return customers.flatMap {
        it.orderedProducts
    }.toSet()
}

//Return a customer whose order count is the highest among all customers
//Others: max, min, maxBy, minBy
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = customers.maxBy { it.orders.size }

//Return the most expensive product which has been ordered
//Others: max, min, maxBy, minBy
fun Customer.getMostExpensiveOrderedProduct(): Product? = orders.flatMap { it.products }.maxBy { it.price }

//Return a list of customers, sorted by the ascending number of orders they made
//Others: sorted
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = customers.sortedBy { it.orders.size }

//Return the sum of prices of all products that a customer has ordered
//Note: the customer may order the same product for several times.
//Others: sumBy, sum
fun Customer.getTotalOrderPrice(): Double = orders.flatMap { it.products }.sumByDouble { it.price }

//Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }

//Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    /*val (a, _) = customers.partition { it.orders.filter { it.isDelivered.not() }.count() > it.orders.filter { it.isDelivered }.count() }
    return a.toSet()*/ //<- My solution
    return customers.filter {
        val (delivered, undelivered) = it.orders.partition { it.isDelivered }
        delivered.size < undelivered.size
    }.toSet()
}

//Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val allProducts = customers.flatMap { it.orders.flatMap { it.products } }.toSet()
    return customers.fold(allProducts) { orderedByAll, customer -> orderedByAll.intersect(customer.orders.flatMap { it.products }.toSet())
    }
}

//Return the most expensive product among all delivered products (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

//Return how many times the given product was ordered.
//Note: a customer may order the same product several times.
fun Shop.getNumberOfTimesAProductWasOrdered(product: Product): Int {
    return customers.fold(0) { numberOfTimesOrdered, customer -> numberOfTimesOrdered + customer.orders.flatMap { it.products.filter { it.name == product.name } }.count() }
}

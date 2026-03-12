package basics

/*
Single Responsibility - A class should have only one role or responsibility
 */

// Bad Design

class OrderService {

    fun createOrder() {
        validateOrder()
        saveOrder()
        updateInventory()
        sendNotification()
        generateInvoice()
    }

    private fun validateOrder() {
        println("Validating order")
    }

    private fun saveOrder() {
        println("Saving order to DB")
    }

    private fun updateInventory() {
        println("Updating stock")
    }

    private fun sendNotification() {
        println("Sending order confirmation")
    }

    private fun generateInvoice() {
        println("Generating invoice")
    }
}

// Good design - Split the responsibilities

class OrderValidator {
    fun validate() {
        println("Validating order")
    }
}

class OrderRepository {
    fun save() {
        println("Saving order")
    }
}

class InventoryService {
    fun updateStock() {
        println("Updating inventory")
    }
}

class NotificationService {
    fun sendOrderConfirmation() {
        println("Sending notification")
    }
}

class InvoiceService {
    fun generate() {
        println("Generating invoice")
    }
}

// Coordinator

class OrderCoordinator(
    private val validator: OrderValidator,
    private val repository: OrderRepository,
    private val inventory: InventoryService,
    private val notification: NotificationService,
    private val invoice: InvoiceService
) {

    fun createOrder() {
        validator.validate()
        repository.save()
        inventory.updateStock()
        notification.sendOrderConfirmation()
        invoice.generate()
    }
}



/* Open - Closed Principle
Closed for modification
Open for extension
Key: Adding a new behaviour without changing the old code
 */

class GSTCalculator{
    fun calculatePrice(product: String)  : Number {
        return when(product){
            "BISCUIT" -> 0.18
            "MEDICINE" -> 0
            "CHOCOLATE" -> 0.15
            "MASALAS" -> 0.05
            "CIGARETTES" -> 0.40
            else -> 0.10
        }
    }
}

// Now what if new category is added over here
// We need to add "NEW1" -> 0.04 .... so on
// Disadvantages: Giant If else chain, Risk of breaking billing logic, Every new features modifies old code


// Fix: Use Interface

interface  GST {
    fun calculatePrice(price: Double): Number
}

class BiscuitGST : GST {
    override fun calculatePrice(price: Double): Number {
        return price * 0.18
    }
}

class MedicineGST : GST {
    override fun calculatePrice(price: Double): Number {
        return price * 0
    }
}

class ChocolateGST : GST {
    override fun calculatePrice(price: Double): Number {
        return price * 0.15
    }
}
// The logic can be extended using the interface


// Actual business logic - Closed for modification
class GSTBiller(private val gst: GST) {
    fun generateGSTBill(price: Double): Double {
        return price + gst.calculatePrice(price).toDouble()
    }
}

// Actual Usage
fun main() {

    val biscuitGST = BiscuitGST()
    val biller = GSTBiller(biscuitGST)

    val finalPrice = biller.generateGSTBill(100.0)

    println(finalPrice)
}


/* L -> Liskov Substitution Principle
Object of a superclass must be replaceable with the objects of the subclass without breaking the program
If B extends A, then B must BEHAVE LIKE A
If swapping the subclass changes expected behavior, the design is wrong
 */


open class Bird {
    open fun fly() {
        println("Flying")
    }
}

class Sparrow : Bird()

class Penguin : Bird() {
    override fun fly() {
        throw UnsupportedOperationException("Penguins cannot fly")
    }
}

fun makeBirdFly(bird: Bird) {
    bird.fly()
}

// This works
// makeBirdFly(Sparrow())

// But this will throw error
// makeBirdFly(Penguin())

// Subclass cannot substitute the parent.




/* 4 - I -> Interface Segregation Principle
Clients should not be forced to depend on interfaces they do not use
Don’t make big interfaces.
Split them into smaller ones.
 */

// Bad design

interface ProductOperations {

    fun calculateGST(price: Double): Double

    fun applyDiscount(price: Double): Double

    fun printLabel()

    fun syncToServer()

    fun generateBarcode()
}

// Good design

interface GSTApplicable {
    fun calculateGST(price: Double): Double
}

interface Discountable {
    fun applyDiscount(price: Double): Double
}

interface LabelPrintable {
    fun printLabel()
}

interface Syncable {
    fun syncToServer()
}

interface BarcodeGeneratable {
    fun generateBarcode()
}

class BiscuitProduct : GSTApplicable, Discountable {

    override fun calculateGST(price: Double) = price * 0.18

    override fun applyDiscount(price: Double) = price * 0.9
}

class WarehouseProduct :
    GSTApplicable, BarcodeGeneratable,
    Syncable {

    override fun calculateGST(price: Double) = price * 0.05

    override fun generateBarcode() {
        println("Barcode generated")
    }

    override fun syncToServer() {
        println("Synced")
    }
}

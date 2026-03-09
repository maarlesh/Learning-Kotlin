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





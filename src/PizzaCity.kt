abstract class PizzaCity (
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0
    private var checkPhotoCount = 0
    private var noCheckPhotoCount = 0
    private var coffeeCount = 0
    private var noCoffeeCount = 0
    private var totalDiscount = 0.0
    private var coffeeRevenue = 0.0
    private var sauce1Count = 0
    private var sauce2Count = 0
    private var sauce1Revenue = 0.0
    private var sauce2Revenue = 0.0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun trackCheckPhoto(hasCheck: Boolean) {
        if (hasCheck) {
            checkPhotoCount++
            totalDiscount += 50 // Assuming a flat 50 currency discount
        } else {
            noCheckPhotoCount++
        }
    }

    fun trackCoffeePurchase(wantsCoffee: Boolean) {
        if (wantsCoffee) {
            coffeeCount++
            coffeeRevenue += 200 // Assuming coffee costs 200 currency units
        } else {
            noCoffeeCount++
        }
    }

    fun trackSaucePurchase(sauceType: Int) {
        if (sauceType == 1) {
            sauce1Count++
            sauce1Revenue += 20 // Set sauce 1 price
        } else if (sauceType == 2) {
            sauce2Count++
            sauce2Revenue += 25 // Set sauce 2 price
        }
    }

    open fun showStatistics() {
        println("Статистика продаж:")
        println("Неаполитанская пицца. Продажи: $neapolitanPizzaCount")
        println("Римская пицца. Продажи: $romanPizzaCount")
        println("Сицилийская пицца. Продажи: $sicilianPizzaCount")
        println("Тирольская пицца. Продажи: $tyroleanPizzaCount")

        val totalPizzaRevenue = (neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice)

        val totalRevenue = totalPizzaRevenue + coffeeRevenue + sauce1Revenue + sauce2Revenue - totalDiscount
        println("Общая выручка (Включая кофе, соусы и скидки): $totalRevenue")

        val checkPhotoPercent = (checkPhotoCount.toDouble() / (checkPhotoCount + noCheckPhotoCount) * 100).takeIf { checkPhotoCount + noCheckPhotoCount > 0 } ?: 0.0
        println("Процент предоставленных фото чеков: $checkPhotoPercent%")

        val coffeePurchasePercent = (coffeeCount.toDouble() / (coffeeCount + noCoffeeCount) * 100).takeIf { coffeeCount + noCoffeeCount > 0 } ?: 0.0
        println("Процент покупки кофе: $coffeePurchasePercent%")

        if (sauce1Count + sauce2Count > 0) {
            println("Продано сырных соусов: $sauce1Count ($sauce1Revenue in revenue)")
            println("Продано чесночных соусов: $sauce2Count ($sauce2Revenue in revenue)")
        }
    }
}
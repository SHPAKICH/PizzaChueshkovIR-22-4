class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice), Drink {

    override fun drinkSale() {
        println("Желаете кофе (1: Да, 2: Нет)")
        val wantsCoffee = readln() == "1"
        if (wantsCoffee) println("Кофе обошёлся в 200 рублей..............")
        trackCoffeePurchase(wantsCoffee)
    }

    override fun neapolitanPizzaSale() { neapolitanPizzaCount++; println("Спасибо за покупку неаполитанской пиццы в Новгороде") }
    override fun romanPizzaSale() { romanPizzaCount++; println("Спасибо за покупку римской пиццы в Новгороде") }
    override fun sicilianPizzaSale() { sicilianPizzaCount++; println("Спасибо за покупку сицилийской пиццы в Новгороде") }
    override fun tyroleanPizzaSale() { tyroleanPizzaCount++; println("Спасибо за покупку тирольской пиццы в Новгороде") }
}
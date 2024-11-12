class PizzaNovgorod(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice), CheckPhoto, Drink {

    override fun showCheckPhoto() {
        println("У вас есть фото чека? (1: Да, 2: Нет)")
        val hasCheck = readln() == "1"
        if (hasCheck) println("YВы получаете скидку в размере 50 рублей! =)")
        trackCheckPhoto(hasCheck)
    }

    override fun drinkSale() {
        println("Желаете кофе? (1: Да, 2: Нет)")
        val wantsCoffee = readln() == "1"
        if (wantsCoffee) println("Кофе обошёлся в 200 рублей..........")
        trackCoffeePurchase(wantsCoffee)
    }

    fun selectSauce() {
        println("Выберите соус: 1. Сырный (20 рублей), 2. Чесночный (25 рублей)")
        val sauceChoice = readln().toIntOrNull()
        if (sauceChoice == 1 || sauceChoice == 2) {
            trackSaucePurchase(sauceChoice)
        }
    }

    override fun neapolitanPizzaSale() { neapolitanPizzaCount++; println("Спасибо за покупку неаполитанской пиццы в Новгороде"); selectSauce() }
    override fun romanPizzaSale() { romanPizzaCount++; println("Спасибо за покупку римской пиццы в Новгороде"); selectSauce() }
    override fun sicilianPizzaSale() { sicilianPizzaCount++; println("Спасибо за покупку сицилийской пиццы в Новгороде"); selectSauce() }
    override fun tyroleanPizzaSale() { tyroleanPizzaCount++; println("TСпасибо за покупку тирольской пиццы в Новгороде"); selectSauce() }
}
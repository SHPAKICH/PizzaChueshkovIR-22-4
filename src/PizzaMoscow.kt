class PizzaMoscow(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice), CheckPhoto {

    override fun showCheckPhoto() {
        println("У вас есть фото чека? (1: Да, 2: Нет)")
        val hasCheck = readln() == "1"
        if (hasCheck) println("Вы получаете скидку в размере 50 рублей! =)")
        trackCheckPhoto(hasCheck)
    }

    override fun neapolitanPizzaSale() { neapolitanPizzaCount++; println("Спасибо за покупку неаполитанской пиццы в Москве") }
    override fun romanPizzaSale() { romanPizzaCount++; println("Спасибо за покупку римской пиццы в Москве") }
    override fun sicilianPizzaSale() { sicilianPizzaCount++; println("Спасибо за покупку сицилийской пиццы в Москве") }
    override fun tyroleanPizzaSale() { tyroleanPizzaCount++; println("Спасибо за покупку тирольской пиццы в Москве") }
}
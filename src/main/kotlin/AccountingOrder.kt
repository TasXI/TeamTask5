import  Goods
import  Warehouse
class AccountingOrder (var warehouse: Warehouse) {

    fun showGoods(): String
    {
        var result: String = ""
        for ((id, goods) in warehouse.getValues())
        {
            result += String.format("%08d||name: %s price: %f quantity: %d\n",id, goods.name, goods.price, goods.quantity)
        }
        return result
    }

    fun order(goods: Map<Int, Int>): String{
        val ex = warehouse.getValues()
        for ((id, quantity) in goods)
        {
            val ex2 = ex[id]
            if (ex2 == null || ex2.quantity < quantity)
            {
                return "Unable to make a purchase!\nYou have entered an invalid id or ordered more items than are in stock"
            }
        }

        val total: MutableMap<Int, Int> = mutableMapOf()

        for ((id, quantity) in goods) {
            val exPrice = ex[id]
            if (exPrice != null) {
                total[id] = quantity
                warehouse.removeGoods(id, quantity)
            }
        }

        var totalText = "your order:\n"
        var priceOfPurchase = 0.0
        for ((id, pr) in total){
            val ex2 = ex[id]
            if (ex2 != null) {
                totalText += String.format(
                    "%08d||name: %s quantity: %d total price: %f\n",
                    id, ex2.name, pr, ex2.price * pr
                )
            priceOfPurchase += ex2.price * pr
            }
        }
        totalText += "the price of the purchase: $priceOfPurchase"
        return totalText

    }
}
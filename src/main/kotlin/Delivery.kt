import  Goods
import  Warehouse
class Delivery {
    private val items: MutableMap<Int, Int> = mutableMapOf()

    fun addItem(id: Int, quantity: Int) {
        items[id] = quantity
    }

    fun goDelivery(warehouse: Warehouse): String {
        for ((id, quantity) in items) {
            if (warehouse.getValues()[id] != null){
                warehouse.addProductQuantity(id, quantity)
            }
            else
            {
                warehouse.addGoods(Goods(id, "Unknown", 0.0, quantity))
            }
        }
        return "Delivery was successful!"
    }
}
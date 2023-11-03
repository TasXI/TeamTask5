class Warehouse(val name: String) {
    private val inventory: MutableMap<Int, Goods> = mutableMapOf()
    fun addGoods(goods: Goods) {
        inventory[goods.id] = goods
    }
    fun addProductQuantity(id: Int, quantity: Int)
    {
        val ex = inventory[id]
        if(ex != null)
        {
            ex.quantity += quantity;
        }
    }



    fun removeGoods(Id: Int, quantity: Int) {
        val ex = inventory[Id]
        if (ex != null) {
            if (ex.quantity >= quantity) {
                ex.quantity -= quantity
            }
        }
    }

    fun fullRemoveGoods(Id: Int) {
        val ex = inventory[Id]
        if (ex != null) {
            inventory.remove(Id)
        }
    }

    fun  setGoodsName(id: Int,name: String){
        val ex = inventory[id];
        if(ex != null){
            ex.name = name
        }
    }

    fun setGoodsPrice(id: Int,price: Double)
    {
        val ex = inventory[id];
        if(ex != null){
            ex.price = price
        }
    }

    fun getValues(): Map<Int, Goods>  {
        return inventory.toSortedMap(compareBy<Int> { it })
    }

}
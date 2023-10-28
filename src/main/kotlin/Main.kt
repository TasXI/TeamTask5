fun main(args: Array<String>) {
    /*
    val warehouse = Warehouse("name1")
    warehouse.addGoods(Goods(0, "Computer", 100.0, 20))
    warehouse.addGoods(Goods(1, "Keyboard", 200.0, 10))
    warehouse.addGoods(Goods(2, "Mouse", 250.0, 30))
    warehouse.addGoods(Goods(3, "Screen", 3400.0, 5))

    val acor = AccountingOrder(warehouse)

    println(acor.showGoods())

    val map = mutableMapOf<Int,Int>()
    map[0] = 15
    map[1] = 5
    map[2] = 30
    map[3] = 0
    println(acor.order(map.toMap()))

    println(acor.showGoods())

    val delivery = Delivery()

    delivery.addItem(0, 50)
    delivery.addItem(1, 60)
    delivery.addItem(2, 20)
    delivery.addItem(3, 10)
    delivery.addItem(4, 45)
    println(delivery.goDelivery(warehouse))

    println(acor.showGoods())

    */

    val warehouseClient = Warehouse("Client")
    val deliveryClient = Delivery()
    val accountingOrderClient = AccountingOrder(warehouseClient)

    while (true) {
        println("Select an action:")
        println("1 - Add item to the list of products/Change product by id.")
        println("2 - Remove product.")
        println("3 - Delivery of goods.")
        println("4 - Order goods.")
        println("5 - Show products.")
        when (readLine()) {
            "1" -> {
                var id = 0
                var name = ""
                var price = 0.0
                println("Enter the parameters.")
                print("id: ")
                try {
                    id = readLine()!!.toInt()
                    print("name: ")
                    name = readLine().toString()
                    print("price: ")
                    price = readLine()!!.toDouble()

                    warehouseClient.addGoods(Goods(id, name, price, 0))
                    println("Success!")
                } catch (ex: Exception) {
                    println("Failure!")
                }

            }
            "2" -> {
                try {
                    var id = -1
                    println("Enter the id.")
                    print("id: ")
                    id = readLine()!!.toInt()
                    warehouseClient.fullRemoveGoods(id)
                    println("Success!")
                }
                catch (ex :Exception){
                    println("Failure!")
                }

            }
            "3" -> {
                println(accountingOrderClient.showGoods())
                while (true){
                    println("1 - Add product.")
                    println("2 - finalize delivery.")
                    when(readLine()){
                        "1" -> {
                            try {
                                var id = -1
                                var quantity = -1
                                println("Enter id and quantity.")
                                print("id: ")
                                id = readLine()!!.toInt()
                                print("quantity: ")
                                quantity = readLine()!!.toInt()
                                deliveryClient.addItem(id, quantity)
                            }
                            catch (ex: Exception){
                                println("Failure!")
                            }
                        }
                        "2" -> {
                            try {
                                deliveryClient.goDelivery(warehouseClient)
                                println("Go delivery successful!")
                                break
                            }
                            catch (ex: Exception){
                                println("Failure!")
                            }

                        }
                        else -> {
                            println("A nonexistent action has been selected! Try again.")
                        }
                    }


                }
            }
            "4" -> {
                val buyGoods = mutableMapOf<Int, Int>()
                println("Available products to buy:")
                println(accountingOrderClient.showGoods())

                while (true) {
                    println("1 - Add product.")
                    println("2 - finalize buy.")
                    when (readLine()) {
                        "1" -> {
                            try {
                                var id = -1
                                var quantity = -1
                                print("id: ")
                                id = readLine()!!.toInt()
                                print("quantity: ")
                                quantity = readLine()!!.toInt()
                                buyGoods[id] = quantity
                            }
                            catch (ex:Exception){
                                println("Failure!")
                            }
                        }
                        "2" -> {
                            println(accountingOrderClient.order(buyGoods.toSortedMap()))
                            break
                        }
                        else -> {
                            println("A nonexistent action has been selected! Try again.")
                        }
                    }
                }
            }
            "5" -> {
                println(accountingOrderClient.showGoods())
            }
            else -> {
                println("A nonexistent action has been selected! Try again.")
            }
        }
    }
}
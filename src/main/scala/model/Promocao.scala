package model

object Promocao {

  // Funcao para alterar valor de preco atual por um valor com desconto
  def promover(): String = {
    println(Cardapio.cardapio())
    val id = scala.io.StdIn.readLine("Promover ID: ")
    val cardapio = FileIO.ler("menu.txt","").split("@")
    var produtos = ""
    for (i <- 0 to cardapio.length - 1) {
      var itens = cardapio(i).split("#")
      if (id != itens(0)) {
        produtos = produtos + itens(0) + "#" + itens(1) + "#" + itens(2) + "#" + itens(3) + "@"
      }
      if (id == itens(0)) {
        val input = scala.io.StdIn.readLine("Promocao: ")
        produtos = produtos + itens(0) + "#" + itens(1) + "#" + itens(2) + "#" + input+"*"+ "@"
      }
    }
  FileIO.subescrever("menu.txt", produtos)
  return "Item promovido!"
  }
}
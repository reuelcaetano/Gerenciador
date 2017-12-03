package model

object Promocao {

  // Funcao para alterar valor de preco atual por um valor com desconto
  def promover(cardapio: Array[String]): String = {
    // imprime o cardápio
    Cardapio.cardapio(cardapio)
    val id = scala.io.StdIn.readLine("ID do produto a ser promovido: ")
    if (Cadastro.existeProduto(cardapio, id)) {
      var produtos = ""
      cardapio.foreach { e =>
        if (e.split("#")(0) != id) {
          produtos += (e + "@")
        } else {
          val data = e.split("#")
          val input = scala.io.StdIn.readLine("Novo preço promocional: ")
          produtos = produtos + data(0) + "#" + data(1) + "#" + data(2) + "#" + input + "*@"
        }
      }
      FileIO.subescrever("menu.txt", produtos)
      return "Item promovido!"
    } else {
      return "ID informado não existe"
    }
  }
}

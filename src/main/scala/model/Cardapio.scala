package model

object Cardapio {

  // Exibe cardapio de itens cadastrados
  def cardapio() : String = {
      val cardapio = FileIO.ler("menu.txt","").split("@")
      var produtos = ""
      if (cardapio(0) != "") {
        for (i <- 0 to cardapio.length - 1) {
          var itens = cardapio(i).split("#")
          produtos = produtos + "ID:" + itens(0) + " " + itens(1).toUpperCase + " [" + itens(2).toUpperCase + "]" + " R$" + itens(3) + "\n"
        }
        return "\n[CARDAPIO]\n----------------------------\n" + produtos
      }
      return "Cardapio vazio!"
    }

  // Retorna quantidade total de produtos cadastrados
  def totalProdutos() : Int = {
      val cardapio = FileIO.ler("menu.txt","").split("@")
      return cardapio.length
  }
}
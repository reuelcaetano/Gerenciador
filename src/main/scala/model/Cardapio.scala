package model

import scala.annotation.tailrec

object Cardapio {

  // Exibe cardapio de itens cadastrados
  def cardapio(cardapio: Array[String]): Unit = {
    println("\n[CARDÁPIO]\n----------------------------")
    cardapio.foreach(e => println(criaProduto(e)))
    println("* Preço promocional por tempo limitado\n----------------------------")
  }

  // formata os dados para exibição de um produto
  def criaProduto(produtoTxt: String): String = {
    var produto = produtoTxt.split("#")
    return "ID: " + produto(0) + ", " + produto(1).toUpperCase + " [" + produto(2) + "], R$ " + produto(3)
  }
}

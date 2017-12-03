package model

import java.util.GregorianCalendar

object Pedido {

  // Funcao para criar um novo pedido ou cancelar um pedido existente
  def pedido(): String = {
    val input = scala.io.StdIn.readLine("[0] Novo Pedido | [1] Cancelar Pedido: ")
    input match {
      case "0" =>
        val cardapio = FileIO.ler("menu.txt", "").split("@")
        val id = FileIO.ler("pedidoID.txt", "1")
        novoPedido(cardapio, id)
      case "1" =>
        val pedidos = FileIO.ler("pedido.txt", "").split("@")
        cancelarPedido(pedidos)
    }
  }

  // Funcao para efetuar um novo pedido
  def novoPedido(cardapio: Array[String], id: String): String = {
    //imprime o cardápio
    Cardapio.cardapio(cardapio)
    val produto = scala.io.StdIn.readLine("ID do produto: ")
    // verifica se o produto existe
    if (Cadastro.existeProduto(cardapio, produto)) {
      val quant = scala.io.StdIn.readLine("Quantidade: ")
      FileIO.escrever("pedido.txt", id + "#" + new GregorianCalendar().getTime.toString + "#" + quant + " x " + Cadastro.getProduto(cardapio, produto) + "@")
      FileIO.subescrever("pedidoID.txt", (id.toInt + 1).toString)
      return "Pedido realizado com sucesso!"
    } else {
      return "ID informado não existe."
    }
  }

  // Funcao para cancelar pedido cadastrado
  def cancelarPedido(pedidos: Array[String]): String = {
    // mostra os pedidos cadastrados
    println(Relatorio.visualizar(pedidos))
    val id = scala.io.StdIn.readLine("Número do pedido a ser cancelado: ")
    if (Cadastro.existeProduto(pedidos, id)) {
      var lista = ""
      pedidos.foreach { e =>
        if (e.split("#")(0) != id) lista += (e + "@")
      }
      FileIO.subescrever("pedido.txt", lista)
      return "Pedido cancelado com sucesso!"
    } else {
      return "Numero do pedido não existe."
    }
  }
}

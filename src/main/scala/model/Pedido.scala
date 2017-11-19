package model

import java.util.GregorianCalendar

object Pedido {

  // Funcao para setar opcao para novoPedido() / cancelarPedido()
  def pedido() : String = {
    val input = scala.io.StdIn.readLine("[0] Novo Pedido | [1] Cancelar Pedido: ")
    input match {
      case "0" => novoPedido()
      case "1" => cancelarPedido()
    }
  }

  // Funcao para efetuar um novo pedido
  def novoPedido() : String = {
    println(Cardapio.cardapio())
    val id = FileIO.ler("pedidoID.txt", "1")
    val quant = scala.io.StdIn.readLine("Quantidade: ")
    val sabor = scala.io.StdIn.readLine("Sabor: ")
    val tam = scala.io.StdIn.readLine("Tamanho[P,M,G]: ")
    FileIO.escrever("pedido.txt", id+"#"+new GregorianCalendar().getTime.toString+"#"+quant+"x "+sabor+" ["+tam+"]"+"@")
    FileIO.subescrever("pedidoID.txt", (id.toInt+1).toString)
    return "Pedido realizado com sucesso!"
  }

  // Funcao para cancelar pedido cadastrado
  def cancelarPedido() : String = {
    println(Relatorio.visualizar())
    val id = scala.io.StdIn.readLine("Remover ID: ")
    val pedidos = FileIO.ler("pedido.txt","").split("@")
    var lista = ""
    for (i <- 0 to pedidos.length-1) {
      var itens = pedidos(i).split("#")
      if (id != itens(0)){
        lista = lista+itens(0)+"#"+itens(1)+"#"+itens(2)+"#"+"@"
      }
      FileIO.subescrever("pedido.txt", lista)
    }
    return "Pedido cancelado com sucesso!"
  }
}
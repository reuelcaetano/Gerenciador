package view

import model.{Cardapio, Pedido, Cadastro, Promocao, Relatorio}

object Main {
  def main(args: Array[String]) {
    showMenu()
  }

  def showMenu(): Unit ={
    val input = scala.io.StdIn.readLine("[0] Cardapio | [1] Pedido | [2] Cadastrar | [3] Remover | [4] Alterar | [5] Promocao | [6] Relatorio | [7] Sair: ")
    input match {
      case "0" => println(Cardapio.cardapio())
        showMenu();// Exibe cardapio de itens cadastrados
      case "1" => println(Pedido.pedido())        // Chama opcoes para novoPedido() / cancelarPedido()
        showMenu();
      case "2" => println(Cadastro.cadastrar())   // Cadastra novo produto
        showMenu();
      case "3" => println(Cadastro.remover())     // Remove produto cadastrado
        showMenu();
      case "4" => println(Cadastro.alterar())     // Altera valores especificos de produtos cadastrados
        showMenu();
      case "5" => println(Promocao.promover())    // Altera o preco de um produto para deixa-lo com desconto
        showMenu();
      case "6" => println(Relatorio.visualizar()) // Exibe relatorio de vendas efetuadas
        showMenu();
      case "7" => println("Sistema encerrado com sucesso")
      case _ => println("Comando inválido")
        showMenu()
    }
  }
}

package view

import model._

object Main {
  def main(args: Array[String]) {
    var loop = 1
    while(loop == 1) {
      val input = scala.io.StdIn.readLine("[0] Cardapio | [1] Pedido | [2] Cadastrar | [3] Remover | [4] Alterar | [5] Promocao | [6] Relatorio | [7] Sair: ")
      input match {
        case "0" => println(Cardapio.cardapio())    // Exibe cardapio de itens cadastrados
        case "1" => println(Pedido.pedido())        // Chama opcoes para novoPedido() / cancelarPedido()
        case "2" => println(Cadastro.cadastrar())   // Cadastra novo produto
        case "3" => println(Cadastro.remover())     // Remove produto cadastrado
        case "4" => println(Cadastro.alterar())     // Altera valores especificos de produtos cadastrados
        case "5" => println(Promocao.promover())    // Altera o preco de um produto para deixa-lo com desconto
        case "6" => println(Relatorio.visualizar()) // Exibe relatorio de vendas efetuadas
        case "7" => loop = 0                        // Seta variavel para finalizar loop
      }
    }
  }
}
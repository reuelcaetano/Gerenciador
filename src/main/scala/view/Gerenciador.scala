package view

import model._

object Main {
  def main(args: Array[String]) {
    showMenu()
  }

  def showMenu(): Unit = {
    val input = scala.io.StdIn.readLine("[0] Cardapio | [1] Pedido | [2] Cadastrar | [3] Remover | [4] Alterar | [5] Promocao | [6] Relatorio | [7] Sair\nAção: ")
    input match {
      case "0" =>
        val cardapio = FileIO.ler("menu.txt", "").split("@")
        Cardapio.cardapio(cardapio) // Exibe cardapio de itens cadastrados
        showMenu()
      case "1" =>
        println(Pedido.pedido()) // Chama opcoes para novoPedido() / cancelarPedido()
        showMenu();
      case "2" =>
        val id = FileIO.ler("menuID.txt", "1")
        val sabor = scala.io.StdIn.readLine("Sabor da Pizza: ")
        val tam = scala.io.StdIn.readLine("Tamanho [P,M,G]: ")
        val preco = scala.io.StdIn.readLine("Preço: ")
        println(Cadastro.cadastrar(id, sabor, tam, preco)) // Cadastra novo produto
        showMenu();
      case "3" =>
        val cardapio = FileIO.ler("menu.txt", "").split("@")
        // imprime os produtos cadastrados
        Cardapio.cardapio(cardapio)
        val id = scala.io.StdIn.readLine("ID do produto a ser removido: ")
        println(Cadastro.remover(cardapio, id)) // Remove produto cadastrado
        showMenu();
      case "4" =>
        val cardapio = FileIO.ler("menu.txt", "").split("@")
        // imprime os produtos cadastrados
        Cardapio.cardapio(cardapio)
        val id = scala.io.StdIn.readLine("ID do produto a ser alterado: ")
        println(Cadastro.alterar(cardapio, id)) // Altera valores especificos de produtos cadastrados
        showMenu();
      case "5" =>
        val cardapio = FileIO.ler("menu.txt", "").split("@")
        println(Promocao.promover(cardapio)) // Altera o preco de um produto para deixa-lo com desconto
        showMenu();
      case "6" =>
        val pedidos = FileIO.ler("pedido.txt", "").split("@")
        println(Relatorio.visualizar(pedidos)) // Exibe relatorio de vendas efetuadas
        showMenu();
      case "7" =>
        println("Sistema encerrado com sucesso")
      case _ =>
        println("Comando inválido")
        showMenu()
    }
  }
}

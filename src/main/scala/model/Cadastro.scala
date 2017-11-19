package model

object Cadastro {

  // Funcao para cadastrar um novo produto seguindo o seguinte protocolo:
  // ID#nomeDoSabor#tamanho#preco@
  // ID - gerado automaticamente de forma incremental
  // nomeDoSabor - entrada do usuario
  // tamanho - [P(pequena), M(media), G(grande)]
  // preco - valor em reais com duas casas decimais R$[00.00]
  // @ - caracter especial para reconhecer o final do conjunto de valores associados
  def cadastrar() : String = {
    val id = FileIO.ler("menuID.txt", "1")
    val sabor = scala.io.StdIn.readLine("Sabor: ")
    val tam = scala.io.StdIn.readLine("Tamanho [P,M,G]: ")
    val price = scala.io.StdIn.readLine("Preco: ")
    FileIO.escrever("menu.txt", id+"#"+sabor+"#"+tam+"#"+price+"@")
    FileIO.subescrever("menuID.txt", (id.toInt+1).toString)
    return "Cadastrado realizado!"
  }

  // Funcao para remover um produto por sua ID
  def remover() : String = {
    println(Cardapio.cardapio())
    val id = scala.io.StdIn.readLine("Remover ID: ")
    val cardapio = FileIO.ler("menu.txt","").split("@")
    var produtos = ""
    for (i <- 0 to cardapio.length-1) {
      var itens = cardapio(i).split("#")
      if (id != itens(0)){
        produtos = produtos+itens(0)+"#"+itens(1)+"#"+itens(2)+"#"+itens(3)+"@"
      }
      FileIO.subescrever("menu.txt", produtos)
    }
    return "Item removido!"
  }

  // Funcao para alterar um produto por sua ID
  def alterar() : String = {
    println(Cardapio.cardapio())
      val id = scala.io.StdIn.readLine("Alterar ID: ")
      val cardapio = FileIO.ler("menu.txt","").split("@")
      var produtos = ""
      for (i <- 0 to cardapio.length-1) {
        var itens = cardapio(i).split("#")
        if (id != itens(0)) {
          produtos = produtos+itens(0)+"#"+itens(1)+"#"+itens(2)+"#"+itens(3)+"@"
        }
      if (id == itens(0)){
        val input = scala.io.StdIn.readLine("[0] Alterar Sabor | [1] Alterar Tamanho | [2] Alterar Preco")
        input match {
          case "0" => {
            val sabor = scala.io.StdIn.readLine("Novo Sabor: ")
            produtos = produtos+itens(0)+"#"+sabor+"#"+itens(2)+"#"+itens(3)+"@"
          }
          case "1" => {
            val tamanho = scala.io.StdIn.readLine("Novo Tamanho: ")
            produtos = produtos+itens(0)+"#"+itens(1)+"#"+tamanho+"#"+itens(3)+"@"
          }
          case "2" => {
            val preco = scala.io.StdIn.readLine("Novo Preco: ")
            produtos = produtos+itens(0)+"#"+itens(1)+"#"+itens(2)+"#"+preco+"@"
          }
        }
      }
    }
    FileIO.subescrever("menu.txt", produtos)
    return "Item alterado!"
  }
}
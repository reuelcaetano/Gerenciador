package model

object Cadastro {

  // Funcao para cadastrar um novo produto seguindo o seguinte protocolo:
  // ID#nomeDoSabor#tamanho#preco@
  // ID - gerado automaticamente de forma incremental
  // nomeDoSabor - entrada do usuario
  // tamanho - [P(pequena), M(media), G(grande)]
  // preco - valor em reais com duas casas decimais R$[00.00]
  // @ - caracter especial para reconhecer o final do conjunto de valores associados
  def cadastrar(id: String, sabor: String, tam: String, preco: String): String = {
    FileIO.escrever("menu.txt", id + "#" + sabor + "#" + tam + "#" + preco + "@")
    FileIO.subescrever("menuID.txt", (id.toInt + 1).toString)
    return "Cadastrado realizado!"
  }

  // Funcao para remover um produto por sua ID
  def remover(cardapio: Array[String], id: String): String = {
    if (existeProduto(cardapio, id)) {
      var produtos = ""
      cardapio.foreach { e =>
        if (e.split("#")(0) != id) produtos += (e + "@")
      }
      FileIO.subescrever("menu.txt", produtos)
      return "Item removido!"
    } else {
      return "ID informado não existe"
    }

  }

  // Funcao para alterar um produto por sua ID
  def alterar(cardapio: Array[String], id: String): String = {
    if (existeProduto(cardapio, id)) {
      var produtos = ""
      cardapio.foreach { e =>
        if (e.split("#")(0) != id) {
          produtos += (e + "@")
        } else {
          println("\n" + Cardapio.criaProduto(e))
          val input = scala.io.StdIn.readLine("[0] Alterar Sabor | [1] Alterar Tamanho | [2] Alterar Preço\nAção: ")
          input match {
            case "0" => {
              produtos += alterarSabor(e)
            }
            case "1" => {
              produtos += alterarTamanho(e)
            }
            case "2" => {
              produtos += alterarPreco(e)
            }
          }
        }
      }
      FileIO.subescrever("menu.txt", produtos)
      return "Item alterado!"
    } else {
      return "ID informado não existe"
    }
  }

  def alterarSabor(produto: String): String = {
    val dados = produto.split("#")
    val novo = scala.io.StdIn.readLine("Novo sabor: ")
    return dados(0) + "#" + novo + "#" + dados(2) + "#" + dados(3) + "@"
  }

  def alterarTamanho(produto: String): String = {
    val dados = produto.split("#")
    val novo = scala.io.StdIn.readLine("Novo tamanho: ")
    return dados(0) + "#" + dados(1) + "#" + novo + "#" + dados(3) + "@"
  }

  def alterarPreco(produto: String): String = {
    val dados = produto.split("#")
    val novo = scala.io.StdIn.readLine("Novo preço: ")
    return dados(0) + "#" + dados(1) + "#" + dados(2) + "#" + novo + "@"
  }

  // verifica se existe um produto com determinado ID
  def existeProduto(cardapio: Array[String], id: String): Boolean = {
    cardapio.foreach { e =>
      if (e.split("#")(0) == id) {
        return true;
      }
    }
    return false;
  }

  def getProduto(cardapio: Array[String], id: String): String = {
    cardapio.foreach { e =>
      if (e.split("#")(0) == id) {
        return Cardapio.criaProduto(e)
      }
    }
    return ""
  }
}

package model

object Relatorio {

  // Formata e exibe o relatorio de vendas efetuadas
  def visualizar(pedidos: Array[String]): String = {
    if (pedidos(0) != "") {
      var relatorio = "\n[RELATORIO DE PEDIDOS]\n---------------------------------------\n"
      pedidos.foreach { e =>
        relatorio += formataPedido(e) + "\n\n"
      }
      relatorio += "---------------------------------------\n"
      return relatorio
    }
    return "Ainda não há nenhum pedido."
  }

  def formataPedido(pedido: String): String = {
    val dados = pedido.split("#")
    return "Pedido nº " + dados(0) + ":\nData do pedido: " + dados(1).toUpperCase + "\n" + dados(2).toUpperCase
  }
}

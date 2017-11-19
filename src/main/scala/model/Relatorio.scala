package model

object Relatorio {

  // Formata e exibe o relatorio de vendas efetuadas
  def visualizar() : String = {
    val pedidos = FileIO.ler("pedido.txt","").split("@")
    var pedidoUnit = ""
    if (pedidos(0) != "") {
      for (i <- 0 to pedidos.length - 1) {
        var itens = pedidos(i).split("#")
        pedidoUnit = pedidoUnit + "ID:" + itens(0) +" "+ itens(1).toUpperCase +"\n"+ itens(2).toUpperCase+"\n"
      }
      return "\n[RELATORIO DE PEDIDOS]\n---------------------------------------\n" + pedidoUnit
    }
    return "Nao houve pedidos!"
  }
}
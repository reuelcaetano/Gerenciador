package model

import java.io._
import java.io.IOException
import scala.io.Source

object FileIO {

  // Cria um novo arquivo com argumento
  def novoArg(nome: String, texto: String) : String = {
    val writer = new PrintWriter(new File(nome))
    writer.write(texto)
    writer.close()
    return "Arquivo criado!"
  }

  // Escreve em um arquivo adicionando dados
  def escrever(arq: String, texto: String) : String = {
    val gravado = ler(arq,"")
    val writer = new PrintWriter(new File(arq))
    writer.write(gravado+texto)
    writer.close()
    return "Arquivo escrito!"
  }

  // Subscreve um arquivo por cima
  def subescrever(arq: String, texto: String) : String = {
    val writer = new PrintWriter(new File(arq))
    writer.write(texto)
    writer.close()
    return "Arquivo subescrito!"
  }

  // Ler um arquivo ".txt"
  def ler(arq: String, arg: String): String = {
    try {
      val texto = Source.fromFile(arq).mkString
      return texto
    } catch {
      case ex: FileNotFoundException => {
        novoArg(arq, arg)
        val texto = Source.fromFile(arq).mkString
        return texto
      }
      case ex: IOException => {
        novoArg(arq, arg)
        val texto = Source.fromFile(arq).mkString
        return "IOException"
      }
    }
  }
}
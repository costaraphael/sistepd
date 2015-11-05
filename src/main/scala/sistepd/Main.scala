package sistepd

import javax.swing.JOptionPane

import net.sf.brunneng.fusie.input.pdl.PDLParser
import net.sf.brunneng.fusie.engine.fcf.FCFInferenceEngine
import net.sf.brunneng.fusie.ui.ConsoleUserInteraction

import scala.io.Source

object Main {

  def main(args: Array[String]) {

    val baseConhecimento = Source.fromFile("src/resources/base_conhecimento").mkString

    val input = new PDLParser().parseProblem(baseConhecimento, null, new GuiUserInteraction)
    val resultado = new FCFInferenceEngine().run(input)

    JOptionPane.showMessageDialog(null, resultado.map(res => s"${res.value} - (${res.probability*100}%)\n").mkString)
  }
}

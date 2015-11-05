package sistepd

import javax.swing.JOptionPane

import net.sf.brunneng.fusie.ui.UserInteraction

import scala.collection.mutable

class GuiUserInteraction extends UserInteraction {
  override def readValue(question: String, variants: List[String]): String = {
    var variantsMap: mutable.Map[String, String] = null
    if (variants != null) {
      variantsMap = new mutable.HashMap[String, String]
      var i = 1
      variants.foreach(v => {
        variantsMap(i.toString) = v
        variantsMap(v.trim) = v
        i += 1
      })
    }


    var input = JOptionPane.showInputDialog(null, question, "Pergunta", JOptionPane.QUESTION_MESSAGE)

    //val s = new Scanner(System.in)
    if (variants != null) {
      var stopRepeat = false
      while (!stopRepeat) {
        input = variantsMap.getOrElse(input.trim, null)
        if (input == null) {
          JOptionPane.showMessageDialog(null, s"Valor incorreto. Por favor, entre com um valor da lista ou um número de 1 a ${variants.size}.")
          input = JOptionPane.showInputDialog(null, question, "Pergunta", JOptionPane.QUESTION_MESSAGE)
        }
        else {
          stopRepeat = true
        }
      }
    }

    input
  }

  override def showError(errorMessage: String): Unit = {
    JOptionPane.showMessageDialog(null, s"ERROR: $errorMessage")
  }
}

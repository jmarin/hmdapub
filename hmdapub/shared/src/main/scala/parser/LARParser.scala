package parser

import model._

object LARParser {

  def apply(s: String): LoanApplicationRegister = {
    val asOfDate = s.substring(0,4).toInt

    LoanApplicationRegister(asOfDate)
  }

}

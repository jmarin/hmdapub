package parser

import utest._

object LARParserTest extends TestSuite {

    val larString = "200700000000011121000051NA   010030101.001500100    13255    8    NA   23      1"


  def tests = TestSuite {
    'parseLAR {
      val lar = LARParser(larString)  
      assert(lar.asOfDate == 2007)
    }
  }

}

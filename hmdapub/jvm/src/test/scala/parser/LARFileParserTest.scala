package parser

import utest._


object LARFileParserTest extends TestSuite {

  def tests = TestSuite {
    val source = scala.io.Source.fromFile("hmdapub/jvm/src/test/resources/lars2007.dat") 

    val lines = source.getLines//.mkString("\n")
    lines.foreach { line =>
      val lar = LARParser(line) 
      assert(lar.asOfDate == 2007)
      assert(lar.agencyCode == 1)
    }
    source.close()

  }
}



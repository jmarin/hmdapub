package parser

import model.LoanApplicationRegister
import utest._
import upickle._

object LARParserTest extends TestSuite {

    val larString = "200700000000011121000051NA   010030101.001500100    13255    8    NA   23      1"

    val larOrig =  LoanApplicationRegister(2007,"0000000001",1,1,1,2,1,"00005",1,"NA","01","003","010100","01003010100","","","","",3,2,2,5,"","","","",8,"","","","",1,5,0,"NA",2,3,"1")

  def tests = TestSuite {
    'parseLAR {
      val lar = LARParser(larString)  
      println(lar)

      assert(lar.asOfDate == 2007)
      assert(lar.respondentId == "0000000001")
      assert(lar.agencyCode == 1)

      assert(lar.loanType == 1)
      assert(lar.propertyType == 1)
      assert(lar.purpose == 2)
      assert(lar.occupancy == 1)
      assert(lar.amount == "00005")
      assert(lar.actionType == 1)

      assert(lar.msa == "NA")
      assert(lar.state == "01")
      assert(lar.county == "003")
      assert(lar.fips == "01003010100")

      assert(lar.reason1 == "")
      assert(lar.reason2 == "")
      assert(lar.reason3 == "")

      assert(lar.editStatus == "")
      assert(lar.preApprovals == 3)

      assert(lar.ethnicity == 2)
      assert(lar.coEthnicity == 5)
      assert(lar.race1 == 5)
      assert(lar.race2 == "")
      assert(lar.race3 == "")
      assert(lar.race4 == "")
      assert(lar.race5 == "")

      assert(lar.coRace1 == 8)
      assert(lar.coRace2 == "")
      assert(lar.coRace3 == "")
      assert(lar.coRace4 == "")
      assert(lar.coRace5 == "")
      assert(lar.sex == 1)
      assert(lar.coSex == 5)

      assert(lar.purchaserType == 0)
      assert(lar.rateSpread == "NA")
      assert(lar.hoepaStatus == 2)
      assert(lar.lienStatus == 3)
      assert(lar.sequenceNumber == "1")

    }
    'JsonSerialization {
      val jsonSer = write(larOrig)
      assert(read[LoanApplicationRegister](jsonSer) == larOrig)
    }
  }

}

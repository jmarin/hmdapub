package parser

import utest._

object LARParserTest extends TestSuite {

    val larString = "200700000000011121000051NA   010030101.001500100    13255    8    NA   23      1"


  def tests = TestSuite {
    'parseLAR {
      val lar = LARParser(larString)  
      println(lar)

      assert(lar.asOfDate == 2007)
      assert(lar.respondentId == "0000000001")
      assert(lar.agencyCode == 1)
      
      assert(lar.loan.loanType == 1)
      assert(lar.loan.propertyType == 1)
      assert(lar.loan.purpose == 2)
      assert(lar.loan.occupancy == 1)
      assert(lar.loan.amount == "00005")
      assert(lar.actionType == 1)

      assert(lar.geography.msa == "NA")
      assert(lar.geography.state == "01")
      assert(lar.geography.county == "003")
      assert(lar.geography.fips == "01003010100")

      assert(lar.denial.reason1 == "")
      assert(lar.denial.reason2 == "")
      assert(lar.denial.reason3 == "")

      assert(lar.editStatus == "")
      assert(lar.preapprovals == 3)

      assert(lar.applicant.ethnicity == 2)
      assert(lar.applicant.coEthnicity == 5)
      assert(lar.applicant.race1 == 5)
      assert(lar.applicant.race2 == "")
      assert(lar.applicant.race3 == "")
      assert(lar.applicant.race4 == "")
      assert(lar.applicant.race5 == "")

      assert(lar.applicant.coRace1 == 8)
      assert(lar.applicant.coRace2 == "")
      assert(lar.applicant.coRace3 == "")
      assert(lar.applicant.coRace4 == "")
      assert(lar.applicant.coRace5 == "")
      assert(lar.applicant.sex == 1)
      assert(lar.applicant.coSex == 5)

      assert(lar.purchaserType == 0)
      assert(lar.rateSpread == "NA")
      assert(lar.hoepaStatus == 2)
      assert(lar.lienStatus == 3)
      assert(lar.sequenceNumber == "1")
      
    }
  }

}

package parser

import model._

object LARParser {

  def apply(s: String): LoanApplicationRegister = {
    val asOfDate = s.substring(0,4).toInt
    val respId = s.substring(4,14).trim
    val agencyCode = s.substring(14,15).toInt
    val loanType = s.substring(15, 16).toInt
    val purpose = s.substring(16, 17).toInt
    val occupancy = s.substring(17, 18).toInt
    val amount = s.substring(18, 23).trim
    val actionType = s.substring(23,24).toInt

    val msa = s.substring(24,29).trim
    val state = s.substring(29, 31).trim
    val county = s.substring(31, 34).trim  
    val tract = s.substring(34, 41).replace(".","").trim
    val fips = state + county + tract

    val sex = s.substring(41, 42).toInt
    val coSex = s.substring(42, 43).toInt
    val income = s.substring(43, 47).trim
    val purchaserType = s.substring(47, 48).toInt

    val reason1 = s.substring(48, 49).trim
    val reason2 = s.substring(49, 50).trim
    val reason3 = s.substring(50, 51).trim

    val editStatus = s.substring(51, 52).trim

    val propertyType = s.substring(52, 53).toInt

    val preapprovals = s.substring(53, 54).toInt

    val ethnicity = s.substring(54, 55).toInt
    val coEthnicity = s.substring(55, 56).toInt
    val race1 = s.substring(56, 57).toInt
    val race2 = s.substring(57, 58).trim
    val race3 = s.substring(58, 59).trim
    val race4 = s.substring(59, 60).trim
    val race5 = s.substring(60, 61).trim
    val coRace1 = s.substring(61, 62).toInt
    val coRace2 = s.substring(62, 63).trim
    val coRace3 = s.substring(63, 64).trim
    val coRace4 = s.substring(64, 65).trim
    val coRace5 = s.substring(65, 66).trim
    val rateSpread = s.substring(66, 71).trim
    val hoepaStatus = s.substring(71, 72).toInt
    val lienStatus = s.substring(72, 73).toInt
    val sequenceNumber = s.substring(73, 80).trim

    val loan = Loan(loanType, propertyType, purpose,occupancy, amount)
    val geography = Geography(msa, state, county, tract, fips)
    val denial = Denial(reason1, reason2, reason3)
    val applicant = Applicant(ethnicity, coEthnicity, race1, race2, race3, race4, race5, coRace1, coRace2, coRace3, coRace4, coRace5, sex, coSex)



    LoanApplicationRegister(
      asOfDate,
      respId,
      agencyCode,
      loan,
      actionType, 
      geography,
      denial,
      editStatus,
      preapprovals,
      applicant,
      purchaserType, 
      rateSpread,
      hoepaStatus, 
      lienStatus,
      sequenceNumber)

  }

}

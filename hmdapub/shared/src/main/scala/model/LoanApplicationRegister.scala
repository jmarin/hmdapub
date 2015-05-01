package model

case class LoanApplicationRegister(
  asOfDate: Int,
  respondentId: String,
  agencyCode: Int,
  loan: Loan,
  actionType: Int,
  geography: Geography, 
  denial: Denial,
  editStatus: String,
  preapprovals: Int,
  applicant: Applicant,
  purchaserType: Int,
  rateSpread: String,
  hoepaStatus: Int, 
  lienStatus: Int,
  sequenceNumber: String)

case class Loan(
  loanType: Int,
  propertyType: Int,
  purpose: Int,
  occupancy: Int,
  amount: String)

case class Geography(
  msa: String,
  state: String,
  county: String,
  tract: String,
  fips: String) {
    require(fips.length == 11, 
      "Census Tract FIPS code must be 11 characters long")
  }

case class Applicant(
  ethnicity: Int,
  coEthnicity: Int,
  race1: Int,
  race2: String,
  race3: String,
  race4: String,
  race5: String,
  coRace1: Int,
  coRace2: String,
  coRace3: String,
  coRace4: String,
  coRace5: String,
  sex: Int,
  coSex: Int)

case class Denial(
  reason1: String,
  reason2: String,
  reason3: String)

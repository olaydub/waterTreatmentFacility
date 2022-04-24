
CREATE SCHEMA IF NOT EXISTS WTF;


CREATE TABLE IF NOT EXISTS WTF.WaterSource (
  IDNo INT NOT NULL,
  Location VARCHAR(50) NOT NULL,
  WaterQuality VARCHAR(50) NULL,
  WaterQuantity DECIMAL(11,1) NULL DEFAULT 0,
  PRIMARY KEY (IDNo)
);


CREATE TABLE IF NOT EXISTS WTF.WaterTreatmentFacility (
  FacilityName VARCHAR(50) NOT NULL,
  Address VARCHAR(50) NOT NULL,
  ContactName VARCHAR(50) NOT NULL,
  ContactPhone VARCHAR(20) NOT NULL,
  WaterQuantity DECIMAL(11,1) NULL DEFAULT 0,
  WaterSource_IDNo INT NOT NULL,
  PRIMARY KEY (FacilityName),
  FOREIGN KEY (WaterSource_IDNo) REFERENCES WTF.WaterSource (IDNo) ON DELETE CASCADE ON UPDATE CASCADE
);




CREATE TABLE IF NOT EXISTS WTF.Treatment (
  TreatmentNo INT NOT NULL,
  Description VARCHAR(50) NOT NULL,
  PRIMARY KEY (TreatmentNo)
);



CREATE TABLE IF NOT EXISTS WTF.Investment (
  IDNo INT NOT NULL,
  CapitalCosts DECIMAL(20,2) NULL DEFAULT 0.00,
  OperatingCosts DECIMAL(20,2) NULL DEFAULT 0.00,
  MaintenanceCosts DECIMAL(20,2) NULL DEFAULT 0.00,
  EstimatedWaterQualityImprovement DECIMAL(10,2) NULL DEFAULT 0.00,
  PRIMARY KEY (IDNo)
);



CREATE TABLE IF NOT EXISTS WTF.Business (
  IDNo INT NOT NULL,
  BusinessName VARCHAR(50) NOT NULL,
  Address VARCHAR(50) NOT NULL,
  ContactName VARCHAR(50) NULL,
  StartingDate DATE NULL,
  AvgWaterConsumpPerMonth DECIMAL(11,1) NULL DEFAULT 0.0,
  AvgWasteGeneratedPerMonth DECIMAL(11,1) NULL,
  BusinessType VARCHAR(20) NULL,
  PRIMARY KEY (IDNo)
);


CREATE TABLE IF NOT EXISTS WTF.Regulation (
  IDNo INT NOT NULL,
  RName VARCHAR(50) NOT NULL,
  ApprovalDate DATE NULL,
  RDescription VARCHAR(100) NULL,
  PRIMARY KEY (IDNo)
);



CREATE TABLE IF NOT EXISTS WTF.Investment_has_WaterTreatmentFacility (
  Investment_IDNo INT NOT NULL,
  WaterTreatmentFacility_FacilityName VARCHAR(50) NOT NULL,
  PRIMARY KEY (Investment_IDNo, WaterTreatmentFacility_FacilityName),
    FOREIGN KEY (Investment_IDNo) REFERENCES WTF.Investment (IDNo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (WaterTreatmentFacility_FacilityName) REFERENCES WTF.WaterTreatmentFacility (FacilityName) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS WTF.WaterSource_And_Business_Connected (
  WaterSource_IDNo INT NOT NULL,
  Business_IDNo INT NOT NULL,
  PRIMARY KEY (WaterSource_IDNo, Business_IDNo),
    FOREIGN KEY (WaterSource_IDNo) REFERENCES WTF.WaterSource (IDNo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Business_IDNo) REFERENCES WTF.Business (IDNo) ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE IF NOT EXISTS WTF.Treatment_Type_Performed_List (
  WaterTreatmentFacility_FacilityName VARCHAR(50) NOT NULL,
  Treatment_TreatmentNo INT NOT NULL,
  PerformedDate DATE NULL,
  Quantity DECIMAL(11,1) NULL,
  Descript VARCHAR(50) NULL,
  PRIMARY KEY (WaterTreatmentFacility_FacilityName, Treatment_TreatmentNo),
    FOREIGN KEY (Treatment_TreatmentNo) REFERENCES WTF.Treatment (TreatmentNo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (WaterTreatmentFacility_FacilityName) REFERENCES WTF.WaterTreatmentFacility (FacilityName) ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE IF NOT EXISTS WTF.Regulation_has_Treatment (
  Regulation_IDNo INT NOT NULL,
  Treatment_TreatmentNo INT NOT NULL,
  PRIMARY KEY (Regulation_IDNo, Treatment_TreatmentNo),
    FOREIGN KEY (Regulation_IDNo)REFERENCES WTF.Regulation (IDNo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Treatment_TreatmentNo) REFERENCES WTF.Treatment (TreatmentNo) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE WTF.Regulation_has_Treatment;
DROP TABLE WTF.Treatment_Type_Performed_List;
DROP TABLE WTF.WaterSource_And_Business_Connected;
DROP TABLE WTF.Investment_has_WaterTreatmentFacility;
DROP TABLE WTF.Regulation ;
DROP TABLE WTF.Business;
DROP TABLE WTF.Investment;
DROP TABLE WTF.Treatment;
DROP TABLE WTF.WaterTreatmentFacility;
DROP TABLE WTF.WaterSource;
DROP SCHEMA WTF;

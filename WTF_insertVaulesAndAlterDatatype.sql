alter table WTF.Treatment_Type_Performed_List 
modify column Descript VARCHAR(100) NULL;




insert into WTF.Treatment values-- columnNames: (TreatmentNo, Description)
(11, 'Stage 1 treatment'),
(22, 'Stage 2 treatment'),
(33, 'Stage 3 treatment'),
(44, 'Stage 4 treatment'),
(55, 'Stage 5 treatment'),
(66, 'Stage 6 treatment'),
(77, 'Stage 7 treatment');

insert into WTF.Business values -- columnNames: (IDNo, BusinessName, Address, ContactName, StartingDate, AvgWaterConsumpPerMonth, AvgWasteGeneratedPerMonth, BusinessType)
(111, 'Animal Farm', '123 Cherry Lane', 'Farmer Jane', '1875-01-01', 500000, 20000, 'Agricultural'),
(222, 'Iron Man Steel', '456 Tempered Drive', 'John Henry', '1875-01-01', 25000, 250000, 'Industrial'),
(333, 'United Fruit', '789 Panama Court', 'Tommy Chong', '1969-04-20', 69000, 420, 'Agricultural'),
(444, 'Weyland Yutani', 'USCSS Nostromo', 'Lt. Ripley', '1979-05-25', 100000000, 100000000, 'Industrial'),
(555, 'Tyrell Corporation', '55 Sunset Blvd', 'Dr. Eldon Tyrell', '2019-01-01', 50000000, 750000, 'Industrial'),
(666, 'Hoolie', 'Silicon Valley', 'Gavin Belson', '2015-01-01', 35000, 5000, 'Industrial'),
(777, 'Magrathea', '222 Notearth Ave', 'Slartibartfast', '0001-01-01', 999999999, 0, 'Agricultural');


insert into WTF. WaterSource values -- columnNames: (IDNo, Location, WaterQuality, WaterQuantity)
(101,'Seattle','bad',1010000.0),
(102,'Everett','good',1020000.0),
(103,'Auburn','bad', 1030000.0),
(104,'Edmonds','good', 1040000.0),
(105, 'Burien','bad', 1050000.0),
(106,'Bellevue','good', 1060000.0),
(107, 'Bothell','Exellent', 1070000.0);


insert into WTF.WaterTreatmentFacility values -- columnNames:(FacilityName, Address, ContactName, ContactPhone, WaterQuantity, WaterSource_IDNo)
("Sid's Sewage","3654 Powder House Road","Dario J Absher","561-596-8317",12000000,101),
("Water wonderland","4425 Fort Street","Eleanor W Blankenship","253-229-8062",6000000,102),
("Motley water treatment","3269 Heritage Road","Wilma M Maxey","559-748-9418",3000000,103),
("Alphamax water purifier co","3889 Counts Lane","Kathryn J Parrott","859-982-6651",18000000,104),
("We need water","2952 Liberty Street","Katherine J Douglas","214-878-6995",1000000,105),
("Glacierclear waters","2359 Dogwood Road","Albert L Curry","602-728-3766",12000000,106),
("Aquaforce","2980 Horizon Circle","Marsha D Clark","253-499-8518",50000000,107);

insert into WTF.Investment_has_WaterTreatmentFacility values -- (Investment_IDNo,WaterTreatmentFacility_FacilityName)
(1,"Sid's Sewage"),
(2,"Water wonderland"),
(3,"Motley water treatment"),
(4,"Alphamax water purifier co"),
(5,"Alphamax water purifier co"),
(6,"Glacierclear waters"),
(7,"Aquaforce");

insert into WTF.WaterSource_And_Business_Connected values -- columnNames: (WaterSource_IDNo, Business_IDNo)
(101,111 ),
(101, 222),
(103,333 ),
(103,444 ),
(103,555 ),
(106, 666),
(107,777 );


insert into WTF.Regulation_has_Treatment values -- columnNames (Regulation_IDNo,Treatment_TreatmentNo)
(10,44),
(10,66),
(20,55),
(30,11),
(30,33),
(40,11),
(40,77),
(50,11),
(50,22),
(50,77),
(60,11),
(60,22),
(70,22),
(70,33);
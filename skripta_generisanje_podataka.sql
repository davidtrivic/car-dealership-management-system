USE projekat_baze_podataka;

INSERT INTO Zaposleni (Ime, Prezime) VALUES
('Marko', 'Marković'),
('Ana', 'Anić'),
('Petar', 'Petrović'),
('Ivana', 'Ivanić'),
('Jovana', 'Jovanović'),
('Milan', 'Milanović'),
('Dragana', 'Draganić'),
('Boris', 'Borić'),
('Tijana', 'Tijanić'),
('Nemanja', 'Nemanić');


INSERT INTO Agent (ID) VALUES (1), (2), (5), (6), (7);

INSERT INTO Servisni_tehnicar (ID) VALUES (3), (4), (8), (9);


INSERT INTO Kupac (JMB, Ime, Prezime, Adresa, Telefon, Email) VALUES
('1234567890123', 'Stefan', 'Stefanović', 'Ulica bb, Banja Luka', '065123456', 'stefan@email.com'),
('9876543210987', 'Maja', 'Majić', 'Cara Lazara 5, Banja Luka', '066234567', 'maja@email.com'),
('1111222233334', 'Nikola', 'Nikolić', 'Kralja Petra 12, Banja Luka', '065345678', 'nikola@email.com'),
('2222333344445', 'Aleksa', 'Aleksić', 'Vidovdanska 3, Banja Luka', '065456789', 'aleksa@email.com'),
('3333444455556', 'Sandra', 'Sandrić', 'Nemanjina 7, Banja Luka', '066567890', 'sandra@email.com'),
('4444555566667', 'Dragan', 'Draganović', 'Svetosavska 22, Banja Luka', '065678901', 'dragan@email.com'),
('5555666677778', 'Jelena', 'Jelenić', 'Majke Jugovića 1, Banja Luka', '066789012', 'jelena@email.com'),
('6666777788889', 'Vladimir', 'Vladimirović', 'Cara Dušana 9, Banja Luka', '065890123', 'vladimir@email.com'),
('7777888899990', 'Kristina', 'Kristić', 'Kneza Miloša 4, Banja Luka', '066901234', 'kristina@email.com'),
('8888999900001', 'Dejan', 'Dejanović', 'Sutješka 18, Banja Luka', '065012345', 'dejan@email.com'),
('9999000011112', 'Milica', 'Miličić', 'Jevrejska 6, Banja Luka', '066123456', 'milica@email.com');


INSERT INTO Vozilo (VIN, Marka, Model, Godiste, Boja, Opis) VALUES
('1HGCM82633A123456', 'Volkswagen', 'Golf 7', 2022, 'Crna', 'Odlično stanje'),
('2HGCM82633A654321', 'Toyota', 'Corolla', 2023, 'Bijela', 'Novo vozilo'),
('3HGCM82633A111222', 'BMW', '320d', 2020, 'Siva', 'Polovno vozilo'),
('4HGCM82633A333444', 'Škoda', 'Octavia', 2021, 'Plava', 'Jedan vlasnik'),
('5HGCM82633A555666', 'Audi', 'A4', 2021, 'Crna', 'Odlično stanje, jedan vlasnik'),
('6HGCM82633A777888', 'Mercedes', 'C220', 2022, 'Bijela', 'Full oprema, garancija'),
('7HGCM82633A999000', 'Renault', 'Megane', 2020, 'Crvena', 'Redovno servisan'),
('8HGCM82633A111333', 'Peugeot', '308', 2023, 'Siva', 'Novo vozilo'),
('9HGCM82633A444555', 'Ford', 'Focus', 2019, 'Plava', 'Dva prethodna vlasnika'),
('AHGCM82633A666777', 'Opel', 'Astra', 2021, 'Zelena', 'Jedan vlasnik, servisna knjiga'),
('BHGCM82633A888999', 'Honda', 'Civic', 2022, 'Crna', 'Novo vozilo, full oprema'),
('CHGCM82633A000111', 'Nissan', 'Qashqai', 2020, 'Bijela', 'SUV, redovno servisan'),
('DHGCM82633A222333', 'Hyundai', 'i30', 2021, 'Srebrna', 'Odlično stanje'),
('EHGCM82633A444555', 'Kia', 'Ceed', 2023, 'Crvena', 'Novo vozilo, garancija 7 godina'),
('FHGCM82633A666777', 'Seat', 'Leon', 2019, 'Plava', 'Tri prethodna vlasnika'),
('GHGCM82633A888000', 'Mazda', '3', 2022, 'Bijela', 'Novo vozilo');


INSERT INTO Tehnicka_Specifikacija (VIN, Kilometraza, ZapreminaMotora, VrstaGoriva, Pogon, Oprema) VALUES
('1HGCM82633A123456', 15000, 1600, 'Dizel', 'Prednji', 'Navigacija, klima'),
('2HGCM82633A654321', 0, 1800, 'Benzin', 'Prednji', 'Full oprema'),
('3HGCM82633A111222', 85000, 2000, 'Dizel', 'Zadnji', 'Koža, navigacija'),
('4HGCM82633A333444', 42000, 1400, 'Benzin', 'Prednji', 'Klima, senzori'),
('5HGCM82633A555666', 35000, 2000, 'Dizel', 'Prednji', 'Koža, navigacija, panorama'),
('6HGCM82633A777888', 18000, 2200, 'Dizel', 'Zadnji', 'Full oprema, AMG paket'),
('7HGCM82633A999000', 62000, 1500, 'Benzin', 'Prednji', 'Klima, navigacija'),
('8HGCM82633A111333', 0, 1600, 'Benzin', 'Prednji', 'Full oprema, kamera'),
('9HGCM82633A444555', 88000, 1600, 'Dizel', 'Prednji', 'Klima, tempomat'),
('AHGCM82633A666777', 28000, 1400, 'Benzin', 'Prednji', 'Klima, senzori, kamera'),
('BHGCM82633A888999', 0, 1500, 'Benzin', 'Prednji', 'Full oprema, Honda Sensing'),
('CHGCM82633A000111', 45000, 1600, 'Dizel', 'Svi', 'Navigacija, panorama, koža'),
('DHGCM82633A222333', 22000, 1400, 'Benzin', 'Prednji', 'Klima, navigacija, kamera'),
('EHGCM82633A444555', 0, 1600, 'Benzin', 'Prednji', 'Full oprema, garancija 7g'),
('FHGCM82633A666777', 95000, 1400, 'Dizel', 'Prednji', 'Klima, tempomat'),
('GHGCM82633A888000', 0, 2000, 'Benzin', 'Prednji', 'Full oprema, Skyactiv');


INSERT INTO Komercijalni_Podaci (VIN, NabavnaCijena, ProdajnaCijena, Status) VALUES
('1HGCM82633A123456', 18000.00, 22000.00, 'Prodano'),
('2HGCM82633A654321', 24000.00, 28000.00, 'Dostupno'),
('3HGCM82633A111222', 15000.00, 19500.00, 'Prodano'),
('4HGCM82633A333444', 16000.00, 20000.00, 'Prodano'),
('5HGCM82633A555666', 22000.00, 27500.00, 'Prodano'),
('6HGCM82633A777888', 35000.00, 42000.00, 'Dostupno'),
('7HGCM82633A999000', 11000.00, 14500.00, 'Prodano'),
('8HGCM82633A111333', 21000.00, 25500.00, 'Dostupno'),
('9HGCM82633A444555', 8500.00, 11000.00, 'Prodano'),
('AHGCM82633A666777', 14000.00, 17500.00, 'Dostupno'),
('BHGCM82633A888999', 23000.00, 27000.00, 'Rezervisano'),
('CHGCM82633A000111', 17000.00, 21500.00, 'Dostupno'),
('DHGCM82633A222333', 13500.00, 17000.00, 'Prodano'),
('EHGCM82633A444555', 19000.00, 23500.00, 'Dostupno'),
('FHGCM82633A666777', 7000.00, 9500.00, 'Dostupno'),
('GHGCM82633A888000', 22000.00, 26500.00, 'Rezervisano');


INSERT INTO Novo_Vozilo (VIN, PeriodGarancije) VALUES
('2HGCM82633A654321', 36),
('1HGCM82633A123456', 24),
('6HGCM82633A777888', 36),
('8HGCM82633A111333', 36),
('BHGCM82633A888999', 36),
('EHGCM82633A444555', 84),
('GHGCM82633A888000', 36);


INSERT INTO Polovno_Vozilo (VIN, BrojPrethodnihVlasnika) VALUES
('3HGCM82633A111222', 2),
('4HGCM82633A333444', 1),
('5HGCM82633A555666', 1),
('7HGCM82633A999000', 2),
('9HGCM82633A444555', 2),
('AHGCM82633A666777', 1),
('CHGCM82633A000111', 1),
('DHGCM82633A222333', 1),
('FHGCM82633A666777', 3);


INSERT INTO Placanje (Tip, Banka, BrojRata, IznosRate, Avans) VALUES
('Gotovina', NULL, NULL, NULL, NULL),
('Kredit', 'UniCredit Bank', 48, 250.00, 3000.00),
('Lizing', 'Raiffeisen Leasing', 36, 320.00, 2000.00),
('Gotovina', NULL, NULL, NULL, NULL),
('Kredit', 'NLB Banka', 60, 380.00, 4000.00),
('Lizing', 'S-Leasing', 48, 290.00, 2500.00),
('Gotovina', NULL, NULL, NULL, NULL),
('Kredit', 'Sparkasse', 36, 520.00, 5000.00),
('Lizing', 'UniCredit Leasing', 60, 210.00, 1500.00),
('Gotovina', NULL, NULL, NULL, NULL),
('Gotovina', NULL, NULL, NULL, NULL);


INSERT INTO Prodaja (ID_Agenta, JMB_Kupca, VIN, ID_Placanja, Datum, Cijena) VALUES
(1, '1234567890123', '4HGCM82633A333444', 1, '2026-03-15', 20000.00),
(1, '2222333344445', '5HGCM82633A555666', 4, '2026-01-10', 27500.00),
(2, '3333444455556', '7HGCM82633A999000', 5, '2026-01-22', 14500.00),
(5, '4444555566667', '9HGCM82633A444555', 7, '2026-02-05', 11000.00),
(1, '5555666677778', 'DHGCM82633A222333', 6, '2026-02-18', 17000.00),
(6, '6666777788889', '1HGCM82633A123456', 10, '2026-03-02', 22000.00),
(2, '7777888899990', '3HGCM82633A111222', 8, '2026-03-20', 19500.00),
(5, '8888999900001', '4HGCM82633A333444', 11, '2026-04-05', 20000.00);


INSERT INTO Uplata (IdPlacanja, Iznos, DatumUplate) VALUES
(1, 20000.00, '2026-03-15'),
(4, 27500.00, '2026-01-10'),
(7, 11000.00, '2026-02-05'),
(10, 22000.00, '2026-03-02'),
(11, 20000.00, '2026-04-05');


INSERT INTO Uplata (IdPlacanja, Iznos, DatumUplate) VALUES
(2, 250.00, '2026-03-01'),
(2, 250.00, '2026-04-01'),
(2, 250.00, '2026-05-01'),
(3, 320.00, '2026-04-15'),
(3, 320.00, '2026-05-15'),
(5, 380.00, '2026-02-22'),
(5, 380.00, '2026-03-22'),
(5, 380.00, '2026-04-22'),
(6, 290.00, '2026-03-18'),
(6, 290.00, '2026-04-18'),
(6, 290.00, '2026-05-18'),
(8, 520.00, '2026-04-20'),
(8, 520.00, '2026-05-20'),
(9, 210.00, '2026-03-20'),
(9, 210.00, '2026-04-20'),
(9, 210.00, '2026-05-20');


INSERT INTO Testna_Voznja (VIN, JMB_Kupca, ID_Agenta, DatumVoznje) VALUES
('1HGCM82633A123456', '1234567890123', 1, '2026-04-10'),
('2HGCM82633A654321', '9876543210987', 2, '2026-04-12'),
('3HGCM82633A111222', '1111222233334', 1, '2026-05-03'),
('6HGCM82633A777888', '2222333344445', 1, '2026-01-08'),
('8HGCM82633A111333', '3333444455556', 2, '2026-01-20'),
('AHGCM82633A666777', '4444555566667', 5, '2026-02-03'),
('EHGCM82633A444555', '5555666677778', 6, '2026-02-15'),
('CHGCM82633A000111', '6666777788889', 1, '2026-03-01'),
('FHGCM82633A666777', '7777888899990', 2, '2026-03-18'),
('GHGCM82633A888000', '8888999900001', 5, '2026-04-02'),
('6HGCM82633A777888', '9999000011112', 6, '2026-04-20'),
('EHGCM82633A444555', '2222333344445', 1, '2026-05-05'),
('8HGCM82633A111333', '1111222233334', 2, '2026-05-18');


INSERT INTO Dio (Naziv, Zaliha, MinimalnaKolicina) VALUES
('Filter ulja', 50, 10),
('Kočione pločice', 30, 5),
('Svjećice', 100, 20),
('Amortizer', 15, 3);


INSERT INTO Radni_Nalog (VIN, JMB_Vlasnika, IdTehnicara, OpisZahtjeva, DatumPrijema, Status, CijenaRada) VALUES
('3HGCM82633A111222', '1111222233334', 3, 'Redovni servis i zamjena filtera', '2026-05-10', 'Zavrseno', 50.00),
('4HGCM82633A333444', '1234567890123', 4, 'Zamjena kočionih pločica', '2026-05-15', 'U radu', 50.00),
('5HGCM82633A555666', '2222333344445', 3, 'Zamjena ulja i filtera', '2026-02-15', 'Zavrseno', 50.00),
('7HGCM82633A999000', '3333444455556', 4, 'Servis mjenjača', '2026-03-10', 'Zavrseno', 50.00),
('9HGCM82633A444555', '4444555566667', 8, 'Zamjena amortizera', '2026-04-01', 'Zavrseno', 50.00),
('DHGCM82633A222333', '5555666677778', 9, 'Dijagnostika i servis', '2026-04-20', 'Zavrseno', 50.00),
('1HGCM82633A123456', '6666777788889', 3, 'Zamjena svjećica i filtera', '2026-05-05', 'U radu', 50.00),
('3HGCM82633A111222', '7777888899990', 4, 'Kočioni sistem', '2026-05-20', 'Primljeno', 50.00);


INSERT INTO Popravka (IdNaloga, IdDijela, DatumPopravke, UtrosenaKolicina, UtrosenoVrijeme) VALUES
(1, 1, '2026-05-10', 1, 30),
(1, 3, '2026-05-10', 4, 15),
(2, 2, '2026-05-15', 2, 60),
(3, 1, '2026-02-15', 1, 45),
(4, 1, '2026-03-10', 1, 30),
(4, 3, '2026-03-10', 2, 20),
(5, 4, '2026-04-01', 2, 90),
(6, 1, '2026-04-20', 1, 30),
(6, 2, '2026-04-20', 2, 60),
(7, 3, '2026-05-05', 4, 20),
(8, 2, '2026-05-20', 4, 75);


INSERT INTO Racun (IdNaloga, Iznos, DatumIzdavanja) VALUES
(1, 125.00, '2026-05-10'),
(3, 91.50, '2026-02-15'),
(4, 86.40, '2026-03-10'),
(5, 165.00, '2026-04-01'),
(6, 195.00, '2026-04-20');


INSERT INTO Dobavljac (Naziv, Adresa, Telefon) VALUES
('AutoDijel d.o.o.', 'Industrijska 15, Banja Luka', '051123456'),
('Motopart d.o.o.', 'Kralja Alfonsa 8, Sarajevo', '033234567'),
('TechPart d.o.o.', 'Karađorđeva 33, Banja Luka', '051345678'),
('EuroAuto d.o.o.', 'Zmaj Jovina 2, Sarajevo', '033456789');


INSERT INTO Narudzba (IdDobavljaca, DatumNarudzbe, Status) VALUES
(1, '2026-05-01', 'Primljeno'),
(2, '2026-05-20', 'Naruceno'),
(1, '2026-03-15', 'Primljeno'),
(3, '2026-04-10', 'Primljeno'),
(4, '2026-05-25', 'Naruceno');


INSERT INTO Stavka (IdDijela, IdNarudzbe, Cijena, Kolicina) VALUES
(1, 1, 8.50, 20),
(3, 1, 3.20, 50),
(2, 2, 25.00, 10),
(4, 2, 45.00, 5),
(1, 3, 8.50, 30),
(2, 3, 25.00, 15),
(3, 4, 3.20, 100),
(4, 4, 45.00, 8),
(1, 5, 8.50, 25),
(3, 5, 3.20, 60);
CREATE TABLE Customers_N (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR2(100),
    Address VARCHAR2(255),s
    Phone VARCHAR2(20)
);

CREATE TABLE Couriers (
    CourierID INT PRIMARY KEY,
    Name VARCHAR2(100),
    VehicleType VARCHAR2(50),
    Capacity INT
);

CREATE TABLE Shipments (
    ShipmentID INT PRIMARY KEY,
    CustomerID INT,
    CourierID INT,
    Status VARCHAR2(50),
    FOREIGN KEY (CustomerID) REFERENCES Customers_N(CustomerID),
    FOREIGN KEY (CourierID) REFERENCES Couriers_N(CourierID)
);

CREATE TABLE Reports (
    ReportID INT PRIMARY KEY,
    ReportDate DATE,
    Content CLOB
);
CREATE SEQUENCE courier_sequence
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


CREATE SEQUENCE shipment_sequence
START WITH 1
INCREMENT BY 1
NOMAXVALUE;



CREATE SEQUENCE report_sequence
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
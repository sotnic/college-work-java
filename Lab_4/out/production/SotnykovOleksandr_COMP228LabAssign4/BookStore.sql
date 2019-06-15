-- Oleksandr Sotnykov #300986475

DROP TABLE BOOKS CASCADE CONSTRAINTS;
DROP TABLE SALES CASCADE CONSTRAINTS;

CREATE TABLE BOOKS (
  bookCode NUMBER(10) GENERATED ALWAYS AS IDENTITY (START WITH 001 INCREMENT By 1),
  title    VARCHAR2(50) NOT NULL,
  author   varchar2(25) NOT NULL,
  price    DECIMAL(7, 2),
  type     VARCHAR(25),
  subject  VARCHAR(25),
  CONSTRAINT pk_books
  PRIMARY KEY (bookCode)
);

CREATE TABLE SALES (
  saleCode  NUMBER(10) GENERATED ALWAYS AS IDENTITY (START WITH 001 INCREMENT BY 1),
  bookCode  Number(10),
  saledDate DATE         NOT NULL,
  quantity  number(10) NOT NULL,
  price     DECIMAL(7, 2),
  CONSTRAINT fk_sales
  FOREIGN KEY (bookCode)
  REFERENCES Books (bookCode)
  ON DELETE CASCADE
);

INSERT INTO BOOKS (title, author, price, TYPE, SUBJECT)
values ('Servlets and JSP', 'Murach', 40.75, 'Technology', 'Software Engineering');
INSERT INTO BOOKS (title, author, price, TYPE, SUBJECT)
values ('Learning Android 2', 'Marco', 56.97, 'Technology', 'Internet');
INSERT INTO BOOKS (title, author, price, TYPE, SUBJECT)
values ('Under the Sea', 'Johnson', 43.00, 'Science', 'Marine life');
INSERT INTO BOOKS (title, author, price, TYPE, SUBJECT)
values ('The Dark Tower', 'Stephen King', 25.00, 'Fantasy', 'Novel');
INSERT INTO BOOKS (title, author, price, TYPE, SUBJECT)
values ('The Seven Habits of Highly Effective People', 'Stephen Covey', 30.50, 'Motivation', 'Daily Life');

INSERT INTO SALES (bookCode, saledDate, quantity, price)
values (1, '23-Sep-2018', 5, 40.75);
INSERT INTO SALES (bookCode, saledDate, quantity, price)
values (2, '14-Oct-2018', 10, 56.97);
INSERT INTO SALES (bookCode, saledDate, quantity, price)
values (3, '20-Oct-2018', 15, 43.00);
INSERT INTO SALES (bookCode, saledDate, quantity, price)
values (4, '28-Oct-2018', 17, 25.00);
INSERT INTO SALES (bookCode, saledDate, quantity, price)
values (5, '30-Dec-2018', 8, 30.50);

COMMIT;
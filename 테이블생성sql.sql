--BOARD TABLE »ý¼º
CREATE TABLE BOARD 
( boardNumber NUMBER NOT NULL 
, boardTitle VARCHAR2(100) NOT NULL 
, boardWriter VARCHAR2(20) NOT NULL 
, boardContent VARCHAR2(1000) NOT NULL 
, boardDate DATE DEFAULT SYSDATE NOT NULL 
, boardHit NUMBER DEFAULT 1 NOT NULL 
, boardLock NUMBER DEFAULT 0 NOT NULL 
, boardValue VARCHAR2(20) NOT NULL 
, CONSTRAINT BOARD_PK PRIMARY KEY 
  (
    boardNumber 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX BOARD_PK ON BOARD (boardNumber ASC) 
      LOGGING 
      TABLESPACE MASKTBS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE MASKTBS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

--CART TABLE »ý¼º
CREATE TABLE CART 
(
  cartNumber NUMBER NOT NULL 
, cartUser VARCHAR2(20 BYTE) NOT NULL 
, cartProduct NUMBER NOT NULL 
, cartSelect NUMBER DEFAULT 1 NOT NULL 
, CONSTRAINT CART_PK PRIMARY KEY 
  (
    cartNumber 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX CART_PK ON CART (cartNumber ASC) 
      LOGGING 
      TABLESPACE MASKTBS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE MASKTBS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

ALTER TABLE CART
ADD CONSTRAINT CART_FK1 FOREIGN KEY
(
  cartUser 
)
REFERENCES MEMBER
(
  memberId 
)
ENABLE;

ALTER TABLE CART
ADD CONSTRAINT CART_FK2 FOREIGN KEY
(
  cartProduct 
)
REFERENCES PRODUCT
(
  productNumber 
)
ENABLE;

--MEMBER TABLE »ý¼º
CREATE TABLE MEMBER 
(
  memberId VARCHAR2(20 BYTE) NOT NULL 
, memberPassword VARCHAR2(20 BYTE) NOT NULL 
, memberName VARCHAR2(20 BYTE) NOT NULL 
, memberPhone VARCHAR2(20 BYTE) NOT NULL 
, memberAddress VARCHAR2(255 BYTE) 
, memberEmail VARCHAR2(40 BYTE) 
, memberAuth VARCHAR2(10 BYTE) DEFAULT NULL NOT NULL 
, CONSTRAINT MEMBER_PK PRIMARY KEY 
  (
    memberId 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX MEMBER_PK ON MEMBER (memberId ASC) 
      LOGGING 
      TABLESPACE MASKTBS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE MASKTBS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

----PRODUCT TABLE »ý¼º
CREATE TABLE PRODUCT 
(
  productNumber NUMBER NOT NULL 
, productName VARCHAR2(100 BYTE) NOT NULL 
, productQunt NUMBER NOT NULL 
, productPrice NUMBER NOT NULL 
, ProductSeller VARCHAR2(20 BYTE) NOT NULL 
, CONSTRAINT PRODUCT_PK PRIMARY KEY 
  (
    productNumber 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX PRODUCT_PK ON PRODUCT (productNumber ASC) 
      LOGGING 
      TABLESPACE MASKTBS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE MASKTBS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

ALTER TABLE PRODUCT
ADD CONSTRAINT PRODUCT_FK1 FOREIGN KEY
(
  ProductSeller 
)
REFERENCES MEMBER
(
  memberId 
)
ENABLE;

--SELL TABLE »ý¼º
CREATE TABLE SELL 
(
  sellNumber NUMBER NOT NULL 
, sellProductnumber NUMBER NOT NULL 
, sellDate DATE DEFAULT SYSDATE NOT NULL 
, CONSTRAINT SELL_PK PRIMARY KEY 
  (
    sellNumber 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX SELL_PK ON SELL (sellNumber ASC) 
      LOGGING 
      TABLESPACE MASKTBS 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE MASKTBS 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

ALTER TABLE SELL
ADD CONSTRAINT SELL_FK1 FOREIGN KEY
(
  sellProductnumber 
)
REFERENCES PRODUCT
(
  productNumber 
)
ENABLE;




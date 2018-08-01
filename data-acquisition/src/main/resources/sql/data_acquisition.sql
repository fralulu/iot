-------------------------------------------------
--------T_BAS_FACTOR 监测因子-----------------------
-------------------------------------------------
create table T_BAS_FACTOR
(
  id                 NUMBER(9) not null,
  factor_name        NVARCHAR2(50) not null,
  factor_code        NVARCHAR2(20) not null,
  unit               NVARCHAR2(20),
  upper              NUMBER(10),
  flower             NUMBER(10),
  discrib            NVARCHAR2(100),
  accuracy           NUMBER(9) not null,
  sort               NUMBER(9),
  pollution_factor   NUMBER(1) not null,
  factortype_code    NVARCHAR2(10),
  create_user        INTEGER,
  total_count        INTEGER default 0,
  mol_wt             NUMBER(9),
  factortype_codeoth NVARCHAR2(10),
  factor_code_old    NVARCHAR2(20),
  total_unit         NVARCHAR2(50)
);

alter table T_BAS_FACTOR add primary key (ID);
alter table T_BAS_FACTOR add constraint t_unique_factor_code unique (FACTOR_CODE);

-------------------------------------------------
--------T_CODE_FACTOR_TYPE 监测因子类型--------------
-------------------------------------------------
create table T_CODE_FACTOR_TYPE
(
  id        NUMBER(9) not null,
  type_name NVARCHAR2(50) not null,
  type_code NVARCHAR2(20) not null
);

alter table T_CODE_FACTOR_TYPE   add primary key (ID);

-------------------------------------------------
--------T_BAS_STATION 站点信息----------------------
-------------------------------------------------

create table T_BAS_STATION
(
  id               NUMBER(9) not null,
  station_name     NVARCHAR2(100) not null,
  station_abbr     NVARCHAR2(50) not null,
  address          NVARCHAR2(100),
  build_time       DATE,
  discrib          NVARCHAR2(100),
  longitude        NVARCHAR2(14),
  latitude         NVARCHAR2(14),
  enter_id         NUMBER(9),
  enter_name       NVARCHAR2(50),
  station_number   NVARCHAR2(40) not null,
  sort             NUMBER(9),
  stationtype_code NVARCHAR2(10) not null,
  adm_id           NUMBER(9),
  frequency        NUMBER(9),
  link_state       NUMBER(9),
  over_state       NVARCHAR2(50),
  control_level_id NUMBER(9)
);

alter table T_BAS_STATION add primary key (ID);
alter table T_BAS_STATION  add constraint t_unique_station_number unique (STATION_NUMBER);

-------------------------------------------------
--------T_DATA_PARSE 原始报文数据--------------------
-------------------------------------------------

create table T_DATA_PARSE
(
  station_id   NUMBER(9) not null,
  factor_code  NVARCHAR2(20) not null,
  send_time    DATE not null,
  receive_time DATE not null,
  station_name NVARCHAR2(50),
  enter_name   NVARCHAR2(50),
  factor_name  NVARCHAR2(50),
  value        NUMBER(10,3),
  state        NVARCHAR2(50),
  sign         NVARCHAR2(10)
);
alter table T_DATA_PARSE add constraint PK_T_DATA_PARSE primary key (STATION_ID, FACTOR_CODE, SEND_TIME);

-------------------------------------------------
-------T_DATA_REAL  实时数据------------------------
-------------------------------------------------

create table T_DATA_REAL
(
  station_id   NUMBER(9) not null,
  factor_code  NVARCHAR2(20) not null,
  send_time    DATE not null,
  receive_time DATE not null,
  value        NUMBER(10,3),
  factor_name  NVARCHAR2(50),
  station_name NVARCHAR2(50),
  enter_name   NVARCHAR2(50),
  state        NVARCHAR2(50),
  sign         NVARCHAR2(10)
);

alter table T_DATA_REAL add constraint PK_T_DATA_REAL primary key (STATION_ID, FACTOR_CODE,SEND_TIME);






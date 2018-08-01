/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : 192.168.37.18-dataacquisition
Source Server Version : 110200
Source Host           : 192.168.37.18:1521
Source Schema         : DATA_ACQUISITION

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-07-11 13:25:25
*/


-- ----------------------------
-- Table structure for T_BAS_FACTOR
-- ----------------------------
DROP TABLE "DATA_ACQUISITION"."T_BAS_FACTOR";
CREATE TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" (
"ID" NUMBER(9) NOT NULL ,
"FACTOR_NAME" NVARCHAR2(50) NOT NULL ,
"FACTOR_CODE" NVARCHAR2(20) NOT NULL ,
"UNIT" NVARCHAR2(20) NULL ,
"UPPER" NUMBER(10) NULL ,
"FLOWER" NUMBER(10) NULL ,
"DISCRIB" NVARCHAR2(100) NULL ,
"ACCURACY" NUMBER(9) NOT NULL ,
"SORT" NUMBER(9) NULL ,
"POLLUTION_FACTOR" NUMBER(1) NOT NULL ,
"FACTORTYPE_CODE" NVARCHAR2(10) NULL ,
"CREATE_USER" NUMBER NULL ,
"TOTAL_COUNT" NUMBER DEFAULT 0  NULL ,
"MOL_WT" NUMBER(9) NULL ,
"FACTORTYPE_CODEOTH" NVARCHAR2(10) NULL ,
"FACTOR_CODE_OLD" NVARCHAR2(20) NULL ,
"TOTAL_UNIT" NVARCHAR2(50) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_BAS_FACTOR
-- ----------------------------
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('84', '风速', 'a01007', 'm/s', null, null, null, '3', null, '0', '001', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('85', '反式-2-丁烯', 'a24064', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('86', '顺式-2-丁烯', 'a24063', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('18', '异丁烷', 'a24038', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '58', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('19', '丙烷', 'a24002', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '44', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('20', '1-丁烯', 'a24124', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '56', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('21', '间-二甲苯+对-二甲苯', 'a25098', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '106', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('22', '邻-二甲苯', 'a25006', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '106', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('23', '苯乙烯', 'a25038', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '104', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('24', '苯', 'a25002', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '78', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('25', '甲苯', 'a25003', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '92', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('26', '氯苯', 'a25010', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '112', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('27', '乙苯', 'a25004', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '106', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('28', '1,4-二氯苯', 'a25013', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '147', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('29', '1,3-二氯苯', 'a25012', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '147', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('30', '1,3,5-三甲苯', 'a25021', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '120', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('31', '1,2-二氯苯', 'a25011', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '147', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('32', '1,2,4-三甲苯', 'a25019', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '120', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('33', '顺-1,3-二氯丙烯', 'a24054', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '111', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('34', '顺-1,2-二氯乙烯', 'a24111', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '98', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('35', '氯仿', 'a24004', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '119', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('36', '四氯甲烷', 'a24005', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '154', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('37', '四氯乙烯', 'a24050', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '166', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('38', '反-1,3-二氯丙烯', 'a24112', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '111', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('39', '二氯甲烷', 'a24003', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '85', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('40', '三氯乙烯', 'a24049', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '131', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('41', '1,2-二溴乙烷', 'a24034', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '188', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('42', '1,2-二氯乙烷', 'a24017', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '99', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('43', '1,2-二氯丙烷', 'a24027', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '113', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('44', '1,1-二氯乙烷', 'a24016', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '99', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('45', '1,1,2-三氯乙烷', 'a24019', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '133', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('46', '1,1,1-三氯乙烷', 'a24018', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '133', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('47', '异丙醇', 'a30008', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '60', 'a30000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('48', '四氢呋喃', 'a25072', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '72', 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('49', '乙酸乙酯', 'a29017', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '88', 'a29000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('50', '乙二醇', 'a30006', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '62', 'a30000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('51', '丙酮', 'a31024', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '58', null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('87', '异戊烷', 'a24041', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('88', '正戊烷', 'a24039', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('89', '1 3-丁二烯', 'a24078', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('71', '1,2,3-三甲基苯', 'a25020', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('100', '制冷温度', 'S06', '℃', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('101', '烟道截面积', 'S07', '㎡', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('102', '烟气动压', 'S04', 'KPa', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('70', '正庚烷', 'a24043', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('72', '丙烯', 'a24053', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('73', '2,2,4-三甲基戊烷 ', 'a24012', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('74', '正辛烷', 'a24070', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('75', '异丙苯', 'a25034', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('76', '正丙苯', 'a25033', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('77', '乙烷', 'a24001', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('78', '乙烯', 'a24045', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('79', '乙炔', 'a24079', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('14', '氯气', '11', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', '71', null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('12', '乙醇', 'a30003', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', '46', 'a30000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('15', '甲醇', 'a30001', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', '32', 'a30000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('56', '2-甲基戊烷', 'a24011', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('57', '异戊二烯', 'a24061', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('58', '萘', 'a25059', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('59', '苯酚', 'a23003', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('60', '1,2,4-三氯苯', 'a25015', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a25000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('61', '六氯-1,3-丁二烯', 'a24113', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('62', '硫化氢', 'a21028', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a21000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('63', '汞', 'a20058', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a02000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('64', '二氧化氮', 'a21004', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a21000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('65', '氟化氢', 'a21006', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a21000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('66', '氯化氢', 'a21024', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a21000', '08', null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('67', '二氧化硫', 'a21026', 'mg/m³', null, null, null, '2', null, '1', '002', null, '0', null, 'a21000', '02', null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('68', '二硫化碳', 'a99051', 'mg/m³', null, null, null, '3', null, '0', '002', null, '0', null, 'a99000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('69', '新戊烷', 'a24042', 'ppb', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('8', '风向', 'a01008', '°', null, null, null, '0', null, '0', '001', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('9', '大气压', 'a01006', 'hPa', null, null, null, '1', null, '0', '001', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('10', '温度', 'a01001', '℃', null, null, null, '2', null, '0', '001', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('11', '湿度', 'a01002', '%', null, null, null, '3', null, '0', '001', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('17', '正丁烷', 'a24037', 'ppb', null, null, null, '3', null, '1', '002', null, '0', '58', 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('16', '氨气', 'a21001', 'μg/m³', null, null, null, '3', null, '1', '002', null, '0', '17', 'a21000', '10', null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('52', '非甲烷总烃', 'a24088', 'μg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a24000', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('53', '甲烷', 'a05002', 'μg/m³', null, null, null, '3', null, '1', '002', null, '0', '16', null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5263', '蒸气流量', 'S10', '%', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5264', '烟尘', '01', 'mg/m³', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5265', '烟气温度', 'S03', '℃', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5266', '烟气流速', 'S02', 'm/s', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5267', '氧气含量', 'S01', '％', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5268', '烟气压力', 'S08', 'KPa', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5270', '烟气湿度', 'S05', '%', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5351', 'COD', '011', 'mg/L', null, null, null, '3', null, '1', '003', null, '1', null, null, null, 'kg');
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('54', '废气', 'B02', 'm³/h', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5356', 'pH', '001', '-', '12', '0', null, '0', null, '1', '003', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5357', '氨氮', '060', 'mg/L', null, null, null, '0', null, '1', '003', null, '1', null, null, null, 'kg');
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5358', '流量', 'B01', 'L/s', null, null, null, '0', null, '0', '003', null, '1', null, null, null, 'm³');
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5359', '总铬', '023', 'mg/L', null, null, null, '0', null, '1', '003', null, '1', null, null, null, 'kg');
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5371', '一氧化碳', '04', 'mg/m³', null, null, null, '3', null, '1', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5372', '烟气流量', 'S09', 'mg/m³', null, null, null, '3', null, '0', '004', null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('80', '氮氧化物', 'a21002', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a21000', '03', null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('5379', '总铅', '027', 'mg/L', null, null, null, '2', null, '1', '003', null, '1', null, null, null, 'kg');
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('81', '氟化物 ', 'a21018', 'mg/m³', null, null, null, '3', null, '1', '002', null, '0', null, 'a21000', '06', null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('999', '溶解氧(DO)', 'w01009', 'mg/L', null, null, null, '2', null, '1', null, null, '0', null, 'w01009', null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('998', '化学需氧量(CODcr)', 'w01018', 'mg/L', null, null, null, '2', null, '1', null, null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('997', '浊度', 'w01003', 'mg/L', null, null, null, '2', null, '1', null, null, '0', null, null, null, null);
INSERT INTO "DATA_ACQUISITION"."T_BAS_FACTOR" VALUES ('996', '氨氮', 'w21003', 'mg/L', null, null, null, '2', null, '1', null, null, '0', null, null, null, null);

-- ----------------------------
-- Table structure for T_BAS_STATION
-- ----------------------------
DROP TABLE "DATA_ACQUISITION"."T_BAS_STATION";
CREATE TABLE "DATA_ACQUISITION"."T_BAS_STATION" (
"ID" NUMBER(9) NOT NULL ,
"STATION_NAME" NVARCHAR2(100) NOT NULL ,
"STATION_ABBR" NVARCHAR2(50) NOT NULL ,
"ADDRESS" NVARCHAR2(100) NULL ,
"BUILD_TIME" DATE NULL ,
"DISCRIB" NVARCHAR2(100) NULL ,
"LONGITUDE" NVARCHAR2(14) NULL ,
"LATITUDE" NVARCHAR2(14) NULL ,
"ENTER_ID" NUMBER(9) NULL ,
"ENTER_NAME" NVARCHAR2(50) NULL ,
"STATION_NUMBER" NVARCHAR2(40) NOT NULL ,
"SORT" NUMBER(9) NULL ,
"STATIONTYPE_CODE" NVARCHAR2(10) NOT NULL ,
"ADM_ID" NUMBER(9) NULL ,
"FREQUENCY" NUMBER(9) NULL ,
"LINK_STATE" NUMBER(9) NULL ,
"OVER_STATE" NVARCHAR2(50) NULL ,
"CONTROL_LEVEL_ID" NUMBER(9) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_BAS_STATION
-- ----------------------------
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5397', '奉贤分区南泵站', '奉贤分区南泵站', null, TO_DATE('2018-01-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.528174', '30.837729', '5396', null, '201512210001', null, '0201', '3', '60', '1', 'OR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5398', '奉贤分区大气北边界站', '奉贤分区大气北边界站', '奉贤分区大气北边界站', TO_DATE('2018-01-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.525711', '30.832544', '5396', null, '31010200040602', null, '0101', '3', '60', '0', 'CR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5391', '格瑞夫监测1号站', '格瑞夫监测1号站', null, TO_DATE('2018-01-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.4583682', '30.82518471', '5390', null, '67463190000501', null, '0202', '3', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5908', '远纺工业废气排口C侧', '远纺工业废气排口C侧', null, TO_DATE('2018-02-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5487', '30.8450', '5342', null, '35964021314100', null, '0202', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5384', '民乐路站', '民乐路站', '上海工业区星火园区东边界', TO_DATE('2017-12-21 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.548957', '30.853556', '5399', null, '31011500043311', null, '0101', '5310', '60', '0', 'CR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5383', '莲塘路站', '莲塘路站', '上海工业区星火园区', TO_DATE('2017-12-21 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.531823', '30.843325', '5399', null, '31011500043310', null, '0101', '5310', '60', '0', 'HR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('7440', '蓝宝石酒业', '蓝宝石酒业', '山东省青岛市莱西市龙口东路21号', TO_DATE('2018-06-19 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '120.531190', '36.847750', '7438', null, 'qdlbsjy', null, '0202', '7436', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('15', '上海新华联制药废气东部', '新华联制药废气东部', null, TO_DATE('2017-08-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5354964', '30.8489940', '6', null, '84768870000006', null, '0202', '5310', '60', '0', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('7188', '新奥一期', '新奥一期', null, TO_DATE('2018-05-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '113.382340', '28.230897', '7190', null, '20141009073101', null, '0202', '7186', '60', '0', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5354', '上海天坛助剂有限公司排水口', '天坛助剂排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5271', '30.8517', '5327', null, '76162762012119', null, '0201', '5310', '60', '1', 'HR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5355', '上海特强汽车紧固件有限公司排水口', '特强汽车排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5379', '30.8536', '5331', null, '20102881604007', null, '0201', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5363', '中西三维药业排水口', '中西三维药业排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5492', '30.8609', '5332', null, '20141030003', null, '0201', '5310', '60', '1', 'OR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5364', '上海小西生物技术有限公司排水口', '小西生物技术排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5510', '30.8592', '5335', null, '20141030002', null, '0201', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5365', '上海冠生园蜂制品有限公司排水口', '冠生园蜂制品排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5541', '30.8569', '5337', null, '20141030009', null, '0201', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5366', '上海北连生物科技有限公司排水口', '北连生物科技排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5462', '30.8536', '5338', null, '11452812013001', null, '0201', '5310', '60', '1', 'OR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5367', '帝斯曼维生素排水口', '帝斯曼维生素排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5471', '30.8511', '5339', null, '20141211133011', null, '0201', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('7203', '新奥二期', '新奥二期', null, TO_DATE('2018-05-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '113.38028', '28.241389', '7190', null, '20141216093030', null, '0202', '7186', '60', '0', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5369', '亚东石化有限公司排水口', '亚东石化排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5487', '30.8490', '5341', null, '71093632013121', null, '0202', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5370', '亚东石化排气口A#锅炉', '亚东石化排气口A#锅炉', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5460', '30.8490', '5341', null, '00627000070010', null, '0202', '5310', '60', '0', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5374', '远纺工业排气口A侧', '远纺工业排气口', '远纺工业排气口A侧', TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5487', '30.8458', '5342', null, '0062700C012515', null, '0202', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5375', '远纺工业有限公司排水口', '远纺工业排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5487', '30.84588', '5342', null, '76162762012110', null, '0201', '5310', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5376', '宏远发展(上海)有限公司排水口', '宏远发展排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5472', '30.8455', '5343', null, '76162762012117', null, '0201', '5310', '60', '1', 'OR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5377', '农乐生物制品排水口', '农乐生物制品排水口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5350', '30.8420', '5346', null, '20141030008', null, '0201', '5310', '60', '1', 'OR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5378', '西恩迪蓄电池总排口', '西恩迪蓄电池总排口', null, TO_DATE('2017-11-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5303', '30.8451', '5349', null, '26243840000311', null, '0201', '5310', '60', '1', 'OR', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5392', '格瑞夫监测2号站', '格瑞夫监测2号站', null, TO_DATE('2018-01-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.4563682', '30.82519471', '5390', null, '67463190000502', null, '0202', '3', '60', '0', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5394', '万溯化学', '万溯化学', null, TO_DATE('2018-01-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.44231614', '30.81975796', '5393', null, '76162762012127', null, '0201', '3', '60', '1', 'OK', null);
--- INSERT INTO "DATA_ACQUISITION"."T_BAS_STATION" VALUES ('5473', '上海新华联制药废气西部', '新华联制药废气西部', null, TO_DATE('2018-01-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '121.5411733165', '30.8541971087', '6', null, '84768870000007', null, '0202', '5310', '60', '1', 'OK', null);

-- ----------------------------
-- Table structure for T_CODE_STATION_TYPE
-- ----------------------------
DROP TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE";
CREATE TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" (
"ID" NUMBER(9) NOT NULL ,
"TYPE_NAME" VARCHAR2(50 BYTE) NOT NULL ,
"TYPE_CODE" VARCHAR2(20 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_CODE_STATION_TYPE
-- ----------------------------
INSERT INTO "DATA_ACQUISITION"."T_CODE_STATION_TYPE" VALUES ('1', '废气特征因子', '0101');
INSERT INTO "DATA_ACQUISITION"."T_CODE_STATION_TYPE" VALUES ('2', '污染源废水', '0201');
INSERT INTO "DATA_ACQUISITION"."T_CODE_STATION_TYPE" VALUES ('3', '污染源废气', '0202');

-- ----------------------------
-- Table structure for T_DATA_PARSE
-- ----------------------------
DROP TABLE "DATA_ACQUISITION"."T_DATA_PARSE";
CREATE TABLE "DATA_ACQUISITION"."T_DATA_PARSE" (
"STATION_ID" NUMBER(9) NOT NULL ,
"FACTOR_CODE" NVARCHAR2(20) NOT NULL ,
"SEND_TIME" DATE NOT NULL ,
"RECEIVE_TIME" DATE NOT NULL ,
"STATION_NAME" NVARCHAR2(50) NULL ,
"ENTER_NAME" NVARCHAR2(50) NULL ,
"FACTOR_NAME" NVARCHAR2(50) NULL ,
"VALUE" NUMBER(10,3) NULL ,
"STATE" NVARCHAR2(50) NULL ,
"SIGN" NVARCHAR2(10) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_DATA_PARSE
-- ----------------------------

-- ----------------------------
-- Table structure for T_DATA_REAL
-- ----------------------------
DROP TABLE "DATA_ACQUISITION"."T_DATA_REAL";
CREATE TABLE "DATA_ACQUISITION"."T_DATA_REAL" (
"STATION_ID" NUMBER(9) NOT NULL ,
"FACTOR_CODE" NVARCHAR2(20) NOT NULL ,
"SEND_TIME" DATE NOT NULL ,
"RECEIVE_TIME" DATE NOT NULL ,
"VALUE" NUMBER(10,3) NULL ,
"FACTOR_NAME" NVARCHAR2(50) NULL ,
"STATION_NAME" NVARCHAR2(50) NULL ,
"ENTER_NAME" NVARCHAR2(50) NULL ,
"STATE" NVARCHAR2(50) NULL ,
"SIGN" NVARCHAR2(10) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_DATA_REAL
-- ----------------------------

-- ----------------------------
-- Sequence structure for SEQ_WP
-- ----------------------------
DROP SEQUENCE "DATA_ACQUISITION"."SEQ_WP";
CREATE SEQUENCE "DATA_ACQUISITION"."SEQ_WP"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 7575
 CACHE 10;

-- ----------------------------
-- Indexes structure for table T_BAS_FACTOR
-- ----------------------------

-- ----------------------------
-- Uniques structure for table T_BAS_FACTOR
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD UNIQUE ("FACTOR_CODE");

-- ----------------------------
-- Checks structure for table T_BAS_FACTOR
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("FACTOR_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("FACTOR_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("ACCURACY" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("POLLUTION_FACTOR" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("FACTOR_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("FACTOR_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("ACCURACY" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD CHECK ("POLLUTION_FACTOR" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_BAS_FACTOR
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_BAS_FACTOR" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table T_BAS_STATION
-- ----------------------------

-- ----------------------------
-- Uniques structure for table T_BAS_STATION
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD UNIQUE ("STATION_NUMBER");

-- ----------------------------
-- Checks structure for table T_BAS_STATION
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATION_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATION_ABBR" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATION_NUMBER" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATIONTYPE_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATION_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATION_ABBR" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATION_NUMBER" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD CHECK ("STATIONTYPE_CODE" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_BAS_STATION
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_BAS_STATION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table T_CODE_STATION_TYPE
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_CODE_STATION_TYPE
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("TYPE_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("TYPE_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("TYPE_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("TYPE_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("TYPE_NAME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK ("TYPE_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK (ID IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK (Type_Name IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD CHECK (Type_Code IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_CODE_STATION_TYPE
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_CODE_STATION_TYPE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table T_DATA_PARSE
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DATA_PARSE
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("STATION_ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("FACTOR_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("SEND_TIME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("RECEIVE_TIME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("STATION_ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("FACTOR_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("SEND_TIME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD CHECK ("RECEIVE_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DATA_PARSE
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_DATA_PARSE" ADD PRIMARY KEY ("STATION_ID", "FACTOR_CODE", "SEND_TIME");

-- ----------------------------
-- Indexes structure for table T_DATA_REAL
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_DATA_REAL
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("STATION_ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("FACTOR_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("SEND_TIME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("RECEIVE_TIME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("STATION_ID" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("FACTOR_CODE" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("SEND_TIME" IS NOT NULL);
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD CHECK ("RECEIVE_TIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_DATA_REAL
-- ----------------------------
ALTER TABLE "DATA_ACQUISITION"."T_DATA_REAL" ADD PRIMARY KEY ("STATION_ID", "FACTOR_CODE", "SEND_TIME");

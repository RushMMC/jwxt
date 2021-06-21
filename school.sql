-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shl_class`
--

DROP TABLE IF EXISTS `shl_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_class` (
  `cla_no` char(8) NOT NULL COMMENT '班级代码',
  `cla_grade` year(4) DEFAULT NULL COMMENT '年级',
  `cla_name` char(20) DEFAULT NULL COMMENT '班级名称',
  `cla_level` char(4) DEFAULT '专科' COMMENT '学历层次',
  `cla_stype` char(4) DEFAULT '三年制' COMMENT '学生类别',
  `maj_no` char(7) DEFAULT NULL COMMENT '所属专业',
  PRIMARY KEY (`cla_no`),
  KEY `cla_maj_no_fk` (`maj_no`),
  CONSTRAINT `cla_maj_no_fk` FOREIGN KEY (`maj_no`) REFERENCES `shl_major` (`maj_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_class`
--

LOCK TABLES `shl_class` WRITE;
/*!40000 ALTER TABLE `shl_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_course`
--

DROP TABLE IF EXISTS `shl_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_course` (
  `cour_no` varchar(8) NOT NULL COMMENT '课程代码',
  `cty_no` int(11) DEFAULT NULL COMMENT '分类编号',
  `cour_name` varchar(25) DEFAULT NULL COMMENT '课程名称',
  `cour_credit` decimal(3,1) DEFAULT NULL COMMENT '学分',
  `cour_ctime` int(11) DEFAULT NULL COMMENT '学时',
  `cour_open_team` char(1) DEFAULT NULL COMMENT '修读学期',
  `cour_is_require` char(1) DEFAULT '是',
  `dept_no` char(2) DEFAULT NULL COMMENT '开课院系',
  `cour_remark` char(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cour_no`),
  KEY `cour_cty_no_fk` (`cty_no`),
  KEY `cour_dept_no_fk` (`dept_no`),
  CONSTRAINT `cour_cty_no_fk` FOREIGN KEY (`cty_no`) REFERENCES `shl_course_type` (`cty_no`),
  CONSTRAINT `cour_dept_no_fk` FOREIGN KEY (`dept_no`) REFERENCES `shl_dept` (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_course`
--

LOCK TABLES `shl_course` WRITE;
/*!40000 ALTER TABLE `shl_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_course_type`
--

DROP TABLE IF EXISTS `shl_course_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_course_type` (
  `cty_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  `cty_name` varchar(8) DEFAULT NULL COMMENT '课程分类名',
  PRIMARY KEY (`cty_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='课程类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_course_type`
--

LOCK TABLES `shl_course_type` WRITE;
/*!40000 ALTER TABLE `shl_course_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_dept`
--

DROP TABLE IF EXISTS `shl_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_dept` (
  `dept_no` char(2) NOT NULL COMMENT '院系代码',
  `dept_name` char(20) DEFAULT NULL COMMENT '院系名称',
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_dept`
--

LOCK TABLES `shl_dept` WRITE;
/*!40000 ALTER TABLE `shl_dept` DISABLE KEYS */;
INSERT INTO `shl_dept` VALUES ('01','软件工程系');
/*!40000 ALTER TABLE `shl_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_major`
--

DROP TABLE IF EXISTS `shl_major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_major` (
  `maj_no` char(7) NOT NULL COMMENT '专业代码',
  `maj_name` char(20) DEFAULT NULL COMMENT '专业名称',
  `dept_no` char(2) DEFAULT NULL COMMENT '院系代码',
  PRIMARY KEY (`maj_no`),
  KEY `maj_dept_no_fk` (`dept_no`),
  CONSTRAINT `maj_dept_no_fk` FOREIGN KEY (`dept_no`) REFERENCES `shl_dept` (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_major`
--

LOCK TABLES `shl_major` WRITE;
/*!40000 ALTER TABLE `shl_major` DISABLE KEYS */;
INSERT INTO `shl_major` VALUES ('001','网络技术','01'),('003','网络技术','01'),('004','网络技术','01'),('005','网络技术','01');
/*!40000 ALTER TABLE `shl_major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_score`
--

DROP TABLE IF EXISTS `shl_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_score` (
  `team_no` int(11) NOT NULL COMMENT '学期编号',
  `stu_no` varchar(9) NOT NULL COMMENT '学号',
  `cour_no` varchar(8) NOT NULL COMMENT '课程代码',
  `sco_peacetime` int(11) DEFAULT NULL COMMENT '平时成绩',
  `sco_team_end` int(11) DEFAULT NULL COMMENT '期末成绩',
  `sco_overall` decimal(5,2) DEFAULT NULL COMMENT '总评',
  PRIMARY KEY (`team_no`,`stu_no`,`cour_no`),
  KEY `sco_cour_no_fk` (`cour_no`),
  KEY `sco_stu_no_fk` (`stu_no`),
  CONSTRAINT `sco_cour_no_fk` FOREIGN KEY (`cour_no`) REFERENCES `shl_course` (`cour_no`),
  CONSTRAINT `sco_stu_no_fk` FOREIGN KEY (`stu_no`) REFERENCES `shl_student` (`stu_no`),
  CONSTRAINT `sco_team_no_fk` FOREIGN KEY (`team_no`) REFERENCES `shl_team` (`team_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_score`
--

LOCK TABLES `shl_score` WRITE;
/*!40000 ALTER TABLE `shl_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_student`
--

DROP TABLE IF EXISTS `shl_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_student` (
  `stu_no` varchar(9) NOT NULL COMMENT '学号',
  `stu_name` varchar(5) DEFAULT NULL COMMENT '姓名',
  `stu_sex` char(1) DEFAULT '女' COMMENT '性别',
  `stu_brithday` char(6) DEFAULT NULL COMMENT '出生年月',
  `cla_no` char(8) DEFAULT NULL COMMENT '班级编号',
  PRIMARY KEY (`stu_no`),
  KEY `stu_cla_no_fk` (`cla_no`),
  CONSTRAINT `stu_cla_no_fk` FOREIGN KEY (`cla_no`) REFERENCES `shl_class` (`cla_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_student`
--

LOCK TABLES `shl_student` WRITE;
/*!40000 ALTER TABLE `shl_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_teach`
--

DROP TABLE IF EXISTS `shl_teach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_teach` (
  `tea_no` char(5) NOT NULL COMMENT '教师号',
  `team_no` int(11) NOT NULL COMMENT '学期编号',
  `cour_no` varchar(8) NOT NULL COMMENT '课程号',
  `cla_no` char(8) NOT NULL COMMENT '班级号',
  `te_lession_time` char(20) NOT NULL COMMENT '上课时间',
  `te_lession_addr` char(20) DEFAULT NULL COMMENT '上课地点',
  PRIMARY KEY (`tea_no`,`team_no`,`cour_no`,`cla_no`),
  KEY `te_cla_no_fk` (`cla_no`),
  KEY `te_team_no_fk` (`team_no`),
  KEY `te_cour_no_fk` (`cour_no`),
  CONSTRAINT `te_cla_no_fk` FOREIGN KEY (`cla_no`) REFERENCES `shl_class` (`cla_no`),
  CONSTRAINT `te_cour_no_fk` FOREIGN KEY (`cour_no`) REFERENCES `shl_course` (`cour_no`),
  CONSTRAINT `te_tea_no_fk` FOREIGN KEY (`tea_no`) REFERENCES `shl_teacher` (`tea_no`),
  CONSTRAINT `te_team_no_fk` FOREIGN KEY (`team_no`) REFERENCES `shl_team` (`team_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师授课表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_teach`
--

LOCK TABLES `shl_teach` WRITE;
/*!40000 ALTER TABLE `shl_teach` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_teach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_teacher`
--

DROP TABLE IF EXISTS `shl_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_teacher` (
  `tea_no` char(5) NOT NULL COMMENT '教师编号',
  `tea_name` char(10) DEFAULT NULL COMMENT '教师姓名',
  `tea_professional` char(6) DEFAULT NULL COMMENT '职称',
  `dept_no` char(2) DEFAULT NULL COMMENT '院系编号',
  PRIMARY KEY (`tea_no`),
  KEY `tea_dept_no_fk` (`dept_no`),
  CONSTRAINT `tea_dept_no_fk` FOREIGN KEY (`dept_no`) REFERENCES `shl_dept` (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_teacher`
--

LOCK TABLES `shl_teacher` WRITE;
/*!40000 ALTER TABLE `shl_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shl_team`
--

DROP TABLE IF EXISTS `shl_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shl_team` (
  `team_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '学期编号',
  `team_year` char(9) DEFAULT NULL COMMENT '学年度',
  `team_team` char(2) DEFAULT NULL COMMENT '学期',
  PRIMARY KEY (`team_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='学期表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shl_team`
--

LOCK TABLES `shl_team` WRITE;
/*!40000 ALTER TABLE `shl_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `shl_team` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-16 11:59:33

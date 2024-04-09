/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : mvc_wanshun

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 01/12/2022 22:25:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL COMMENT '管理员ID号',
  `password` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '12345' COMMENT '密码',
  `admin_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '管理员姓名',
  `profile_img` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `gender` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '性别',
  `email` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `admin_desc` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简介',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `key_admin`(`admin_id`) USING BTREE COMMENT '设置admin_id为唯一标识'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2333, 'wanshun', 'wanshun', '\\imageUpload\\item\\admin\\2333\\2022120122011069363.png', '男', 'wanshun@163.com', '超级管理员-wanshun', '2022-12-01 21:09:00', '2022-12-01 22:01:11');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `clazz_id` int NOT NULL COMMENT '班级ID号',
  `clazz_number` int NOT NULL COMMENT '班级人数',
  `clazz_desc` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简介',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`clazz_id`) USING BTREE,
  UNIQUE INDEX `key_clazz_id`(`clazz_id`) USING BTREE COMMENT '设置clazz_id为唯一标识'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1701, 40, '信息工程学院1班', '2022-12-01 21:09:00', NULL);
INSERT INTO `clazz` VALUES (1702, 40, '信息工程学院2班', '2022-12-01 21:09:00', NULL);
INSERT INTO `clazz` VALUES (1703, 45, '信息工程学院3班', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `clazz` VALUES (1704, 55, '信息工程学院4班', '2022-12-01 21:09:00', NULL);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int NOT NULL AUTO_INCREMENT COMMENT '课程ID号',
  `course_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '课程名称',
  `course_desc` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简介',
  `teacher_id` int NOT NULL COMMENT '教师ID号',
  `course_size` int NOT NULL COMMENT '课程容量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`course_id`) USING BTREE,
  INDEX `fk_teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '操作系统', '学习本门课程的目标是了解并掌握计算机操作系统的基本概念、基本理论和基础技术。', 11, 100, '2022-12-01 21:09:00', NULL);
INSERT INTO `course` VALUES (2, '软件工程', '软件工程是一门研究用工程化方法构建和维护有效的、实用的和高质量的软件的学科。', 11, 80, '2022-12-01 21:09:00', NULL);
INSERT INTO `course` VALUES (3, '软件测试', '研究各种软件测试方法，如黑盒测试、白盒测试等', 22, 60, '2022-12-01 21:09:00', NULL);
INSERT INTO `course` VALUES (4, 'JavaEE', '学习各种框架，spring、springmvc等', 555, 50, '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `course` VALUES (5, '数据库设计', '对于一个给定的应用环境，构造最优的数据库模式，建立数据库及其应用系统，使之能够有效地存储数据，满足各种用户的应用需求', 22, 60, '2022-12-01 21:09:00', NULL);
INSERT INTO `course` VALUES (6, '软件体系结构', '软件体系结构是具有一定形式的结构化元素，即构件的集合，包括处理构件、数据构件和连接构件。处理构件负责对数据进行加工，数据构件是被加工的信息，连接构件把体系结构的不同部分组合连接起来。这一定义注重区分处理构件、数据构件和连接构件，这一方法在其他的定义和方法中基本上得到保持。相比较于“软件架构”,“软件体系结构”一词多用于学术研究领域使用，“软件架构”多用于工程实践领域，二者的外文名都是“software architecture”，在IEEE中的定义均为：“一个系统的基础组织，包含各个构件、构件互相之间与环境的关系，还有指导其设计和演化的原则。', 33, 50, '2022-12-01 21:09:00', NULL);
INSERT INTO `course` VALUES (7, '计算机网络', '计算机网络是指将地理位置不同的具有独立功能的多台计算机及其外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件及网络通信协议的管理和协调下，实现资源共享和信息传递的计算机系统。', 2222, 44, '2022-12-01 21:09:00', NULL);

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `homework_id` int NOT NULL AUTO_INCREMENT COMMENT '作业ID号',
  `homework_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '作业名称',
  `homework_desc` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作业详细要求',
  `course_id` int NOT NULL COMMENT '课程ID号',
  `homework_file` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作业要求文件',
  `submit_time` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作业提交截至时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`homework_id`) USING BTREE,
  INDEX `fk_homework_course`(`course_id`) USING BTREE,
  CONSTRAINT `fk_homework_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, '操作系统第一次作业', '计算机配置操作系统的作用是什么？', 1, '\\fileUpload\\item\\homework\\8\\2020082223423698137.docx', '2022-12-01 21:09:00', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `homework` VALUES (2, '软件测试第一次作业', '黑白盒测试什么意思', 3, '\\fileUpload\\item\\homework\\7\\2020082122213466832.txt', '2022-12-01 21:09:00', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `homework` VALUES (3, '操作系统第二次作业', '什么情况会引起进程的创建？什么情况会引起进程的终止？', 1, '\\fileUpload\\item\\homework\\8\\2020082223423698137.docx', '2022-12-01 21:09:00', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `homework` VALUES (6, '软件工程的第一次作业', '设计仓库管理系统用例图', 2, '\\fileUpload\\item\\homework\\8\\2020082223423698137.docx', '2022-12-01 21:09:00', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `homework` VALUES (7, '软件工程大作业', '设计ER图', 2, '\\fileUpload\\item\\homework\\7\\2020082122213466832.txt', '2022-12-01 21:09:00', '2022-12-01 21:09:00', NULL);
INSERT INTO `homework` VALUES (8, '操作系统大作业', '银行家算法', 1, '\\fileUpload\\item\\homework\\8\\2020082223423698137.docx', '2022-12-01 21:09:00', '2022-12-01 21:09:00', NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int NOT NULL COMMENT '学生ID号',
  `password` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '12345' COMMENT '密码',
  `student_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '学生姓名',
  `profile_img` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `gender` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '性别',
  `email` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `student_desc` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简介',
  `clazz_id` int NULL DEFAULT NULL COMMENT '班级ID号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近一次修改时间',
  PRIMARY KEY (`student_id`) USING BTREE,
  UNIQUE INDEX `key_student_id`(`student_id`) USING BTREE COMMENT '设置student_id为唯一标识',
  INDEX `fk_student_class`(`clazz_id`) USING BTREE,
  CONSTRAINT `fk_student_class` FOREIGN KEY (`clazz_id`) REFERENCES `clazz` (`clazz_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (11, '12345', 'wanshun', '\\imageUpload\\item\\student\\11\\2022120122221144899.png', '男', 'wanshun@qq.com', 'xx大学本科生，成绩优异', 1701, '2022-12-01 21:09:00', '2022-12-01 22:22:12');
INSERT INTO `student` VALUES (22, '12345', '俊杰', '\\imageUpload\\item\\student\\22\\2022071821341737967.jpg', '女', 'junjie@qq.com', '信息工程学院大三', 1701, '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `student` VALUES (33, '12345', '一平', '\\imageUpload\\item\\student\\33\\2020082409293774996.png', '女', 'yiping@qq.com', '软件学院大三学生', 1702, '2022-12-01 21:09:00', NULL);
INSERT INTO `student` VALUES (17301053, '12345', '万乐乐', '\\imageUpload\\item\\student\\17301053\\2020081612312717926.png', '男', 'wanlele@qq.com', '大四学生，学习成绩优异', 1702, '2022-12-01 21:09:00', '2022-12-01 21:09:00');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `student_course_id` int NOT NULL AUTO_INCREMENT COMMENT '学生选课ID号',
  `course_id` int NOT NULL COMMENT '课程ID号',
  `student_id` int NOT NULL COMMENT '学生ID号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`student_course_id`) USING BTREE,
  INDEX `fk_stc_course`(`course_id`) USING BTREE,
  INDEX `fk_stc_student`(`student_id`) USING BTREE,
  CONSTRAINT `fk_stc_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_stc_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES (1, 1, 11, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (2, 2, 11, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (3, 1, 22, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (4, 1, 17301053, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (5, 3, 22, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (6, 3, 11, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (7, 4, 22, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (8, 5, 22, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (9, 4, 17301053, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (10, 7, 17301053, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (11, 6, 33, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (12, 6, 22, '2022-12-01 21:09:00', NULL);
INSERT INTO `student_course` VALUES (13, 5, 33, '2022-12-01 21:09:00', NULL);

-- ----------------------------
-- Table structure for student_homework
-- ----------------------------
DROP TABLE IF EXISTS `student_homework`;
CREATE TABLE `student_homework`  (
  `student_homework_id` int NOT NULL AUTO_INCREMENT COMMENT '学生作业ID号',
  `homework_id` int NOT NULL COMMENT '作业ID号',
  `student_id` int NOT NULL COMMENT '学生ID号',
  `submit_content` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作业提交内容',
  `submit_file` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作业提交文件',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`student_homework_id`) USING BTREE,
  INDEX `fk_sth_student`(`student_id`) USING BTREE,
  INDEX `fk_sth_homework`(`homework_id`) USING BTREE,
  CONSTRAINT `fk_sth_homework` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`homework_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_sth_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of student_homework
-- ----------------------------
INSERT INTO `student_homework` VALUES (1, 1, 11, '不会', '\\fileUpload\\item\\studentHomework\\1\\2020082323470290307.png', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `student_homework` VALUES (2, 1, 22, '123', '\\fileUpload\\item\\studentHomework\\1\\2020082323470290307.png', '2022-12-01 21:09:00', NULL);
INSERT INTO `student_homework` VALUES (3, 2, 22, '会但不想写', '\\fileUpload\\item\\studentHomework\\1\\2020082323470290307.png', '2022-12-01 21:09:00', NULL);
INSERT INTO `student_homework` VALUES (4, 3, 11, '加油', '\\fileUpload\\item\\studentHomework\\1\\2020082323470290307.png', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `student_homework` VALUES (6, 8, 11, '200', '\\fileUpload\\item\\studentHomework\\1\\2020082323470290307.png', '2022-12-01 21:09:00', NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int NOT NULL COMMENT '教师ID号',
  `password` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '12345' COMMENT '密码',
  `teacher_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '教师姓名',
  `profile_img` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `gender` varchar(4) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '性别',
  `email` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `teacher_desc` varchar(1024) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '简介',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_edit_time` datetime(0) NULL DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  UNIQUE INDEX `key_teacher_id`(`teacher_id`) USING BTREE COMMENT '设置teacher_id为唯一标识'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (11, '12345', '李四', '\\imageUpload\\item\\teacher\\11\\2022120122224921563.png', '男', 'lisi@qq.com', '在xx大学任教四年', '2022-12-01 21:09:00', '2022-12-01 22:22:49');
INSERT INTO `teacher` VALUES (22, '12345', '王五', NULL, '男', 'wangwu@qq.com', '某知名大学副教授', '2022-12-01 21:09:00', '2022-12-01 21:09:00');
INSERT INTO `teacher` VALUES (33, '12345', '张三', '\\imageUpload\\item\\teacher\\33\\2020081611271194545.png', '女', 'zhangsan@qq.com', '讲师', '2022-12-01 21:09:00', NULL);
INSERT INTO `teacher` VALUES (555, '12345', '老刘', '\\imageUpload\\item\\teacher\\555\\2020081417193082484.png', '女', 'laoliu@qq.com', '教授，任职两年', '2022-12-01 21:09:00', NULL);
INSERT INTO `teacher` VALUES (2222, '12345', '东方', '\\imageUpload\\item\\teacher\\2222\\2020082409252932632.png', '男', 'dongfang@qq.com', '助教', '2022-12-01 21:09:00', NULL);

SET FOREIGN_KEY_CHECKS = 1;

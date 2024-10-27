/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80025 (8.0.25)
 Source Host           : localhost:3306
 Source Schema         : programer

 Target Server Type    : MySQL
 Target Server Version : 80025 (8.0.25)
 File Encoding         : 65001

 Date: 27/10/2024 14:59:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'zhangsan', 'zhangsan123', '张1212', 'zhangsan@example.com', '13800138000', '北京市朝阳区', '2024-01-01 10:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (2, 'lisi', 'lisi456', '李四', 'lisi@example.com', '13900139000', '上海市浦东新区', '2024-01-02 11:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (3, 'wangwu', 'wangwu789', '王五', 'wangwu@example.com', '13700137000', '广东省广州市天河区', '2024-01-03 12:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'zhaoliu', 'zhaoliu012', '赵六', 'zhaoliu@example.com', '13600136000', '江苏省南京市玄武区', '2024-01-04 13:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (5, 'qianqi', 'qianqi345', '钱七', 'qianqi@example.com', '13500135000', '浙江省杭州市西湖区', '2024-01-05 14:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (6, 'zhouba', 'zhouba678', '周八', 'zhouba@example.com', '13400134000', '四川省成都市青羊区', '2024-01-06 15:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (7, 'wuxiu', 'wuxiu901', '吴九', 'wuxiu@example.com', '13300133000', '湖北省武汉市武昌区', '2024-01-07 16:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (8, 'zhengshi', 'zhengshi234', '郑十', 'zhengshi@example.com', '13200132000', '陕西省西安市碑林区', '2024-01-08 17:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (9, 'jiangshiyi', 'jiangshiyi567', '姜十一', 'jiangshiyi@example.com', '13100131000', '辽宁省沈阳市和平区', '2024-01-09 18:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (10, 'limoushi', 'limoushi890', '林十二', 'limoushi@example.com', '13000130000', '福建省厦门市思明区', '2024-01-10 19:00:00', NULL, NULL);
INSERT INTO `sys_user` VALUES (12, '啊啊啊啊啊啊啊啊啊啊啊', NULL, '嗷嗷', '1585441936@qq.com', '13684462641', 'the-program-dog-has-no-spring', NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (13, '1', NULL, NULL, NULL, NULL, '3', NULL, NULL, 13);
INSERT INTO `sys_user` VALUES (14, '是的哇', '恶趣味', NULL, NULL, NULL, '1', NULL, NULL, 212);
INSERT INTO `sys_user` VALUES (17, '122', NULL, '121', NULL, NULL, 'the-program-dog-has-no-spring', NULL, NULL, 23);
INSERT INTO `sys_user` VALUES (19, 'asas', NULL, '12', NULL, NULL, 'the-program-dog-has-no-spring', NULL, '女', 12);
INSERT INTO `sys_user` VALUES (20, 'qwqwqw', 'wqwqwq', 'wqwqw', NULL, NULL, '东土大唐', NULL, '未知', 123);
INSERT INTO `sys_user` VALUES (21, '12', '12', NULL, NULL, NULL, 'the-program-dog-has-no-spring', NULL, '男', 14);
INSERT INTO `sys_user` VALUES (23, '12212212', '1212', '1212', NULL, NULL, 'the-program-dog-has-no-spring', NULL, '男', 16);
INSERT INTO `sys_user` VALUES (24, 'q', 'q', 'q', NULL, NULL, 'qqq', NULL, '男', 18);
INSERT INTO `sys_user` VALUES (25, '测试123123', '123', '123', NULL, NULL, '123', NULL, '未知', 123);
INSERT INTO `sys_user` VALUES (26, '11', '11', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

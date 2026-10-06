-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2026-10-07 02:26:49
-- 服务器版本： 5.7.26
-- PHP 版本： 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `coupon_system`
--

-- --------------------------------------------------------

--
-- 表的结构 `activities`
--

CREATE TABLE `activities` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_by` bigint(20) UNSIGNED NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `activities`
--

INSERT INTO `activities` (`id`, `name`, `start_time`, `end_time`, `status`, `created_by`, `created_at`) VALUES
(1, '3D打印体验活动', '2026-10-01 09:00:00', '2026-10-01 17:00:00', 0, 1, '2026-09-22 18:19:00'),
(2, '修改后的3D打印活动', '2026-10-05 09:00:00', '2026-10-05 18:00:00', 1, 1, '2026-09-22 18:23:39'),
(3, '扫码核销测试活动', '2026-09-23 00:00:00', '2026-12-31 23:59:59', 1, 1, '2026-09-23 19:24:09'),
(4, '扫码核销测试活动2', '2026-10-10 09:00:00', '2026-10-10 17:00:00', 0, 1, '2026-09-24 11:35:05'),
(5, '扫码核销测试活动2', '2026-10-10 09:00:00', '2026-10-10 17:00:00', 0, 1, '2026-09-24 11:35:37'),
(6, '扫码核销测试活动2', '2026-10-10 09:00:00', '2026-10-10 17:00:00', 0, 1, '2026-09-24 11:35:39'),
(7, '扫码核销测试活动', '2026-09-26 00:00:00', '2026-12-31 23:59:59', 1, 1, '2026-09-26 19:22:13');

-- --------------------------------------------------------

--
-- 表的结构 `admins`
--

CREATE TABLE `admins` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `admins`
--

INSERT INTO `admins` (`id`, `username`, `password_hash`, `name`, `created_at`) VALUES
(1, 'admin001', 'scrypt:32768:8:1$pwxd9NsOJw1h7VGh$c4c11966feb470e489c03562337298406ee05a46235202897562c02d2ab8426c8690cc731cb44b2cefb4ee6fa7d15ee0a9f85dbfaf9b99dcbd119755ab1a7291', '管理员测试', '2026-09-22 18:16:58'),
(2, 'admin002', 'test_hash_002', '管理员2', '2026-09-23 17:15:19');

-- --------------------------------------------------------

--
-- 表的结构 `coupons`
--

CREATE TABLE `coupons` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `activity_id` bigint(20) UNSIGNED NOT NULL,
  `token` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `issued_by` bigint(20) UNSIGNED NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `verified_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `coupons`
--

INSERT INTO `coupons` (`id`, `user_id`, `activity_id`, `token`, `status`, `valid_from`, `valid_to`, `issued_by`, `created_at`, `verified_at`) VALUES
(1, 1, 1, 'TEST-COUPON-001', 1, '2026-09-22 00:00:00', '2026-09-23 23:59:59', 1, '2026-09-22 18:24:37', '2026-09-22 22:35:19'),
(10, 1, 2, 'VHCEBI0RcFEjTasABsOvUg', 0, '2026-10-01 09:00:00', '2026-10-01 17:00:00', 1, '2026-09-23 16:56:59', NULL),
(11, 1, 2, '9yvd7G6C1BbreN3Mt1js6Q', 0, '2026-10-01 09:00:00', '2026-10-01 17:00:00', 1, '2026-09-23 17:04:31', NULL),
(12, 1, 2, 'PMJl_rUxchLb0yfUi4MVJw', 0, '2026-10-01 09:00:00', '2026-10-01 17:00:00', 1, '2026-09-23 17:09:36', NULL),
(13, 1, 1, 'c9LkZcYKiy2ezl7fv3Qobw', 0, '2026-10-01 09:00:00', '2026-10-01 17:00:00', 1, '2026-09-23 17:13:36', NULL),
(14, 1, 1, '1c7hmSapi3pZEQNQvCavnQ', 1, '2026-09-01 00:00:00', '2026-12-31 23:59:59', 2, '2026-09-23 17:18:22', '2026-09-23 17:24:13'),
(15, 1, 2, 'TEST-DEVICE-COUPON-001', 1, '2026-09-23 00:00:00', '2026-12-31 23:59:59', 1, '2026-09-23 19:24:37', '2026-09-23 19:36:40'),
(16, 1, 7, 'u_49907g1P-P8XnpQqBM2Q', 1, '2026-09-26 00:00:00', '2026-12-31 23:59:59', 1, '2026-09-26 19:23:27', '2026-09-26 19:28:00');

-- --------------------------------------------------------

--
-- 表的结构 `devices`
--

CREATE TABLE `devices` (
  `id` bigint(20) NOT NULL,
  `device_code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `device_key` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint(4) DEFAULT '1',
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `devices`
--

INSERT INTO `devices` (`id`, `device_code`, `device_key`, `name`, `status`, `created_at`) VALUES
(1, 'DEVICE-001', 'TEST-DEVICE-KEY-001', '现场扫码机1号', 1, '2026-09-23 19:11:15');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `student_no` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `student_no`, `name`, `created_at`) VALUES
(1, '20260001', '张三', '2026-09-22 18:17:40'),
(2, '20260002', '李四', '2026-09-26 20:02:46'),
(3, '2026003', '万物', '2026-09-26 23:48:04'),
(4, '2026004', '万物', '2026-09-26 23:58:14'),
(5, '2026002', '李四', '2026-09-27 00:04:17'),
(6, '2026006', '李四', '2026-09-27 00:06:04'),
(7, '2026005', '王丽', '2026-09-27 00:27:20'),
(8, '2026012', '武大', '2026-09-27 18:48:27');

-- --------------------------------------------------------

--
-- 表的结构 `verifiers`
--

CREATE TABLE `verifiers` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `verifiers`
--

INSERT INTO `verifiers` (`id`, `username`, `password_hash`, `name`, `created_at`) VALUES
(1, 'verifier001', 'test_hash', '核销员测试', '2026-09-22 18:28:04');

-- --------------------------------------------------------

--
-- 表的结构 `verify_logs`
--

CREATE TABLE `verify_logs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `coupon_id` bigint(20) UNSIGNED DEFAULT NULL,
  `device_id` bigint(20) NOT NULL,
  `result` varchar(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `verify_logs`
--

INSERT INTO `verify_logs` (`id`, `coupon_id`, `device_id`, `result`, `message`, `created_at`) VALUES
(11, 15, 1, 'success', '核销成功', '2026-09-23 19:25:27'),
(12, 15, 1, 'success', '核销成功', '2026-09-23 19:31:00'),
(13, 15, 1, 'success', '核销成功', '2026-09-23 19:34:42'),
(14, 15, 1, 'success', '核销成功', '2026-09-23 19:36:40'),
(15, NULL, 1, 'failed', '券不存在', '2026-09-24 01:03:40'),
(16, 16, 1, 'success', '核销成功', '2026-09-26 19:28:00');

--
-- 转储表的索引
--

--
-- 表的索引 `activities`
--
ALTER TABLE `activities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_activities_created_by` (`created_by`);

--
-- 表的索引 `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- 表的索引 `coupons`
--
ALTER TABLE `coupons`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `token` (`token`),
  ADD KEY `fk_coupons_user` (`user_id`),
  ADD KEY `fk_coupons_activity` (`activity_id`),
  ADD KEY `fk_coupons_issued_by` (`issued_by`);

--
-- 表的索引 `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `device_code` (`device_code`),
  ADD UNIQUE KEY `device_key` (`device_key`);

--
-- 表的索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `student_no` (`student_no`);

--
-- 表的索引 `verifiers`
--
ALTER TABLE `verifiers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- 表的索引 `verify_logs`
--
ALTER TABLE `verify_logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_verify_logs_coupon` (`coupon_id`),
  ADD KEY `fk_verify_logs_device` (`device_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `activities`
--
ALTER TABLE `activities`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `admins`
--
ALTER TABLE `admins`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `coupons`
--
ALTER TABLE `coupons`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- 使用表AUTO_INCREMENT `devices`
--
ALTER TABLE `devices`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `verifiers`
--
ALTER TABLE `verifiers`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `verify_logs`
--
ALTER TABLE `verify_logs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- 限制导出的表
--

--
-- 限制表 `activities`
--
ALTER TABLE `activities`
  ADD CONSTRAINT `fk_activities_created_by` FOREIGN KEY (`created_by`) REFERENCES `admins` (`id`) ON UPDATE CASCADE;

--
-- 限制表 `coupons`
--
ALTER TABLE `coupons`
  ADD CONSTRAINT `fk_coupons_activity` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_coupons_issued_by` FOREIGN KEY (`issued_by`) REFERENCES `admins` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_coupons_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- 限制表 `verify_logs`
--
ALTER TABLE `verify_logs`
  ADD CONSTRAINT `fk_verify_logs_coupon` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`id`),
  ADD CONSTRAINT `fk_verify_logs_device` FOREIGN KEY (`device_id`) REFERENCES `devices` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


CREATE TABLE `tb_choujiang_activity` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `activity_name` varchar(30) NOT NULL DEFAULT '' COMMENT '活动名称',
  `activity_info` varchar(200) NOT NULL DEFAULT '' COMMENT '活动描述',
  `start_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动开始时间',
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '活动结束时间',
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抽奖活动表'



CREATE TABLE `tb_choujiang_prize` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `prize_type` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '1.实物奖品, 2.虚拟奖品',
  `activity_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '活动ID',
  `prize_name` varchar(30) NOT NULL DEFAULT '' COMMENT '奖品名称',
  `prize_info` varchar(200) NOT NULL DEFAULT '' COMMENT '奖品描述',
  `prize_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '奖品数量',
  `prize_probability` varchar(50) NOT NULL DEFAULT '' COMMENT '中奖概率',
  `start_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开始时间',
  `end_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖品信息表'



CREATE TABLE `tb_choujiang_prize_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `activity_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '活动ID',
  `prize_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '奖品ID',
  `u_name` varchar(30) NOT NULL DEFAULT '' COMMENT '用户名称',
  `prize_log_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '中奖时间',
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中奖记录表'









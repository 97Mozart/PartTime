package com.parttime.model;

import java.util.Date;
import java.util.List;

import com.parttime.util.JdbcUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		String sql = "select * from orders";
		JdbcUtil jdbcUtil = new JdbcUtil();
		List<Orders> queryPreparedStatement = jdbcUtil.queryPreparedStatement(sql, Orders.class);
		Orders orders = queryPreparedStatement.get(0);
		String orders_time = orders.getOrders_time();
		System.out.println(orders_time);
		System.out.println("==========");
	}
	
}

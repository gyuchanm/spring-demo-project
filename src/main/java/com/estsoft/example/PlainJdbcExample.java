package com.estsoft.example;

import java.sql.*;

public class PlainJdbcExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/jpatest";
    static final String USER = "root";
    static final String PASS = "0000";
    static final String QUERY = "SELECT * FROM student";
    static final String QUERY2 = "SELECT * FROM instructor";

    public static void main(String[] args) {
        // Open & get a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set after execute query
            while (rs.next()) {
                // Retrieve by column name
                System.out.println("===========[student]===========");
                System.out.print("ID: " + rs.getLong("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.println(", desc: " + rs.getString("desc"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set after execute query
            while (rs.next()) {
                // Retrieve by column name
                System.out.println("===========[instructor]===========");
                System.out.print("ID: " + rs.getLong("id"));
                System.out.print(", name: " + rs.getString("name"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.println(", desc: " + rs.getString("desc"));
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

//TODO
// stduent, instructor, lecture_course, lecture_applicants 테이블 데이터
// 조회, 저장, 수정 실습 for 2~30 minutes
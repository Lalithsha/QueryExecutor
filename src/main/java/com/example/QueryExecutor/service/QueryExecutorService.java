package com.example.QueryExecutor.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Service;
import com.example.QueryExecutor.model.*;;

@Service
public class QueryExecutorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @MessageMapping("/executeQuery")
    public void executeQuery(QueryRequest queryRequest) {
        String tableName = queryRequest.getTableName();
        String query = queryRequest.getQuery();

        // Validate and sanitize input to prevent SQL injection
        if (!isValidTableName(tableName) || !isValidQuery(query)) {
            throw new IllegalArgumentException("Invalid table name or query");
        }

        /*
         * // Execute the query
         * try {
         * if (query.toLowerCase().startsWith("select")) {
         * jdbcTemplate.query(query, (rs, rowNum) -> {
         * // Process result set
         * // In a real application, you'd return this data
         * return null;
         * });
         * } else {
         * jdbcTemplate.execute(query);
         * }
         * } catch (Exception e) {
         * // Log the exception and handle it appropriately
         * e.printStackTrace();
         * }
         */

        // Execute the query
        try {
            if (query.toLowerCase().startsWith("select")) {
                List<Map<String, Object>> result = executeSelect(query);
                // Process the result as needed
            } else {
                executeUpdate(query);
            }
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            e.printStackTrace();
        }
    }

    private List<Map<String, Object>> executeSelect(String query) {
        return jdbcTemplate.queryForList(query);
    }

    private void executeUpdate(String query) {
        jdbcTemplate.update(query);
    }

    private boolean isValidTableName(String tableName) {
        // Implement proper validation logic
        return tableName.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private boolean isValidQuery(String query) {
        // Implement proper validation logic
        return query.matches("(?i)(SELECT|INSERT|UPDATE|DELETE|CREATE|ALTER|DROP).*");
    }
}
package com.example.hbv4d.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static final String location = "src/main/resources/com/example/hbv4d/db/hbv4d.db";
    public static Connection connect() {
        String dbPrefix = "jdbc:sqlite:";
        Connection connection;
        String absolutePath = getAbsolutePath(location);
        try {
            connection = DriverManager.getConnection(dbPrefix + absolutePath);
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    LocalDateTime.now() + ": Could not connect to SQLite DB at " +
                            location);
            return null;
        }
        return connection;
    }

    private static String getAbsolutePath(String path) {
        String projectDir = System.getProperty("user.dir");
        File file = new File(projectDir, path);
        return file.getAbsolutePath();
    }
}

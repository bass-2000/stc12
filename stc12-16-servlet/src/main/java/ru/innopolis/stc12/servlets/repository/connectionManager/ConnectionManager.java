package ru.innopolis.stc12.servlets.repository.connectionManager;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();
}
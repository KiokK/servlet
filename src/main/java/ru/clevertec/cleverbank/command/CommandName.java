package ru.clevertec.cleverbank.command;

public enum CommandName {

    LOGIN,
    ACCOUNT_REPLENISHMENT, ACCOUNT_DEBITING, TRANSFER_TO_ANOTHER_ACCOUNT,
    EXTRACT, EXPENSES,

    // CRUD - admin - commands
    USERS_CREATE, USERS_DELETE_BY_ID, USERS_UPDATE, USERS_FIND_ALL, USERS_FIND_BY_ID,
    ACCOUNTS_CREATE, ACCOUNTS_DELETE_BY_ID, ACCOUNTS_UPDATE, ACCOUNTS_FIND_ALL, ACCOUNTS_FIND_BY_ID,
    BANKS_CREATE, BANKS_DELETE_BY_ID, BANKS_UPDATE, BANKS_FIND_ALL, BANKS_FIND_BY_ID,
    TRANSACTIONS_CREATE, TRANSACTIONS_DELETE_BY_ID, TRANSACTIONS_UPDATE, TRANSACTIONS_FIND_ALL, TRANSACTIONS_FIND_BY_ID
}
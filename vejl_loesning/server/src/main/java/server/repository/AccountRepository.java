package server.repository;

import server.model.Account;
import server.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * A repository class for database operations for account objects.
 */
public class AccountRepository extends BaseRepository {

    public ArrayList<Account> getAccountsForCustomer() {

        String sql = "SELECT * FROM accounts";

        ResultSet rs = executePreparedStatementQuery(prepareQuery(sql));

        ArrayList<Account> accounts = new ArrayList<>();
        if (rs == null)
            return accounts;

        try {
            while (rs.next()) {
                Account account =
                        new Account(
                                rs.getInt("account_id"),
                                rs.getInt("customer_id"),
                                rs.getInt("balance"));

                accounts.add(account);
            }
        } catch (SQLException ex) {
            //TODO: Add some sensible error handling!
        }
        return accounts;
    }


        //Todo


    public Account getAccount(int customer_id)
    {
        Account account = null;
        try {
            String sql = "SELECT * FROM accounts WHERE customer_id = ?";
            PreparedStatement ps = super.prepareQuery(sql);

            ps.setInt(1, customer_id);
            ResultSet rs = super.executePreparedStatementQuery(ps);

            if (rs != null && rs.next())
              account = new Account(rs.getInt("balance"), rs.getInt("account_id"), rs.getInt("customer_id"));

        } catch (Exception e) {
            //TODO: Add some sensible error handling!
        }

        return account;
    }

    public Account createAccount(Account account)
    {
        String sql = "INSERT INTO account (balance) VALUES (?)";

        try {
            PreparedStatement ps = prepareInsert(sql);
            ps.setInt(1, account.getBalance());
            int primary_key = executeInsertPreparedStatement(ps);
            account.setAccountId(primary_key);

        } catch (SQLException ex) {
            //TODO: Add some sensible error handling!
            //For example you may use
            // throw ex;
        }
        // Return the new customer
        return account;
    }

    //Todo


    public void withdraw(Account account)
    {
        //her skal den sette balance where customer_id = ? -> problem er at det er 2 forskjellige tabeller
        String sql = "UPDATE accounts SET balance = (?-?) WHERE customer_id = ?";
        PreparedStatement ps =  prepareQuery(sql);

        try {
            ps.setInt(1, account.getBalance());
          //  ps.setInt(2, account.setBalance()
            ps.setInt(3 , account.getCustomerId());
            executePreparedStatementQuery(ps);

        } catch (SQLException ex) {
            //TODO: Add some sensible error handling! What happens if the primary key is not set?
        }
    }


}

package deadlock_java_demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeadlockService {

    private final JdbcTemplate jdbcTemplate;

    public DeadlockService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // =====================================================
    // CREATE TABLE + INSERT DATA
    // =====================================================

    @PostConstruct
    public void setupDatabase() {

        System.out.println("\nCreating table...");

        jdbcTemplate.execute("""
                DROP TABLE IF EXISTS accounts
                """);

        jdbcTemplate.execute("""
                CREATE TABLE accounts (
                    id INT PRIMARY KEY,
                    balance INT
                )
                """);

        jdbcTemplate.update("""
                INSERT INTO accounts(id, balance)
                VALUES (1, 1000)
                """);

        jdbcTemplate.update("""
                INSERT INTO accounts(id, balance)
                VALUES (2, 2000)
                """);

        System.out.println("Inserted sample rows");
    }

    // =====================================================
    // TRANSACTION A
    // =====================================================

    @Transactional
    public void transactionA() {

        try {

            System.out.println("\n[A] Locking Row 1");

            jdbcTemplate.update("""
                    UPDATE accounts
                    SET balance = balance + 100
                    WHERE id = 1
                    """);

            Thread.sleep(2000);

            System.out.println("[A] Trying Row 2");

            jdbcTemplate.update("""
                    UPDATE accounts
                    SET balance = balance + 100
                    WHERE id = 2
                    """);

            System.out.println("[A] COMMIT");

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    // =====================================================
    // TRANSACTION B
    // =====================================================

    @Transactional
    public void transactionB() {

        try {

            System.out.println("\n[B] Locking Row 2");

            jdbcTemplate.update("""
                    UPDATE accounts
                    SET balance = balance + 100
                    WHERE id = 2
                    """);

            Thread.sleep(2000);

            System.out.println("[B] Trying Row 1");

            jdbcTemplate.update("""
                    UPDATE accounts
                    SET balance = balance + 100
                    WHERE id = 1
                    """);

            System.out.println("[B] COMMIT");

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
-- Scenario 1: Apply 1% discount to loan interest rates for customers above 60 years old
DECLARE
    CURSOR cur_customers IS
        SELECT customer_id FROM customers WHERE age > 60;
BEGIN
    FOR cust IN cur_customers LOOP
        UPDATE loans
        SET interest_rate = interest_rate - 1
        WHERE customer_id = cust.customer_id;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount applied to all loans for customers above 60.');
END;
/

-- Scenario 2: Set IsVIP flag to TRUE for customers with balance over $10,000
BEGIN
    UPDATE customers
    SET isvip = 'TRUE'
    WHERE balance > 10000;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with balance over $10,000.');
END;
/

-- Scenario 3: Print reminders for loans due within the next 30 days
DECLARE
    CURSOR cur_due_loans IS
        SELECT l.loan_id, l.due_date, c.name
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN cur_due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.name || ', your loan #' || rec.loan_id ||
                             ' is due on ' || TO_CHAR(rec.due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/
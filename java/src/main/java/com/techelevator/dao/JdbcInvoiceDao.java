package com.techelevator.dao;

import com.techelevator.model.Invoice;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcInvoiceDao implements InvoiceDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcInvoiceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Invoice getInvoiceByInvoiceId(int invoiceID) {
        Invoice returnedInvoice = new Invoice();
        String sql = ""

    }

    @Override
    public List<Invoice> getListOfInvoicesByUserId(int userId) {

    }

    @Override
    public List<Invoice> getAllInvoices() {

    }

    @Override
    public Invoice createInvoice(Invoice invoice) {

    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {

    }

    @Override
    public int deleteInvoiceById(int invoiceId) {

    }
}

package com.techelevator.dao;

import com.techelevator.model.Invoice;
import com.techelevator.model.User;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface InvoiceDao {

    Invoice getInvoiceById(int invoiceID);

    List<Invoice> getListOfInvoicesByFirstName(String firstName);

    List<Invoice> getListOfInvoicesByLastName(String lastName);

    List<Invoice> getListOfInvoicesByFirstAndLastName(String firstName, String lastName);

    List<Invoice> getListOfInvoiceByUserId(int userId);

    Invoice createInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    int deleteInvoiceById(int invoiceId);


}

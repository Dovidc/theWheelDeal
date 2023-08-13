package com.techelevator.dao;

import com.techelevator.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice getInvoiceByInvoiceId(int invoiceID);

    List<Invoice> getListOfInvoicesByUserId(int userId);

    List<Invoice> getAllInvoices();

    Invoice createInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    int deleteInvoiceById(int invoiceId);


}

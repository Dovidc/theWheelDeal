package com.techelevator.dao;

import com.techelevator.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice getInvoiceById(int invoiceID);

    List<Invoice> getListOfInvoicesByFirstName();

    List<Invoice> getListOfInvoicesByLastName();

    List<Invoice> getListOfInvoicesByFirstAndLastName();

    List<Invoice> getListOfInvoiceByUserId();

    Invoice createInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    int deleteInvoiceById(int invoiceId);


}

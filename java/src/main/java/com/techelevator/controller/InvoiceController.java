package com.techelevator.controller;

import com.techelevator.dao.InvoiceDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class InvoiceController {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/profile/{userId}/invoices", method = RequestMethod.GET)
    public List<Invoice> getInvoicesByUserId (Principal principal, @PathVariable int userId) {
        if (!userDao.getUserById(userId).getUsername().equalsIgnoreCase(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cannot get Invoices.");
        } else {
            return invoiceDao.getListOfInvoicesByUserId(userId);
        }
    }


    @RequestMapping(path = "/workorders/{workOrderId}/createinvoice", method = RequestMethod.POST)
    public Invoice createInvoice (
}

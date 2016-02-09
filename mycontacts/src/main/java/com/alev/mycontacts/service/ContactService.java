package com.alev.mycontacts.service;

import java.util.List;

import com.alev.mycontacts.domain.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
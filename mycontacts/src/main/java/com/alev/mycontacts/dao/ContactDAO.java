package com.alev.mycontacts.dao;

import java.util.List;

import com.alev.mycontacts.domain.Contact;

public interface ContactDAO {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}

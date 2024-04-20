package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.DAO.ContactDAO;
import com.conn.DBConnect;
import com.entity.Contact;

public class mainClass {

    public static void main(String[] args) throws IOException {
        boolean running = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ContactDAO dao = new ContactDAO(DBConnect.getConn());

        while (running) {
        	   System.out.println("=======================================");
               System.out.println("            Contact Manager            ");
               System.out.println("=======================================");
               System.out.println("1. Create Contact");
               System.out.println("2. Edit Contact");
               System.out.println("3. Delete Contact");
               System.out.println("4. View All Contacts");
               System.out.println("5. Exit");
               System.out.println("=======================================");
               System.out.println("Enter your choice:");

            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter Name:");
                    String name = br.readLine();
                    System.out.println("Enter Phone Number:");
                    String phoneNumber = br.readLine();
                    Contact contactToAdd = new Contact(name, phoneNumber);
                    boolean saved = dao.saveContact(contactToAdd);
                    if (saved) {
                        System.out.println("Contact saved successfully!");
                    } else {
                        System.out.println("Something went wrong while saving the contact.");
                    }
                    break;

                case 2:
                    System.out.println("Enter ID of the Contact to Edit:");
                    int idToEdit = Integer.parseInt(br.readLine());
                    System.out.println("Enter New Name:");
                    String newName = br.readLine();
                    System.out.println("Enter New Phone Number:");
                    String newPhoneNumber = br.readLine();
                    Contact editedContact = new Contact(idToEdit, newName, newPhoneNumber);
                    boolean edited = dao.editContact(editedContact);
                    if (edited) {
                        System.out.println("Contact edited successfully!");
                    } else {
                        System.out.println("Failed to edit contact. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Enter ID of the Contact to Delete:");
                    int idToDelete = Integer.parseInt(br.readLine());
                    boolean deleted = dao.deleteContact(idToDelete);
                    if (deleted) {
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Failed to delete contact. Please try again.");
                    }
                    break;

                case 4:
                    List<Contact> contacts = dao.getAllContect();
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        System.out.println("List of Contacts:");
                        for (Contact contact : contacts) {
                            System.out.println("ID: " + contact.getId());
                            System.out.println("Name: " + contact.getName());
                            System.out.println("Phone Number: " + contact.getPhno());
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

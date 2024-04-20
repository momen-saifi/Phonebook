package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Contact;

public class ContactDAO {

	private Connection conn;

	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveContact(Contact c) {
		Boolean flag = false;
		try {
			String q = "insert into contact(name,phno) values(?,?)";
			PreparedStatement pt = conn.prepareStatement(q);

			pt.setString(1, c.getName());
			pt.setString(2, c.getPhno());

			int success = pt.executeUpdate();
			if (success == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean editContact(Contact c) {
		Boolean flag = false;
		try {
			String q = "update contact set phno=? where name=?";
			PreparedStatement pt = conn.prepareStatement(q);

			pt.setString(1, c.getPhno());
			pt.setString(2, c.getName());

			int success = pt.executeUpdate();
			if (success == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteContact(String name) {
		Boolean flag = false;
		try {
			String q = "delete from contact where name=?";
			PreparedStatement pt = conn.prepareStatement(q);

			pt.setString(1, name);

			int success = pt.executeUpdate();
			if (success == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteContact(int id) {
		Boolean flag = false;
		try {
			String q = "delete from contact where id=?";
			PreparedStatement pt = conn.prepareStatement(q);

			pt.setInt(1, id);

			int success = pt.executeUpdate();
			if (success == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<Contact> getAllContect() {
		List<Contact> list = new ArrayList<>();
		try {
			String q = "select * from contact";
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(q);

			while (rs.next()) {
				Contact obj = new Contact();
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhno(rs.getString(3));
				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

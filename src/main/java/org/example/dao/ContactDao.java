package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {


    Connection con;

    private PreparedStatement ps;

    public int addContact(Contact contact) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO `contact` (`name`,`number`)values(?,?)");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contact> getAll(){
        List<Contact> contacts = new ArrayList<>();
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("SELECT * FROM `contact`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des contacts", e);
        }
    }

    public Contact getById(int id){
        con=ConnectionUtil.getConnection();
        try {
            ps=con.prepareStatement("SELECT * FROM `contact` WHERE `id`=?");
            ps.setInt(1,id);
            ResultSet result=ps.executeQuery();
            if(result.next()){
                Contact contact=new Contact();
                contact.setId(id);
                contact.setName(result.getString("name"));
                contact.setNumber(result.getString("number"));
                return contact;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(int id) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("DELETE FROM `contact` WHERE `id` = ?");
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected != 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression du contact avec l'ID " + id, e);
        }
    }

    public boolean update(Contact contact) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("UPDATE `contact` SET `name` = ?, `number` = ? WHERE `id` = ?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            ps.setInt(3, contact.getId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected!=0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la mise à jour du contact avec l'ID " + contact.getId(), e);
        }
    }


}

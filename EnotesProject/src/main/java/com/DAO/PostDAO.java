package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;

public class PostDAO {
    private Connection conn;

    public PostDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean addNotes(String title, String content, int userId) {
        boolean result = false;
        try {
            String query = "INSERT INTO post(title, content, uid) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, userId);
            result = ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace(); // It's better to log the exception
        }
        return result;
    }

    public List<Post> getData(int userId) {
        List<Post> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM post WHERE uid=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt(1));
                post.setTitle(rs.getString(2));
                post.setContent(rs.getString(3));
                post.setpDate(rs.getTimestamp(4));
                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace(); // It's better to log the exception
        }
        return list;
    }

    public Post getDataById(int noteId) {
        Post post = null;
        try {
            String query = "SELECT * FROM post WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, noteId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post = new Post();
                post.setId(rs.getInt(1));
                post.setTitle(rs.getString(2));
                post.setContent(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }

    public boolean postUpdate(int noteId, String title, String content) {
        boolean result = false;
        try {
            String query = "UPDATE post SET title=?, content=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, noteId);
            result = ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteNotes(int noteId) {
        boolean result = false;
        try {
            String query = "DELETE FROM post WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, noteId);
            result = ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

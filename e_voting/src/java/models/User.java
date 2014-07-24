/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    String name;
    Boolean voted;
    
    public User() {
        
    }
    
    public User(String name, Boolean voted) {
        this.name = name;
        this.voted = voted;
    }
    
    public User(ResultSet rs) throws SQLException {
        this(rs.getString("name"), rs.getBoolean("voted"));
    }
    
    public String getName() {
        return name;
    }
   
    public Boolean getVoted() {
        return voted;
    }
}

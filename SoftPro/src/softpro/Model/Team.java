
package softpro.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import static java.lang.Integer.valueOf;

public class Team implements Iterable<User> {
    private final List<User> staff;
    
    public Team(){
        this.staff = new ArrayList<>();
    }
    
    public void addUser(User user){
        this.staff.add(user);
    }
    
    public void removeUser(User user){
        this.staff.remove(user);
    }
    
    @Override
    public Iterator<User> iterator() {
        return this.staff.iterator();
    }

    public User find(String id) {
        if (id.equals("unset")) return null;
        for (User user : staff)
            if (user.getId() == valueOf(id)) return user;
        throw new RuntimeException("Unknowed user '" + id + "' in project");
    }
}

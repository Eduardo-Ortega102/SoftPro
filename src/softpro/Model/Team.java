
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
    
    public boolean addUser(User user){
        return this.staff.add(user);
    }
    
    public boolean removeUser(User user){
        return this.staff.remove(user);
    }
    
    @Override
    public Iterator<User> iterator() {
        return this.staff.iterator();
    }
    
    public int getamountOfMembers(){
        return this.staff.size();
    }

    public User findUser(int id) {
        for (User user : staff)
            if (user.getId() == valueOf(id)) return user;
        return null;
    }
}

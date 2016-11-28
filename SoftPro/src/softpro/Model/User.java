
package softpro.Model;

public class User {
    private final int id;
    private String nombre;
    private String telefono;
    private String email;
    private String rol;
    
    public User(int id, String nombre, String telefono, String email, String rol){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public int hashCode() {
        return 29 * 3 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.id == ((User) obj).id;
    }
    
    
}


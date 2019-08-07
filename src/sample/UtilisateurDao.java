package sample;

public interface UtilisateurDao {

    public void create(Utilisateur utilisateur);
    public Utilisateur read(int id);
    public Utilisateur readByUsername(String username);
    public void delete(Utilisateur utilisateur);
    public void update(Utilisateur utilisateur);

}

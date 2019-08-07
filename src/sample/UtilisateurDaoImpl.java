package sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao {
    private SessionFactory sessionFactory;

    public UtilisateurDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public UtilisateurDaoImpl(){

    }

    @Override
    public void create(Utilisateur utilisateur) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(utilisateur);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Utilisateur read(int id) {
        Utilisateur utilisateur;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        utilisateur = session.get(Utilisateur.class, id);
        session.getTransaction().commit();
        session.close();
        return utilisateur;
    }

    @Override
    public Utilisateur readByUsername(String username) {
        Utilisateur utilisateur;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Utilisateur as u where u.username = :usr");
        query.setParameter("usr", username);

        utilisateur = (Utilisateur)query.uniqueResult();
        session.getTransaction().commit();
        return utilisateur;
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(utilisateur);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Utilisateur utilisateur) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(utilisateur);
        session.getTransaction().commit();
        session.close();
    }
}

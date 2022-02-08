package miage.gestionappel.dao;

import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Groupe;
import miage.gestionappel.metier.Occurence;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class GroupeDao implements Dao<Groupe> {

    @Override
    public Groupe get(int id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            Groupe groupe = session.get(Groupe.class, id);
            return groupe;
        }
    }

    @Override
    public List<Groupe> getAll() {
        List<Groupe> groupeList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            groupeList = (List<Groupe>) session.createQuery("FROM Groupe ").list();
        }
        return groupeList;
    }

    @Override
    public void save(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.save(groupe);
            t.commit();
        }
    }

    @Override
    public void update(Groupe groupe, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.update(groupe);
            t.commit();
        }
    }

    @Override
    public void delete(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.remove(groupe);
            t.commit();
        }
    }

    public void getListeEtudiantCour() {
        List<Etudiant> listeEtudiant;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            listeEtudiant = session.createSQLQuery("select e.nomE, e.prenomE " +
                    "from Etudiant e, Appartenir a, Groupe g, Inscrire i, Cours c " +
                    "where e.IdE = a.IdE " +
                    "and a.IdG = g.IdG " +
                    "and g.IdG = i.IdG " +
                    "and i.IdC = c.idC " +
                    "and  c.NomC = ? ").list();

            GroupeDao.affichage(listeEtudiant);
        }
    }

    /**
     * Affichage d'une liste de tableaux d'objets.
     */
    private static void affichage (List l)
    {
        System.out.println("-----");
        l.forEach(e -> {
            for (Object obj : (Object[])e)
                System.out.print(obj + " ");
            System.out.println();
        });
        System.out.println("-----");
    }


}






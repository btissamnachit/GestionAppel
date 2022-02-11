package miage.gestionappel.dao;

import miage.gestionappel.metier.Cours;
import miage.gestionappel.metier.Etudiant;
import miage.gestionappel.metier.Groupe;
import miage.gestionappel.metier.Presenter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoursDao implements Dao<Cours>{

    @Override
    public Cours get(int id) {
        try(Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            session.beginTransaction();
            Cours cours = session.get(Cours.class, id);
            return cours;
        }
    }

    @Override
    public List<Cours> getAll() {
        List<Cours> coursList;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            coursList = (List<Cours>) session.createQuery("FROM Cours").list();
        }
        return coursList;
    }

    @Override
    public void save(Cours cours) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.save(cours);
            t.commit();
        }
    }

    @Override
    public void update(Cours cours, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
        {
            Transaction t = session.beginTransaction();
            session.update(cours);
            t.commit();
        }
    }

    @Override
    public void delete(Cours cours) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.remove(cours);
            t.commit();
        }
    }

    public long nbAbsence(Cours cours) {
        long nbAbsences;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            nbAbsences = (long) session.createQuery("select count(*) FROM " +
                            "Occurence as Oc,Presenter as P WHERE Oc.cours.idC= :cours " +
                            "and Oc.idOc = P.occurence.idOc and P.statut = 'Absent'")
                    .setParameter("cours", cours.getIdC()).uniqueResult();

        }
        return nbAbsences;
    }

    public int nbOccurence(Cours cours) {
        return cours.getOccurencesValidees().size();
    }

    public double moyenneAbscence(Cours cours) {
        long nbAbsence = nbAbsence(cours);
        double nbOccurence = nbOccurence(cours);
        if (nbAbsence(cours) != 0) {
            System.out.println(nbAbsence(cours));
            System.out.println(nbOccurence(cours));
            return (nbAbsence / nbOccurence);
        } else {
            return 0D;
        }
    }

    public List<Etudiant> getEtudiantsAbsentistes(Cours cours) {
        List<Etudiant> etudiantsAbsenteistes = new ArrayList<>();
        if (!(cours.getGroupes() == null)) {
            for (Groupe groupe : cours.getGroupes()) {
                if (!(groupe.getEtudiants() == null)) {
                    for (Etudiant etudiant : groupe.getEtudiants()) {
                        List<Presenter> absences = new ArrayList<>(etudiant.getPresences());
                        absences = filtreCours(absences, cours);
                        absences = filtreAbsence(absences);
                        etudiantsAbsenteistes.add(etudiant);
                    }
                }
            }
        }


        return etudiantsAbsenteistes;
    }

    private List<Presenter> filtreAbsence(List<Presenter> cours) {
        return cours.stream().filter(presenter -> presenter.getStatut() == "Absent").collect(Collectors.toList());
    }

    private List<Presenter> filtreCours(List<Presenter> cours, Cours matiere) {
        return cours.stream().filter(presenter -> presenter.getOccurence().getCours() == matiere).collect(Collectors.toList());
    }

}

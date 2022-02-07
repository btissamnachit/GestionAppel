package miage.gestionappel.dao;

import miage.gestionappel.metier.entity.EtudiantEntity;
import miage.gestionappel.metier.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class EtuDao implements Dao {

    @Override
    public Optional<EtudiantEntity> get(long id) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            EtudiantEntity etudiant = session.get(EtudiantEntity.class, id);
            return Optional.ofNullable(etudiant);
        }
    }

    @Override
    public List<EtudiantEntity> getAll() {


        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            List<EtudiantEntity> list1 = session.createSQLQuery("select * from EtudiantEntity ").list();

            return list1;
        }
    }

    @Override
    public void save(EtudiantEntity e) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();
            session.save(e);
            t.commit();

        }

    }

    @Override
    public void update(EtudiantEntity e, String[] params) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            EtudiantEntity etudiant = session.get(EtudiantEntity.class,e.getIdEtudiant());
            session.save(etudiant);
            session.evict(etudiant);

            etudiant.setNomE(params[0]);
            etudiant.setPrenomE(params[1]);
            etudiant.setMailE(params[2]);
            session.update(etudiant);
            t.commit();


        }
    }

    @Override
    public void delete(EtudiantEntity e) {

        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction t = session.beginTransaction();

            EtudiantEntity etudiant = session.get(EtudiantEntity.class,e.getIdEtudiant());

            session.remove(etudiant);
            t.commit();

    }
}}

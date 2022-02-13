package miage.gestionappel.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Chargement de la configuration et création de la SessionFactory.
 * (hibernate.cfg.xml)
 */
public class HibernateUtil
{
    private static final SessionFactory SESSION_FACTORY;

    static
    {
        try	{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");

            /**
             * Ajout des classes.
             * Pour miage.gestionappel.metier.User le fichier ressource hbm.xml
             * attaché est miage/gestionappel/metier/User.hbm.xml.
             */
//			configuration.addClass(miage.gestionappel.metier.User.class);

            /**
             * Entité.
             */
            configuration.addAnnotatedClass(miage.gestionappel.metier.Cours.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Groupe.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Justificatif.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Occurence.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Presenter.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Professeur.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Scolarite.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.User.class);
            configuration.addAnnotatedClass(miage.gestionappel.metier.Etudiant.class);


            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException ex)
        {
            /*----- Exception -----*/
            System.err.println("Initial SessionFactory creation failed.\n" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory () { return SESSION_FACTORY; }

} /*----- Fin de la classe HibernateUtil -----*/

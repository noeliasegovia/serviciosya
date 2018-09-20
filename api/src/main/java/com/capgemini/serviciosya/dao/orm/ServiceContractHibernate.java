package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ServiceContractEntity;
import com.capgemini.serviciosya.dao.IServiceContractDao;
import com.capgemini.serviciosya.dao.DaoException;

import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class ServiceContractHibernate implements IServiceContractDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();

    private static final Logger logger = Logger.getLogger(OccupationDaoHibernate.class);

    @Override
    public void create(ServiceContractEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Service Contract object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Creating new Service Contract %s", target));
            session.save (target);
            tx.commit ();
            logger.debug (String.format ("New Service Contract %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new Service Contract %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update(ServiceContractEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("ServiceContract object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating Service Contract %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Service Contract %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating Service Contract %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void delete(Integer id) {

        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id Service Contract is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting Service Contract by id %s", id.toString ()));
            ServiceContractEntity p = (ServiceContractEntity) session.get (ServiceContractEntity.class, id);
            if (p != null) {

                session.delete (p);
                tx.commit ();
                logger.debug (String.format ("Service Contract id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("Service Contract by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting Service cotract id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public List<ServiceContractEntity> findAll() {

        List<ServiceContractEntity> list = null;

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug ("Finding all occupations");
            list = (List<ServiceContractEntity>) session.createCriteria (ServiceContractEntity.class).list ();

        } catch (Exception e) {

            logger.error ("Error finding all Occupations id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return list;
    }

    @Override
    public ServiceContractEntity findById(Integer id) {

        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id occupation is null!");
            return null;
        }

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding occupation by id %s", id.toString ()));
            ServiceContractEntity s = (ServiceContractEntity) session.get (ServiceContractEntity.class, id);
            if (s != null) {

                return s;
            } else {

                logger.warn (String.format ("Occupation by id %s not found!", id.toString ()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Error finding service contract id %s", id.toString ()));
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

}
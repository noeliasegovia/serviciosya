package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.OccupationEntity;
import com.capgemini.serviciosya.dao.IOccupationDao;
import com.capgemini.serviciosya.dao.DaoException;

import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class OccupationDaoHibernate implements IOccupationDao  {


    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();

    private static final Logger logger = Logger.getLogger(OccupationDaoHibernate.class);

    @Override
    public void create(OccupationEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Occupation object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Creating new Occupation %s", target));
            session.save (target);
            tx.commit ();
            logger.debug (String.format ("New occupation %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new occupation %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update(OccupationEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Occupation object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating occupation %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Occupation %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating occupation %s", target));
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

            logger.warn ("Id occupation is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting occupation by id %s", id.toString ()));
            OccupationEntity p = (OccupationEntity) session.get (OccupationEntity.class, id);
            if (p != null) {

                session.delete (p);
                tx.commit ();
                logger.debug (String.format ("Occupation id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("Occupation by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting Occupation id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public List<OccupationEntity> findAll() {

        List<OccupationEntity> list = null;

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug ("Finding all occupations");
            list = (List<OccupationEntity>) session.createCriteria (OccupationEntity.class).list ();

        } catch (Exception e) {

            logger.error ("Error finding all Occupations id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return list;
    }

    @Override
    public OccupationEntity findById(Integer id) {

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
            OccupationEntity p = (OccupationEntity) session.get (OccupationEntity.class, id);
            if (p != null) {

                return p;
            } else {

                logger.warn (String.format ("Occupation by id %s not found!", id.toString ()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Error finding Occupation id %s", id.toString ()));
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

}
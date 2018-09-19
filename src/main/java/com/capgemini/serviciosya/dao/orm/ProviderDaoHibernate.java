package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.DaoException;
import com.capgemini.serviciosya.dao.IProviderDao;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;



import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.List;
import java.util.Set;


public class ProviderDaoHibernate implements IProviderDao {

    private SessionFactory sessionFactory;
    private static final Logger logger= Logger.getLogger (ProviderDaoHibernate.class);


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save (ProviderEntity p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();

    }

    @Override
    public void update (ProviderEntity p) {

        Session session = this.sessionFactory.openSession();
        session.update(p);
        session.close();

    }

    @Override
    public void delete (Integer id) {

        Session session = this.sessionFactory.openSession();
        session.delete(id);
        session.close();


    }

    @Override
    public List<ProviderEntity> list() {

        Session session = this.sessionFactory.openSession();
        List<ProviderEntity> provList = session.createQuery("from provider").list();
        session.close();
        return provList;
    }



    @Override
    public ProviderEntity findById (Integer id) {

        if (id == null) {

            logger.warn("Id Provider is null!");
            return null;
        }
        Session session = null;
        try {
            logger.debug("Getting hibernate session...");
            session = this.sessionFactory.openSession();

            logger.debug (String.format ("Finding Provider by id %s", id.toString ()));
            ProviderEntity c = (ProviderEntity) session.get(ProviderEntity.class, id);
            if (c != null) {

                return c;
            } else {

                logger.warn(String.format("Provider by id %s not found!", id.toString()));
                return null;

            }
        }catch(Exception e){

                logger.error(String.format("Error finding Provider id %s", id.toString()));
                throw new DaoException(e.getMessage(), e);

        }finally{
            session.close();
        }
    }

    @Override
    public ProviderEntity findByEmail (String email) {

        if (isEmpty (email)) {

            logger.warn ("Email argument is empty!");
            return null;
        }

        ProviderEntity provider;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding provider by emai %s", email));
            provider = (ProviderEntity) session.
                    createQuery ("From Provider p where p.email = '" + email + "'").
                    uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a provider by email");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return provider;
    }

    @Override
    public ProviderEntity findByDNI (Integer dni) {

        if (dni == null) {

            logger.warn ("DNI argument is empty!");
            return null;
        }

        ProviderEntity provider;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding provider by dni %s", dni.toString()));
            Criteria criteria = session.createCriteria (ProviderEntity.class);
            criteria.add (Restrictions.eq ("dni", dni));

            provider = (ProviderEntity) criteria.uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a provider by dni");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return provider;
    }

    @Override
    public ProviderEntity findByPhone(String phone) {

        if (isEmpty (phone)) {

            logger.warn ("Phone argument is empty!");
            return null;
        }

        ProviderEntity provider;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding provider by phone %s", phone));
            provider = (ProviderEntity)session.getNamedQuery ("ProviderFindByPhone").
                    setString("phone", phone).uniqueResult();


        } catch (Exception e) {

            logger.error ("Error finding a provider by dni");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return provider;
    }
}

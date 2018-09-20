package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.ClientEntity;
import com.capgemini.serviciosya.dao.IClientDao;
import com.capgemini.serviciosya.dao.DaoException;
import org.apache.log4j.Logger;
import  org.apache.commons.lang3.StringUtils ;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class ClientDaoHibernate implements IClientDao{

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();

    private static final Logger logger= Logger.getLogger (ClientDaoHibernate.class);


    @Override
    public void create(ClientEntity target) {
        // Validate the arguments.
        if (target == null) {

            logger.warn ("Client object is null!");
            return;
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator ();

        Set<ConstraintViolation<ClientEntity>> validationErrors = validator.validate(target);

        if(!validationErrors.isEmpty()){
            for(ConstraintViolation<ClientEntity> error : validationErrors){
                System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());

            }
        }
        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Creating new Client %s", target));
            session.save (target);
            tx.commit ();
            logger.debug (String.format ("New Client %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new Client %s", target));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public void update(ClientEntity target) {

        // Validate the arguments.
        if (target == null) {

            logger.warn ("Client object is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Updating Client %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Client %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating Client %s", target));
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

            logger.warn ("Id client is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting client by id %s", id.toString ()));
            ClientEntity c = (ClientEntity) session.get (ClientEntity.class, id);
            if (c != null) {

                session.delete (c);
                tx.commit ();
                logger.debug (String.format ("client by id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("client by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting client id %s", id.toString ()));
            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

    }

    @Override
    public ClientEntity findByPhone(String phone) {
        if (isEmpty (phone)) {

            logger.warn ("Phone argument is empty!");
            return null;
        }

        ClientEntity client;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding client by phone %s", phone));
            client = (ClientEntity)session.getNamedQuery ("ClientFindByPhone").
                    setString("phone", phone).uniqueResult();


        } catch (Exception e) {

            logger.error ("Error finding a client by dni");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
        return client;
    }




    @Override
    public List<ClientEntity> findAll() {
        List<ClientEntity> list = null;

        Session session = null;

        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug ("Finding all Client...");
            list = (List<ClientEntity>) session.createCriteria (ClientEntity.class).list ();

        } catch (Exception e) {

            logger.error ("Error finding all Client id");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
        return list;

    }

    @Override
    public ClientEntity findById(Integer id) {
        // Validate the arguments.
        if (id == null) {

            logger.warn ("Id Client is null!");
            return null;
        }

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding Client by id %s", id.toString ()));
            ClientEntity c = (ClientEntity) session.get (ClientEntity.class, id);
            if (c != null) {

                return c;
            } else {

                logger.warn (String.format ("Client by id %s not found!", id.toString ()));
                return null;
            }

        } catch (Exception e) {

            logger.error (String.format ("Error finding Client id %s", id.toString ()));
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
    }

    @Override
    public ClientEntity findByEmail(String email) {

        if (isEmpty (email)) {

            logger.warn ("Email argument is empty!");
            return null;
        }

        ClientEntity client;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding client by emai %s", email));
            client = (ClientEntity) session.
                    createQuery ("From client p where p.email = '" + email + "'").
                    uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a client by email");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
        return client;
    }

    @Override
    public ClientEntity findByDNI(Integer dni) {
        if (dni == null) {

            logger.warn ("DNI argument is empty!");
            return null;
        }

        ClientEntity client;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding client by dni %s", dni.toString()));
            Criteria criteria = session.createCriteria (ClientEntity.class);
            criteria.add (Restrictions.eq ("dni", dni));

            client = (ClientEntity) criteria.uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a client by dni");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return client;

    }


}
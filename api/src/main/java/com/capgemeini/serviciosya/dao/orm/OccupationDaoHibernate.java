package com.capgemeini.serviciosya.dao.orm;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import com.capgemeini.serviciosya.dao.DaoException;
import com.capgemeini.serviciosya.dao.IOccupationDao;
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


public class OccupationDaoHibernate implements IOccupationDao {

    private SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory ();

    private static final Logger logger= Logger.getLogger (ProvinceDaoHibernate.class);


    @Override
    public void create(OccupationEntity target) {
        // Validate the arguments.
        if (target == null) {

            logger.warn ("Occupation object is null!");
            return;
        }

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator ();

        Set<ConstraintViolation<OccupationEntity>> validationErrors = validator.validate(target);

        if(!validationErrors.isEmpty()){
            for(ConstraintViolation<OccupationEntity> error : validationErrors){
                System.out.println(error.getMessageTemplate()+"::"+error.getPropertyPath()+"::"+error.getMessage());

            }
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
            logger.debug (String.format ("New Occupation %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error creating new Provider %s", target));
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

            logger.debug (String.format ("Updating Occupation %s", target));
            session.update (target);
            tx.commit ();
            logger.debug (String.format ("Occupation %s created!", target));

        } catch (Exception e) {

            logger.error (String.format ("Error updating Occupation %s", target));
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

            logger.warn ("Id Occupation is null!");
            return;
        }

        Session session = null;
        Transaction tx = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();
            tx = session.beginTransaction ();

            logger.debug (String.format ("Deleting Occupation by id %s", id.toString ()));
            OccupationEntity c = (OccupationEntity) session.get (OccupationEntity.class, id);
            if (c != null) {

                session.delete (c);
                tx.commit ();
                logger.debug (String.format ("Occupation by id %s deleted!", id.toString ()));
            } else {
                logger.warn (String.format ("Occupation by id %s not found!", id.toString ()));
            }

        } catch (Exception e) {

            logger.error (String.format ("Error deleting Provider id %s", id.toString ()));
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

            logger.debug ("Finding all Occupations...");
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

            logger.warn ("Id Occupation is null!");
            return null;
        }

        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding Occupation by id %s", id.toString ()));
            OccupationEntity c = (OccupationEntity) session.get (OccupationEntity.class, id);
            if (c != null) {

                return c;
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


    @Override
    public OccupationEntity findByName(String name) {
        if (name == null) {

            logger.warn ("name argument is empty!");
            return null;
        }

        OccupationEntity occupation;
        Session session = null;
        try {

            logger.debug ("Getting hibernate session...");
            session = this.sessionFactory.openSession ();

            logger.debug (String.format ("Finding provider by name %s", name));
            Criteria criteria = session.createCriteria (OccupationEntity.class);
            criteria.add (Restrictions.eq ("name", name));

            occupation = (OccupationEntity) criteria.uniqueResult ();

        } catch (Exception e) {

            logger.error ("Error finding a provider by name");
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return occupation;

    }
}

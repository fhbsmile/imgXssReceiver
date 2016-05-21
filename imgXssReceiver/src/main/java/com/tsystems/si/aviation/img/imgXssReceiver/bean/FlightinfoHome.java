package com.tsystems.si.aviation.img.imgXssReceiver.bean;

// Generated Jun 19, 2015 10:35:39 AM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Flightinfo.
 * @see com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo
 * @author Hibernate Tools
 */
public class FlightinfoHome {

	private static final Log log = LogFactory.getLog(FlightinfoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Flightinfo transientInstance) {
		log.debug("persisting Flightinfo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Flightinfo instance) {
		log.debug("attaching dirty Flightinfo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Flightinfo instance) {
		log.debug("attaching clean Flightinfo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Flightinfo persistentInstance) {
		log.debug("deleting Flightinfo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Flightinfo merge(Flightinfo detachedInstance) {
		log.debug("merging Flightinfo instance");
		try {
			Flightinfo result = (Flightinfo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Flightinfo findById(java.lang.Integer id) {
		log.debug("getting Flightinfo instance with id: " + id);
		try {
			Flightinfo instance = (Flightinfo) sessionFactory
					.getCurrentSession()
					.get("com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Flightinfo instance) {
		log.debug("finding Flightinfo instance by example");
		try {
			List results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.tsystems.si.aviation.img.imgXssReceiver.bean.Flightinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}

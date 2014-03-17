package cn.edu.nju.apoc.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.apoc.entity.Sensitives;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sensitives entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.nju.apoc.entity.Sensitives
 * @author MyEclipse Persistence Tools
 */

public class SensitivesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(SensitivesDAO.class);
	// property constants
	public static final String WORD = "word";

	protected void initDao() {
		// do nothing
	}

	public void save(Sensitives transientInstance) {
		log.debug("saving Sensitives instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sensitives persistentInstance) {
		log.debug("deleting Sensitives instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sensitives findById(java.lang.Integer id) {
		log.debug("getting Sensitives instance with id: " + id);
		try {
			Sensitives instance = (Sensitives) getHibernateTemplate().get(
					"cn.edu.nju.apoc.dao.Sensitives", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sensitives instance) {
		log.debug("finding Sensitives instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sensitives instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sensitives as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWord(Object word) {
		return findByProperty(WORD, word);
	}

	public List findAll() {
		log.debug("finding all Sensitives instances");
		try {
			String queryString = "from Sensitives";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sensitives merge(Sensitives detachedInstance) {
		log.debug("merging Sensitives instance");
		try {
			Sensitives result = (Sensitives) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sensitives instance) {
		log.debug("attaching dirty Sensitives instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sensitives instance) {
		log.debug("attaching clean Sensitives instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SensitivesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SensitivesDAO) ctx.getBean("SensitivesDAO");
	}
}
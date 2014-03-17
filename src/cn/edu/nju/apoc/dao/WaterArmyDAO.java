package cn.edu.nju.apoc.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.apoc.entity.WaterArmy;

/**
 * A data access object (DAO) providing persistence and search support for
 * WaterArmy entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.nju.apoc.entity.WaterArmy
 * @author MyEclipse Persistence Tools
 */

public class WaterArmyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(WaterArmyDAO.class);
	// property constants
	public static final String IP = "ip";

	protected void initDao() {
		// do nothing
	}

	public void save(WaterArmy transientInstance) {
		log.debug("saving WaterArmy instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(WaterArmy persistentInstance) {
		log.debug("deleting WaterArmy instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WaterArmy findById(java.lang.Integer id) {
		log.debug("getting WaterArmy instance with id: " + id);
		try {
			WaterArmy instance = (WaterArmy) getHibernateTemplate().get(
					"cn.edu.nju.apoc.dao.WaterArmy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(WaterArmy instance) {
		log.debug("finding WaterArmy instance by example");
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
		log.debug("finding WaterArmy instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from WaterArmy as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List findAll() {
		log.debug("finding all WaterArmy instances");
		try {
			String queryString = "from WaterArmy";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public WaterArmy merge(WaterArmy detachedInstance) {
		log.debug("merging WaterArmy instance");
		try {
			WaterArmy result = (WaterArmy) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(WaterArmy instance) {
		log.debug("attaching dirty WaterArmy instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WaterArmy instance) {
		log.debug("attaching clean WaterArmy instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WaterArmyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WaterArmyDAO) ctx.getBean("WaterArmyDAO");
	}
}
package cn.edu.nju.apoc.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.apoc.entity.BlackIps;

/**
 * A data access object (DAO) providing persistence and search support for
 * BlackIps entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.nju.apoc.entity.BlackIps
 * @author MyEclipse Persistence Tools
 */

public class BlackIpsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BlackIpsDAO.class);
	// property constants
	public static final String IP = "ip";

	protected void initDao() {
		// do nothing
	}

	public void save(BlackIps persistentInstance) {
		log.debug("saving BlackIps instance");
		try {
			getHibernateTemplate().save(persistentInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BlackIps persistentInstance) {
		log.debug("deleting BlackIps instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void deleteByProperty(String propertyName, Object value) {
		log.debug("deleting from BlackIps with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "delete from BlackIps as model where model."
					+ propertyName + "= ?";
			getHibernateTemplate().bulkUpdate(queryString, value);
		} catch (RuntimeException re) {
			log.error("delete by property name failed", re);
			throw re;
		}
	}

	public BlackIps findById(java.lang.Integer id) {
		log.debug("getting BlackIps instance with id: " + id);
		try {
			BlackIps instance = (BlackIps) getHibernateTemplate().get(
					"cn.edu.nju.apoc.dao.BlackIps", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BlackIps instance) {
		log.debug("finding BlackIps instance by example");
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
		log.debug("finding BlackIps instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BlackIps as model where model."
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
		log.debug("finding all BlackIps instances");
		try {
			String queryString = "from BlackIps";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BlackIps merge(BlackIps detachedInstance) {
		log.debug("merging BlackIps instance");
		try {
			BlackIps result = (BlackIps) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BlackIps instance) {
		log.debug("attaching dirty BlackIps instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BlackIps instance) {
		log.debug("attaching clean BlackIps instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BlackIpsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BlackIpsDAO) ctx.getBean("BlackIpsDAO");
	}
}
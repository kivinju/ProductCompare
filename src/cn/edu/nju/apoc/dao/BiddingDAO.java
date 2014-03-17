package cn.edu.nju.apoc.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.apoc.entity.Bidding;

/**
 * A data access object (DAO) providing persistence and search support for
 * Bidding entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.nju.apoc.entity.Bidding
 * @author MyEclipse Persistence Tools
 */

public class BiddingDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(BiddingDAO.class);
	// property constants
	public static final String MONEY = "money";

	protected void initDao() {
		// do nothing
	}

	public void save(Bidding transientInstance) {
		log.debug("saving Bidding instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bidding persistentInstance) {
		log.debug("deleting Bidding instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bidding findById(java.lang.Integer id) {
		log.debug("getting Bidding instance with id: " + id);
		try {
			Bidding instance = (Bidding) getHibernateTemplate().get(
					"cn.edu.nju.apoc.dao.Bidding", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bidding instance) {
		log.debug("finding Bidding instance by example");
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
		log.debug("finding Bidding instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bidding as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findAll() {
		log.debug("finding all Bidding instances");
		try {
			String queryString = "from Bidding";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bidding merge(Bidding detachedInstance) {
		log.debug("merging Bidding instance");
		try {
			Bidding result = (Bidding) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bidding instance) {
		log.debug("attaching dirty Bidding instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bidding instance) {
		log.debug("attaching clean Bidding instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BiddingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BiddingDAO) ctx.getBean("BiddingDAO");
	}
}
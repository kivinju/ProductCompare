package cn.edu.nju.apoc.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.apoc.entity.InterestWord;

/**
 * A data access object (DAO) providing persistence and search support for
 * InterestWord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.edu.nju.apoc.entity.InterestWord
 * @author MyEclipse Persistence Tools
 */

public class InterestWordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InterestWordDAO.class);
	// property constants
	public static final String WORD = "word";
	public static final String SELLER = "seller";

	protected void initDao() {
		// do nothing
	}

	public void save(InterestWord transientInstance) {
		log.debug("saving InterestWord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(InterestWord persistentInstance) {
		log.debug("deleting InterestWord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InterestWord findById(java.lang.Integer id) {
		log.debug("getting InterestWord instance with id: " + id);
		try {
			InterestWord instance = (InterestWord) getHibernateTemplate().get(
					"cn.edu.nju.apoc.dao.InterestWord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(InterestWord instance) {
		log.debug("finding InterestWord instance by example");
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
		log.debug("finding InterestWord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from InterestWord as model where model."
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

	public List findBySeller(Object seller) {
		return findByProperty(SELLER, seller);
	}

	public List findAll() {
		log.debug("finding all InterestWord instances");
		try {
			String queryString = "from InterestWord";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public InterestWord merge(InterestWord detachedInstance) {
		log.debug("merging InterestWord instance");
		try {
			InterestWord result = (InterestWord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(InterestWord instance) {
		log.debug("attaching dirty InterestWord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InterestWord instance) {
		log.debug("attaching clean InterestWord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InterestWordDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InterestWordDAO) ctx.getBean("InterestWordDAO");
	}
}
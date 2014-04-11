package cn.edu.nju.apoc.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.nju.apoc.entity.Products;

/**
 * A data access object (DAO) providing persistence and search support for
 * Products entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.edu.nju.apoc.entity.Products
 * @author MyEclipse Persistence Tools
 */

public class ProductsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProductsDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String SITE = "site";
	public static final String IMG = "img";

	protected void initDao() {
		// do nothing
	}

	public void save(Products transientInstance) {
		log.debug("saving Products instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Products persistentInstance) {
		log.debug("deleting Products instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Products findById(java.lang.Integer id) {
		log.debug("getting Products instance with id: " + id);
		try {
			Products instance = (Products) getHibernateTemplate().get(
					"cn.edu.nju.apoc.entity.Products", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Products instance) {
		log.debug("finding Products instance by example");
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
		log.debug("finding Products instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Products as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByLikeName(Object name) {
		String queryString = "from Products as model where model.name like ?";
		return getHibernateTemplate().find(queryString, "%"+name+"%");
	}
	
	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findBySite(Object site) {
		return findByProperty(SITE, site);
	}

	public List findByImg(Object img) {
		return findByProperty(IMG, img);
	}

	public List findAll() {
		log.debug("finding all Products instances");
		try {
			String queryString = "from Products";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Products merge(Products detachedInstance) {
		log.debug("merging Products instance");
		try {
			Products result = (Products) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Products instance) {
		log.debug("attaching dirty Products instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Products instance) {
		log.debug("attaching clean Products instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProductsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProductsDAO) ctx.getBean("ProductsDAO");
	}
}
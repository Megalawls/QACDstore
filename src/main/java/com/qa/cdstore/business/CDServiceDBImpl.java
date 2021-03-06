package com.qa.cdstore.business;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdstore.persistence.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class CDServiceDBImpl implements CDService {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllCDs() {
		Query query = manager.createQuery("Select m FROM CD m");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String getCD(Long id) {
		CD cdInDB = findCD(id);
		if (cdInDB != null) {
			return util.getJSONForObject(cdInDB);
		}
		else {
			return "{\"message\": \"ERROR: CD does not exist.\"}";
		}
	}

	@Override
	public String createCD(String cd) {
		CD aCD = util.getObjectForJSON(cd, CD.class);
		manager.persist(aCD);
		return "{\"message\": \"cd sucessfully added\"}";
	}

	@Override
	public String updateCD(Long id, String cd) {
		CD updatedCD = util.getObjectForJSON(cd, CD.class);
		CD cdInDB = findCD(id);
		if (cdInDB != null) {
			cdInDB = updatedCD;
			manager.merge(cdInDB);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Override
	public String deleteCD(Long id) {
		CD cdInDB = findCD(id);
		if (cdInDB != null) {
			manager.remove(cdInDB);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	}

    @Override
    public String deleteAll() {
        Query query = manager.createQuery("Select m FROM CD m");
        Collection<CD> cds = (Collection<CD>) query.getResultList();
        for(CD cd: cds){
            manager.remove(cd);
        }
        return "{\"message\": \"CD Library completely cleared\"}";
    }

	private CD findCD(Long id) {
		return manager.find(CD.class, id);
	}

}

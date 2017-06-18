package src;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import de.uniulm.avid.roary.RoarMgmBeanLocal;
import de.uniulm.avid.roary.entities.Roar;
import de.uniulm.avid.roary.exceptions.FeedNotFoundException;
import de.uniulm.avid.roary.exceptions.RoarNotFoundException;

/**
 * Session Bean implementation class RoarMgmBean
 */
@Stateless
@LocalBean
public class RoarMgmBean implements RoarMgmBeanLocal {

	
	@PersistenceContext(unitName="roarHistory")
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public RoarMgmBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addRoar(String auth, String txt, int feedId) throws FeedNotFoundException {
		Roar roar = new Roar();
		roar.setAuthor(auth);
		roar.setText(txt);
		roar.setCreationDate(new Date());
		entityManager.persist(roar);
	}

	@Override
	public Roar getRoar(int roarId) throws RoarNotFoundException {
		Roar roar = entityManager.find(Roar.class, roarId);
		if(roar != null){
			return roar;
		}else{
			throw new RoarNotFoundException("Roar mit der id: " + roarId +" nicht gefunden!");
		}
	}

	@Override
	public void updateRoar(int roarId, String roarText) throws RoarNotFoundException {
		// TODO Auto-generated method stub
		Roar roar = getRoar(roarId);
		if(roar != null){
			roar.setText(roarText);
			roar.setCreationDate(new Date());
			entityManager.merge(roar);
		}else{
			throw new RoarNotFoundException("Roar mit der id: " + roarId +" nicht gefunden!");
		}
	}

	@Override
	public void deleteRoar(int roarId) throws RoarNotFoundException {
		// TODO Auto-generated method stub
		Roar roar = entityManager.find(Roar.class, roarId);
		if(roar != null){
			entityManager.remove(roar);
		}else{
			throw new RoarNotFoundException("Roar mit der id: " + roarId +" nicht gefunden!");
		}
	}

	@Override
	public List<Roar> getAllRoars(int feedId) throws FeedNotFoundException {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT roars FROM roars");
		List<Roar> roars = query.getResultList();
		return roars;
//		return null;
	}

}

// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import ee.itcollege.jejee.entities.Vahtkond_intsidendis;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Vahtkond_intsidendis_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Vahtkond_intsidendis.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer Vahtkond_intsidendis.version;
    
    public Integer Vahtkond_intsidendis.getVersion() {
        return this.version;
    }
    
    public void Vahtkond_intsidendis.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Vahtkond_intsidendis.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Vahtkond_intsidendis.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Vahtkond_intsidendis attached = Vahtkond_intsidendis.findVahtkond_intsidendis(this.piirivalvur_intsidendis_ID);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Vahtkond_intsidendis.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Vahtkond_intsidendis.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Vahtkond_intsidendis Vahtkond_intsidendis.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Vahtkond_intsidendis merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Vahtkond_intsidendis.entityManager() {
        EntityManager em = new Vahtkond_intsidendis().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Vahtkond_intsidendis.countVahtkond_intsidendises() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Vahtkond_intsidendis o", Long.class).getSingleResult();
    }
    
    public static List<Vahtkond_intsidendis> Vahtkond_intsidendis.findAllVahtkond_intsidendises() {
        return entityManager().createQuery("SELECT o FROM Vahtkond_intsidendis o", Vahtkond_intsidendis.class).getResultList();
    }
    
    public static Vahtkond_intsidendis Vahtkond_intsidendis.findVahtkond_intsidendis(Long piirivalvur_intsidendis_ID) {
        if (piirivalvur_intsidendis_ID == null) return null;
        return entityManager().find(Vahtkond_intsidendis.class, piirivalvur_intsidendis_ID);
    }
    
    public static List<Vahtkond_intsidendis> Vahtkond_intsidendis.findVahtkond_intsidendisEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Vahtkond_intsidendis o", Vahtkond_intsidendis.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
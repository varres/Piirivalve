// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.jejee.entities;

import ee.itcollege.jejee.entities.Riigi_admin_yksuse_liik;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Riigi_admin_yksuse_liik_Roo_Entity {
    
    @Version
    @Column(name = "version")
    private Integer Riigi_admin_yksuse_liik.version;
    
    public Integer Riigi_admin_yksuse_liik.getVersion() {
        return this.version;
    }
    
    public void Riigi_admin_yksuse_liik.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Riigi_admin_yksuse_liik.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Riigi_admin_yksuse_liik attached = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Riigi_admin_yksuse_liik.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Riigi_admin_yksuse_liik.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Riigi_admin_yksuse_liik Riigi_admin_yksuse_liik.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Riigi_admin_yksuse_liik merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static long Riigi_admin_yksuse_liik.countRiigi_admin_yksuse_liiks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Riigi_admin_yksuse_liik o", Long.class).getSingleResult();
    }
    
    public static List<Riigi_admin_yksuse_liik> Riigi_admin_yksuse_liik.findAllRiigi_admin_yksuse_liiks() {
        return entityManager().createQuery("SELECT o FROM Riigi_admin_yksuse_liik o", Riigi_admin_yksuse_liik.class).getResultList();
    }
    
    public static Riigi_admin_yksuse_liik Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(Long id) {
        if (id == null) return null;
        return entityManager().find(Riigi_admin_yksuse_liik.class, id);
    }
    
    public static List<Riigi_admin_yksuse_liik> Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liikEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Riigi_admin_yksuse_liik o", Riigi_admin_yksuse_liik.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}

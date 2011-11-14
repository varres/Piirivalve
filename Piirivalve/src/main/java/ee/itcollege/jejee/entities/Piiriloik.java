package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.jejee.entities.Intsident;
import java.util.Collection;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Piiriloik implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long piiriloik_ID;
	private String avaja;
	private Date avatud;
	private String muutja;
	private Date muudetud;
	private String sulgeja;
	private Date suletud;
	private String kood;
	private String nimetus;
	private String GPS_koordinaadid;
	private String kommentaar;

	@OneToMany(mappedBy = "piiriloik")
	private Collection<Intsident> intsident;
	
	public Long getPiiriloik_ID() {
		return piiriloik_ID;
	}
	public void setPiiriloik_ID(Long piiriloik_ID) {
		this.piiriloik_ID = piiriloik_ID;
	}
	public String getAvaja() {
		return avaja;
	}
	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}
	public Date getAvatud() {
		return avatud;
	}
	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}
	public String getMuutja() {
		return muutja;
	}
	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}
	public Date getMuudetud() {
		return muudetud;
	}
	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}
	public String getSulgeja() {
		return sulgeja;
	}
	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}
	public Date getSuletud() {
		return suletud;
	}
	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}
	public String getKood() {
		return kood;
	}
	public void setKood(String kood) {
		this.kood = kood;
	}
	public String getNimetus() {
		return nimetus;
	}
	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public String getGPS_koordinaadid() {
		return GPS_koordinaadid;
	}
	public void setGPS_koordinaadid(String gPS_koordinaadid) {
		GPS_koordinaadid = gPS_koordinaadid;
	}
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	public Collection<Intsident> getIntsident() {
	    return intsident;
	}
	public void setIntsident(Collection<Intsident> param) {
	    this.intsident = param;
	}
	
}
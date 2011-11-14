package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Vahtkond
 *
 */
@Entity
@RooEntity
@RooToString
public class Vahtkond implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long vahtkond_ID;
	private String kood;
	private String nimetus;
	private ee.itcollege.jejee.entities.Vaeosa vaeosa_ID;
	private ee.itcollege.jejee.entities.Piiripunkt piiripunkt_ID;
	private Date alates;
	private Date kuni;
	private String avaja;
	private Date avatud;
	private String sulgeja;
	private Date suletud;
	private String muutja;
	private Date muudetud;
	private String kommentaar;
	private static final long serialVersionUID = 1L;

	public Vahtkond() {
		super();
	}

	public Long getVahtkond_ID() {
		return vahtkond_ID;
	}

	public void setVahtkond_ID(Long vahtkond_ID) {
		this.vahtkond_ID = vahtkond_ID;
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

	public ee.itcollege.jejee.entities.Vaeosa getVaeosa_ID() {
		return vaeosa_ID;
	}

	public void setVaeosa_ID(ee.itcollege.jejee.entities.Vaeosa vaeosa_ID) {
		this.vaeosa_ID = vaeosa_ID;
	}

	public ee.itcollege.jejee.entities.Piiripunkt getPiiripunkt_ID() {
		return piiripunkt_ID;
	}

	public void setPiiripunkt_ID(
			ee.itcollege.jejee.entities.Piiripunkt piiripunkt_ID) {
		this.piiripunkt_ID = piiripunkt_ID;
	}

	public Date getAlates() {
		return alates;
	}

	public void setAlates(Date alates) {
		this.alates = alates;
	}

	public Date getKuni() {
		return kuni;
	}

	public void setKuni(Date kuni) {
		this.kuni = kuni;
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

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

   
}
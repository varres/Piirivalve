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
 * Entity implementation class for Entity: Seadus
 *
 */
@Entity
@RooEntity
@RooToString
public class Seadus implements Serializable {

	@GeneratedValue(strategy = GenerationType.AUTO)   
	@Id
	private Long seadus_ID;
	private String kood;
	private String nimetus;
	private String kehtiv_alates;
	private String kehtiv_kuni;
	private String avaja;
	private Date avatud;
	private String sulgeja;
	private Date suletud;
	private String muutja;
	private Date muudetud;
	private String kommentaar;
	private static final long serialVersionUID = 1L;

	public Seadus() {
		super();
	}

	public Long getSeadus_ID() {
		return seadus_ID;
	}

	public void setSeadus_ID(Long seadus_ID) {
		this.seadus_ID = seadus_ID;
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

	public String getKehtiv_alates() {
		return kehtiv_alates;
	}

	public void setKehtiv_alates(String kehtiv_alates) {
		this.kehtiv_alates = kehtiv_alates;
	}

	public String getKehtiv_kuni() {
		return kehtiv_kuni;
	}

	public void setKehtiv_kuni(String kehtiv_kuni) {
		this.kehtiv_kuni = kehtiv_kuni;
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

	public void test(){
		
	}
	
}
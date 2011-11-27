package ee.itcollege.jejee.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEntity
@Entity
public class Intsident implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long intsident_ID;
	@NotNull
	private String avaja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date avatud;
	@NotNull
	private String muutja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date muudetud;
	private String sulgeja;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date suletud;
	private String kood;
	private String nimetus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toimumise_algus;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toimumise_lopp;
	private String kirjeldus;
	private String kommentaar;
	private String GPS_longituud;
	private String GPS_latituud;

	@ManyToOne
	private Piiriloik piiriloik;

	@NotNull
	@ManyToOne
	private Intsidendi_liik intsidendi_liik;

	@OneToMany(mappedBy = "intsident")
	private Collection<Objekt_intsidendis> objekt_intsidendis;

	@OneToMany(mappedBy = "intsident")
	private Collection<Isik_intsidendis> isik_intsidendis;
	
	@OneToMany(mappedBy = "intsident")
	private Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis;
	
	@OneToMany(mappedBy = "intsident")
	private Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis;

	
	public Long getIntsident_ID() {
		return intsident_ID;
	}

	public void setIntsident_ID(Long intsident_ID) {
		this.intsident_ID = intsident_ID;
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

	public Date getToimumise_algus() {
		return toimumise_algus;
	}

	public void setToimumise_algus(Date toimumise_algus) {
		this.toimumise_algus = toimumise_algus;
	}

	public Date getToimumise_lopp() {
		return toimumise_lopp;
	}

	public void setToimumise_lopp(Date toimumise_lopp) {
		this.toimumise_lopp = toimumise_lopp;
	}

	public String getKirjeldus() {
		return kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}

	public String getKommentaar() {
		return kommentaar;
	}

	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}

	public String getGPS_longituud() {
		return GPS_longituud;
	}

	public void setGPS_longituud(String gPS_longituud) {
		GPS_longituud = gPS_longituud;
	}

	public String getGPS_latituud() {
		return GPS_latituud;
	}

	public void setGPS_latituud(String gPS_latituud) {
		GPS_latituud = gPS_latituud;
	}

	public void setPiiriloik(Piiriloik param) {
		this.piiriloik = param;
	}

	public Piiriloik getPiiriloik() {
		return piiriloik;
	}

	public void setIntsidendi_liik(Intsidendi_liik param) {
		this.intsidendi_liik = param;
	}

	public Intsidendi_liik getIntsidendi_liik() {
		return intsidendi_liik;
	}

	public Collection<Objekt_intsidendis> getObjekt_intsidendis() {
	    return objekt_intsidendis;
	}

	public void setObjekt_intsidendis(Collection<Objekt_intsidendis> param) {
	    this.objekt_intsidendis = param;
	}

	public Collection<Isik_intsidendis> getIsik_intsidendis() {
	    return isik_intsidendis;
	}

	public void setIsik_intsidendis(Collection<Isik_intsidendis> param) {
	    this.isik_intsidendis = param;
	}

	public Collection<Vahtkond_intsidendis> getVahtkonnad_intsidendis() {
		return vahtkonnad_intsidendis;
	}

	public void setVahtkonnad_intsidendis(Collection<Vahtkond_intsidendis> vahtkonnad_intsidendis) {
		this.vahtkonnad_intsidendis = vahtkonnad_intsidendis;
	}

	public Collection<Piirivalvur_intsidendis> getPiirivalvurid_intsidendis() {
		return piirivalvurid_intsidendis;
	}

	public void setPiirivalvurid_intsidendis(Collection<Piirivalvur_intsidendis> piirivalvurid_intsidendis) {
		this.piirivalvurid_intsidendis = piirivalvurid_intsidendis;
	}

}

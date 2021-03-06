package ee.itcollege.jejee.web;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.jejee.entities.BaseEntity;
import ee.itcollege.jejee.entities.Piirivalvur;
import ee.itcollege.jejee.entities.Piirivalvur_intsidendis;
import ee.itcollege.jejee.entities.Piirivalvuri_seadus_intsidendi;
import ee.itcollege.jejee.entities.Seaduse_punkt;

@RequestMapping("/detail")
@Controller
public class IntsidendidPiiriloigulDetailController {

	@Autowired
    private IntsidendidPiiriloigulDetailValidation ipdv;

    public void setRegistrationValidation(IntsidendidPiiriloigulDetailValidation ipdv) {
            this.ipdv = ipdv;
    }

	@PersistenceContext
	EntityManager entityManager;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String redirect(@PathVariable("id") Long id, Model uiModel) {
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		uiModel.addAttribute("pints", p_ints);

		return "redirect:/detail/1/p/1";
	}

	@RequestMapping(value = "/{id}/p/{p_id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel) throws CloneNotSupportedException {	
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		List<Piirivalvuri_seadus_intsidendi> psi_list = Piirivalvuri_seadus_intsidendi.findAllPSIForPiirivalvurIntsidendis(p_ints);
		Piirivalvur_intsidendis tmp = (Piirivalvur_intsidendis) p_ints.clone();
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		uiModel.addAttribute("psi", psi_list);
		uiModel.addAttribute("piirivalvur_intsidendis", tmp);

		return "intsidendid_piiriloigul_detail/detail";
	}
	
	@RequestMapping(value = "/{id}/p/{p_id}/lisa_seadus", method = RequestMethod.GET)
    public String lisaSeadus(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel) throws CloneNotSupportedException {	
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("sp", Seaduse_punkt.findAllSeadusePunktsWithout2(p_ints));
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);

		return "intsidendid_piiriloigul_detail/vali_seadus";
	}
	
	@RequestMapping(value = "/{id}/p/{p_id}/lisa_seadus", params="valik", method = RequestMethod.GET)
    public String lisaSeadusCheckboxes(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, @RequestParam String valik, Model uiModel) throws CloneNotSupportedException {	
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("sp", Seaduse_punkt.findAllSeadusePunktsWithout2(p_ints));
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		
		if(valik.length()>1){
			for (String s : valik.split(",")) {
				sisestaUusSeadus(Long.parseLong(s), p_ints);			
			}
			return "redirect:/detail/"+id+"/p/"+p_id;
		}
		
		if(valik.length()==1){
			sisestaUusSeadus(Long.parseLong(valik), p_ints);
			return "redirect:/detail/"+id+"/p/"+p_id;
		}
		
		return "intsidendid_piiriloigul_detail/vali_seadus";
	}

	private void sisestaUusSeadus(Long ID, Piirivalvur_intsidendis p_ints) {
		Piirivalvuri_seadus_intsidendi psi = new Piirivalvuri_seadus_intsidendi();
		psi.setAlates(new Date());
		psi.setKuni(BaseEntity.SURROGATE_DATE);
		psi.setAvaja(p_ints.getAvaja());
		psi.setAvatud(new Date());
		psi.setMuutja(p_ints.getMuutja());
		psi.setMuudetud(p_ints.getMuudetud());
		psi.setSulgeja(p_ints.getSulgeja());
		psi.setSuletud(BaseEntity.SURROGATE_DATE);
		psi.setPiirivalvur_intsidendis(p_ints);
		psi.setSeaduse_punkt(Seaduse_punkt.findSeaduse_punkt(ID));
		psi.persist();
	}

	@RequestMapping(value = "/{id}/p/{p_id}/vaata_seadus/{s_id}", method = RequestMethod.GET)
    public String vaataSeadus(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, @PathVariable("s_id") Long s_id, Model uiModel) {	
		uiModel.addAttribute("sp", Seaduse_punkt.findSeaduse_punkt(s_id));

		return "intsidendid_piiriloigul_detail/vaata_seadus";
	}
	
	@RequestMapping(value = "/{id}/p/{p_id}/eemalda_seadus/{psi_id}", method = RequestMethod.GET)
    public String eemaldaSeadus(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, @PathVariable("psi_id") Long psi_id, Model uiModel) {	
		Piirivalvuri_seadus_intsidendi psi = Piirivalvuri_seadus_intsidendi.findPiirivalvuri_seadus_intsidendi(psi_id);
		psi.setSuletud(new Date());
		psi.merge();
		
		return "redirect:/detail/"+id+"/p/"+p_id;
	}
	
	
	@RequestMapping(value = "/{id}/p/{p_id}/muuda", method = RequestMethod.POST)
    public String muuda(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, HttpServletRequest httpServletRequest, Model uiModel,Piirivalvur_intsidendis tmp, BindingResult result) throws CloneNotSupportedException {	
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);

		Long count = (long) 1;

		ipdv.validate(tmp, result);
        if (result.hasErrors()) {     
        	return "intsidendid_piiriloigul_detail/detail";
        }
        else{
        	if(p_ints.getPiirivalvur().getId()==p_id){ //on algne piirivalvur
        		p_ints.setKirjeldus(tmp.getKirjeldus());
        		p_ints.setKommentaar(tmp.getKommentaar());
        		p_ints.merge();
        		return "redirect:/detail/"+id+"/p/"+p_id;
        	}
        	else{ //uus piirivalvur on valitud
        		//Piirivalvur_intsidendis pi = (Piirivalvur_intsidendis) p_ints.clone();
        		Piirivalvur_intsidendis pi = new Piirivalvur_intsidendis();
        		Piirivalvur uus_piirivalvur = Piirivalvur.findPiirivalvur(p_id);
        		pi.setAlates(p_ints.getAlates());
        		pi.setAvaja(p_ints.getAvaja());
        		pi.setAvatud(p_ints.getAvatud());
        		pi.setIntsident(p_ints.getIntsident());
        		pi.setKirjeldus(tmp.getKirjeldus());
        		pi.setKommentaar(tmp.getKommentaar());
        		pi.setKuni(p_ints.getKuni());
        		pi.setMuudetud(p_ints.getMuudetud());
        		pi.setMuutja(p_ints.getMuutja());
        		pi.setPiirivalvur(uus_piirivalvur);
        		pi.setSuletud(p_ints.getSuletud());
        		pi.setSulgeja(p_ints.getSulgeja());
        		pi.setVahtkond_intsidendis(p_ints.getVahtkond_intsidendis());
        		pi.setVersion(p_ints.getVersion());
        		pi.persist();
        		
        		count = pi.getId();
        		
        		p_ints.setSuletud(new Date()); //eelmise intsidendi sulgemine
        		p_ints.merge();
        		return "redirect:/detail/"+count+"/p/"+p_id;
        	}
        	
        }

	}

	@RequestMapping(value = "/{id}/p/{p_id}/muuda_piirivalvur", method = RequestMethod.GET)
    public String vali_piirivalvur(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel) {
		Piirivalvur_intsidendis p_ints = Piirivalvur_intsidendis.findPiirivalvur_intsidendis(id);
		Piirivalvur pvalvur = Piirivalvur.findPiirivalvur(p_id);
		uiModel.addAttribute("pvalvur", pvalvur);
		uiModel.addAttribute("pints", p_ints);
		uiModel.addAttribute("piirivalvurid", Piirivalvur.findAllPiirivalvuridExceptFor(pvalvur));

		return "intsidendid_piiriloigul_detail/vali_piirivalvur";
	}


	@RequestMapping(value = "/{id}/p/{p_id}/muuda_piirivalvur", params="valik", method = RequestMethod.GET)
    public String showPiirivalvurSelected(@PathVariable("id") Long id, @PathVariable("p_id") Long p_id, Model uiModel, @RequestParam Long valik) {	
		return "redirect:/detail/"+id+"/p/"+valik;
	}

}
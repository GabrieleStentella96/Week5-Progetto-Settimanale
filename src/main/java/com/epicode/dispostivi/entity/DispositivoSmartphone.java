package com.epicode.dispostivi.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "smartphones")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoSmartphone extends Dispositivi {
	
	
	private String nummero;

//	public SmartPhone() {
//		// TODO Auto-generated constructor stub
//	}

//	public SmartPhone(Long id, Integer schermo, String marca, TipoStato tipoStato) {
//		super(id, schermo, marca, tipoStato);
//		// TODO Auto-generated constructor stub
//	}

}

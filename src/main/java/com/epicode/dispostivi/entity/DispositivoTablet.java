package com.epicode.dispostivi.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tablets")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoTablet extends Dispositivi {
	
	private boolean withKeyboard;

//	public Tablet() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Tablet(Long id, Integer schermo, String marca, TipoStato tipoStato) {
//		super(id, schermo, marca, tipoStato);
//		// TODO Auto-generated constructor stub
//	}

}

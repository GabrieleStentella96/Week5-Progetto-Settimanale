package com.epicode.dispostivi.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dispositivi")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Dispositivi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer schermo;
	private String marca;
	private TipoStato tipoStato;

}

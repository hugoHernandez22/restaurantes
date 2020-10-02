package net.restaurante.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "restaurante")
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID; 
	private String NOMBRE; 
	private String DIRECCION; 
	private String TELEFONO; 
	private long ESTADO; 
	private int USER_ADD;
	private Date FECHA_C;
	private int USER_U;
	private Date FECHA_U;
	
	
	public Restaurante() {
		super();
	}
	public Restaurante(String nOMBRE, String dIRECCION, String tELEFONO, long eSTADO, int uSER_ADD, Date fECHA_C,
			int uSER_U, Date fECHA_U) {
		super();
		NOMBRE = nOMBRE;
		DIRECCION = dIRECCION;
		TELEFONO = tELEFONO;
		ESTADO = eSTADO;
		USER_ADD = uSER_ADD;
		FECHA_C = fECHA_C;
		USER_U = uSER_U;
		FECHA_U = fECHA_U;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public String getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public long getESTADO() {
		return ESTADO;
	}
	public void setESTADO(long eSTADO) {
		ESTADO = eSTADO;
	}
	public int getUSER_ADD() {
		return USER_ADD;
	}
	public void setUSER_ADD(int uSER_ADD) {
		USER_ADD = uSER_ADD;
	}
	public Date getFECHA_C() {
		return FECHA_C;
	}
	public void setFECHA_C(Date fECHA_C) {
		FECHA_C = fECHA_C;
	}
	public int getUSER_U() {
		return USER_U;
	}
	public void setUSER_U(int uSER_U) {
		USER_U = uSER_U;
	}
	public Date getFECHA_U() {
		return FECHA_U;
	}
	public void setFECHA_U(Date fECHA_U) {
		FECHA_U = fECHA_U;
	}
	
	

}

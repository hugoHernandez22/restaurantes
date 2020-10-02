package net.restaurante.springboot.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private int CUI;
	private String NOMBRES;
	private String APELLIDOS;
	private String DIRECCION;
	private String TELEFONO;
	private long TIPO;
	private long ESTADO;
	private int USER_ADD;
	private Date FECHA_C;
	
	
	
	public Empleado() {
		super();
	}
	public Empleado(int cUI, String nOMBRES, String aPELLIDOS, String dIRECCION, String tELEFONO, long tIPO,
			long eSTADO, int uSER_ADD, Date fECHA_C) {
		super();
		CUI = cUI;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		DIRECCION = dIRECCION;
		TELEFONO = tELEFONO;
		TIPO = tIPO;
		ESTADO = eSTADO;
		USER_ADD = uSER_ADD;
		FECHA_C = fECHA_C;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCUI() {
		return CUI;
	}
	public void setCUI(int cUI) {
		CUI = cUI;
	}
	public String getNOMBRES() {
		return NOMBRES;
	}
	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}
	public String getAPELLIDOS() {
		return APELLIDOS;
	}
	public void setAPELLIDOS(String aPELLIDOS) {
		APELLIDOS = aPELLIDOS;
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
	public long getTIPO() {
		return TIPO;
	}
	public void setTIPO(long tIPO) {
		TIPO = tIPO;
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
	
	
}

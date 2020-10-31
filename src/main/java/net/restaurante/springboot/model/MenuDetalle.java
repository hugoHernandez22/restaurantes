package net.restaurante.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_DETALLE")
public class MenuDetalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private int ID_MENU;
	private int ID_PRODUCTO;
	private long ESTADO;
	private int USER_ADD;
	private Date FECHA_C;
	private int USER_U;
	private Date FECHA_U;
	
	public MenuDetalle() {
		super();
	}
	
	
	public MenuDetalle(int iD_MENU, int iD_PRODUCTO, long eSTADO, int uSER_ADD, Date fECHA_C, int uSER_U,
			Date fECHA_U) {
		super();
		ID_MENU = iD_MENU;
		ID_PRODUCTO = iD_PRODUCTO;
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
	public int getID_MENU() {
		return ID_MENU;
	}
	public void setID_MENU(int iD_MENU) {
		ID_MENU = iD_MENU;
	}
	public int getID_PRODUCTO() {
		return ID_PRODUCTO;
	}
	public void setID_PRODUCTO(int iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
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

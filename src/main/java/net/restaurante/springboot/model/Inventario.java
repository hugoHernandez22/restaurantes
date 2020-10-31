package net.restaurante.springboot.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTARIO")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_INVENTARIO;
	private int PRODUCTO;
	private float CANTIDAD; 
	private float PRECIO;
	private long INV_TYPE;
	private int ID_RESTAURANTE;
	private long ESTADO;
	private int USER_ADD;
	private Date FECHA_C;
	private int USER_U;
	private Date FECHA_U;
	public Inventario() {
		super();
	}
	public Inventario(int pRODUCTO, float cANTIDAD, float pRECIO, long iNV_TYPE, int iD_RESTAURANTE, long eSTADO,
			int uSER_ADD, Date fECHA_C, int uSER_U, Date fECHA_U) {
		super();
		PRODUCTO = pRODUCTO;
		CANTIDAD = cANTIDAD;
		PRECIO = pRECIO;
		INV_TYPE = iNV_TYPE;
		ID_RESTAURANTE = iD_RESTAURANTE;
		ESTADO = eSTADO;
		USER_ADD = uSER_ADD;
		FECHA_C = fECHA_C;
		USER_U = uSER_U;
		FECHA_U = fECHA_U;
	}
	public int getID_INVENTARIO() {
		return ID_INVENTARIO;
	}
	public void setID_INVENTARIO(int iD_INVENTARIO) {
		ID_INVENTARIO = iD_INVENTARIO;
	}
	public int getPRODUCTO() {
		return PRODUCTO;
	}
	public void setPRODUCTO(int pRODUCTO) {
		PRODUCTO = pRODUCTO;
	}
	public float getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCANTIDAD(float cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}
	public float getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(float pRECIO) {
		PRECIO = pRECIO;
	}
	public long getINV_TYPE() {
		return INV_TYPE;
	}
	public void setINV_TYPE(long iNV_TYPE) {
		INV_TYPE = iNV_TYPE;
	}
	public int getID_RESTAURANTE() {
		return ID_RESTAURANTE;
	}
	public void setID_RESTAURANTE(int iD_RESTAURANTE) {
		ID_RESTAURANTE = iD_RESTAURANTE;
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

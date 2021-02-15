package br.com.assesso.dcsecurity.saml.entity;

import java.io.Serializable;
import java.util.Arrays;

public class SecUserAppPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private byte[] idRole;
	private byte[] idUser;
	private long versao;
  private byte[] idApp;
  private int idProduct;

    public byte[] getIdUser() {
        return idUser;
    }

    public void setIdUser(byte[] idUser) {
        this.idUser = idUser;
    }

    public byte[] getIdApp() {
        return idApp;
    }

    public void setIdApp(byte[] idApp) {
        this.idApp = idApp;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public byte[] getIdRole() {
			return idRole;
		}

		public void setIdRole(byte[] idRole) {
			this.idRole = idRole;
		}

		public long getVersao() {
			return versao;
		}

		public void setVersao(long versao) {
			this.versao = versao;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(idApp);
			result = prime * result + idProduct;
			result = prime * result + Arrays.hashCode(idRole);
			result = prime * result + Arrays.hashCode(idUser);
			result = prime * result + (int) (versao ^ (versao >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SecUserAppPK other = (SecUserAppPK) obj;
			if (!Arrays.equals(idApp, other.idApp))
				return false;
			if (idProduct != other.idProduct)
				return false;
			if (!Arrays.equals(idRole, other.idRole))
				return false;
			if (!Arrays.equals(idUser, other.idUser))
				return false;
			if (versao != other.versao)
				return false;
			return true;
		}

	
}

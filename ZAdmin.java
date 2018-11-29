public class ZAdmin extends ZPlayer{
	private boolean isAdmin;
	
	ZAdmin(){
		this.setUsername("admin");
		this.setPassword("admin");
		this.isAdmin = true;
	}
	
	public boolean getIsAdmin(){
		return this.isAdmin;
	}

}

package fr.tsg.object;

public class Player {
	public Pions pion;
	int p;
	int points;
	    
	public Player(int points){
	        this.points = points;
	}
	
	
	
	
	public int getPoint(){
        return p;
    }

	public Pions getPion() {
		return pion;
	}

	public void setPion(Pions pion) {
		this.pion = pion;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}

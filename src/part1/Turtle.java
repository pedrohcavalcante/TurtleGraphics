package part1;

public class Turtle {
	private String head, l_hand, r_hand, tail, shell, belly; 
	private int posX, posY, posZ;
	
	public Turtle(){
		this.posX = 0;
		this.posY = 0;
		this.posZ = 0;
		head = "+x";
		tail = "-x";
		shell = "+z";
		belly = "-z";
		l_hand = "+y";
		r_hand = "-y";
	}
	
	public void moveFoward(){
		if (head.equals("+x")){
			this.posX += 1;
		}else if(head.equals("-x")){
			this.posX -= 1;
		}else if(head.equals("+z")){
			this.posZ += 1;
		}else if(head.equals("-z")){
			this.posZ -= 1;
		}else if(head.equals("+y")){
			this.posY += 1;
		}else if(head.equals("-y")){
			this.posY -= 1;
		}else{
			System.out.println("ERROR");
		}
	}
	
	public void turn(String letter){
		String aux;
		if (letter.equals("U") || letter.equals("u")){
			aux = head;
			head = shell; 
			shell = tail; 
			tail = belly; 
			belly = aux;
		}else if (letter.equals("D") || letter.equals("d")){
			aux = head; 
			head = belly; 
			belly = tail; 
			tail = shell; 
			shell = aux; 
		}else if (letter.equals("L") || letter.equals("l")){
			aux = head; 
			head = l_hand;
			l_hand = tail; 
			tail = r_hand;
			r_hand = aux;
		}else if (letter.equals("R") || letter.equals("r")){
			aux = head; 
			head = r_hand;
			r_hand = tail;
			tail = l_hand;
			l_hand = aux;
		}

	}

	public void checkOrientation() {
        System.out.println("Current orientation:");
        System.out.println("\tHead: " + head);
        System.out.println("\tTail: " + tail);
        System.out.println("\tShell: " + shell);
        System.out.println("\tBelly: " + belly);
        System.out.println("\tLeft side: " + l_hand);
        System.out.println("\tRight side: " + r_hand);
    }

    public void checkPosition() {
    	System.out.println("Current position:");
    	System.out.println("(" + posX + ", " + posY + ", " + posZ + ")");
    	System.out.println("");
}
    
    public void distEuclid(){
    	double dist = Math.sqrt(Math.pow(posX, 2) + 
    			Math.pow(posY, 2) + Math.pow(posZ, 2));
    	System.out.println(dist);
    	
    }

    public void move_str(String var){
    	String temp;
    	for (int i = 0; i < var.length(); i++){
    		temp = Character.toString(var.charAt(i));
    		if (temp.equals("F") || temp.equals("f")){
    			moveFoward();
    		}else{
    			turn(temp);
    		}
    	}
    }
    
}


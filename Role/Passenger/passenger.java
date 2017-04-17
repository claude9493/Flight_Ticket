package Passenger;

class passenger {
	
	static final int MAXLEN = 100;
	Passenger_ind[] PassengerList = new Passenger_ind[MAXLEN+1];
	int ListLen;
	
	void Inint(passenger PL){
		this.ListLen = 0;
	}
	
	int passengerLength(passenger PL){
		return PL.ListLen;
				
	}
	
	int PLAdd(passenger PL, Passenger_ind new_passenger){
		if(PL.ListLen>=MAXLEN){
			System.out.print("No more space");
			return 0;
		}
		PL.PassengerList[++PL.ListLen] = new_passenger;
		return 1;
	}
	
	int PLDelete(passenger PL, int n){
		int i;
		if(n < 1|| n > PL.ListLen+1){
			System.out.print("Wrong index.");
			return 0;
		}
		for (i = n; i < PL.ListLen; i ++){
			PL.PassengerList[i] = PL.PassengerList[i+1];
		}
		
		PL.ListLen--;
		return 1;
	}
	
	
	
	
}

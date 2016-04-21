package modelLayer;

public class MdlRoom {

	private int roomNumber;
	private int capacity;
	
	public MdlRoom(){
		
	}
	
	public MdlRoom(int roomNumber, int capacity){
		
		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}

	public int getRoomNumber() {
		return roomNumber;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}

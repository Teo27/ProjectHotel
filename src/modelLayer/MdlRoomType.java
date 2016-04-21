package modelLayer;

public class MdlRoomType {

	private String typeName;
	private float price;
	private int capacity;
	
	public MdlRoomType(){
		
	}
	
	public MdlRoomType(String typeName, float price, int capacity){
		
		this.typeName = typeName;
		this.price = price;
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getTypeName() {
		return typeName;
	}

	public float getPrice() {
		return price;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

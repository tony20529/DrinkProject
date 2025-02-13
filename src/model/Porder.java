package model;

public class Porder {
	private Integer id;
	private String time;
	private String name;
	private String username;
	private Integer pearlmilktea;
	private Integer duoduogreentea;
	private Integer milkcoveredgreentea;
	private Integer coffee;
	private Integer pearlmilk;
	private String message;
	private String seller;
	public Porder( String name, String username, Integer pearlmilktea, Integer duoduogreentea,
			Integer milkcoveredgreentea, Integer coffee, Integer pearlmilk, String time) {
		super();
		this.name = name;
		this.username = username;
		this.pearlmilktea = pearlmilktea;
		this.duoduogreentea = duoduogreentea;
		this.milkcoveredgreentea = milkcoveredgreentea;
		this.coffee = coffee;
		this.pearlmilk = pearlmilk;
		this.time=time;
	}
	
	public Porder( String name, String username, Integer pearlmilktea, Integer duoduogreentea,
			Integer milkcoveredgreentea, Integer coffee, Integer pearlmilk, String time, String message) {
		super();
		
		this.name = name;
		this.username = username;
		this.pearlmilktea = pearlmilktea;
		this.duoduogreentea = duoduogreentea;
		this.milkcoveredgreentea = milkcoveredgreentea;
		this.coffee = coffee;
		this.pearlmilk = pearlmilk;
		this.time=time;
		this.message = message;
	}
	
	public Porder(String seller) {
		super();
		this.seller = seller;
	}

	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPearlmilktea() {
		return pearlmilktea;
	}
	public void setPearlmilktea(Integer pearlmilktea) {
		this.pearlmilktea = pearlmilktea;
	}
	public Integer getDuoduogreentea() {
		return duoduogreentea;
	}
	public void setDuoduogreentea(Integer duoduogreentea) {
		this.duoduogreentea = duoduogreentea;
	}
	public Integer getMilkcoveredgreentea() {
		return milkcoveredgreentea;
	}
	public void setMilkcoveredgreentea(Integer milkcoveredgreentea) {
		this.milkcoveredgreentea = milkcoveredgreentea;
	}
	public Integer getCoffee() {
		return coffee;
	}
	public void setCoffee(Integer coffee) {
		this.coffee = coffee;
	}
	public Integer getPearlmilk() {
		return pearlmilk;
	}
	public void setPearlmilk(Integer pearlmilk) {
		this.pearlmilk = pearlmilk;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	
}

package springboot.entity;

public class BookType {
	private Integer id;
	private String typeName;
	private Integer days;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "BookType [id=" + id + ", typeName=" + typeName + ", days=" + days + "]";
	}
	public BookType(Integer id, String typeName, Integer days) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.days = days;
	}
	public BookType() {
		super();
	}
	
}

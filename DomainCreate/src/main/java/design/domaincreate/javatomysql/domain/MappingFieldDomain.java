package design.domaincreate.javatomysql.domain;

public class MappingFieldDomain {
	String javaName;
	String javaType;
	String javaLength;
	String mysqlName;
	String mysqlType;
	String mysqlLength;
	boolean mysqlPrimaryKey = false;
	boolean mysqlNotNull = false;
	boolean mysqlAutoIncrement = false;
	
	public MappingFieldDomain(String javaName, String javaType, String javaLength, String mysqlName, String mysqlType,
			String mysqlLength) {
		super();
		this.javaName = javaName;
		this.javaType = javaType;
		this.javaLength = javaLength;
		this.mysqlName = mysqlName;
		this.mysqlType = mysqlType;
		this.mysqlLength = mysqlLength;
	}
	public String getJavaName() {
		return javaName;
	}
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getJavaLength() {
		return javaLength;
	}
	public void setJavaLength(String javaLength) {
		this.javaLength = javaLength;
	}
	public String getMysqlName() {
		return mysqlName;
	}
	public void setMysqlName(String mysqlName) {
		this.mysqlName = mysqlName;
	}
	public String getMysqlType() {
		return mysqlType;
	}
	public void setMysqlType(String mysqlType) {
		this.mysqlType = mysqlType;
	}
	public String getMysqlLength() {
		return mysqlLength;
	}
	public void setMysqlLength(String mysqlLength) {
		this.mysqlLength = mysqlLength;
	}
	public boolean isMysqlNotNull() {
		return mysqlNotNull;
	}
	public void setMysqlNotNull(boolean mysqlNotNull) {
		this.mysqlNotNull = mysqlNotNull;
	}
	public boolean isMysqlAutoIncrement() {
		return mysqlAutoIncrement;
	}
	public boolean isMysqlPrimaryKey() {
		return mysqlPrimaryKey;
	}
	public void setMysqlPrimaryKey(boolean mysqlPrimaryKey) {
		this.mysqlPrimaryKey = mysqlPrimaryKey;
	}
	public void setMysqlAutoIncrement(boolean mysqlAutoIncrement) {
		this.mysqlAutoIncrement = mysqlAutoIncrement;
	}
}

package design.domaincreate.util;

public class MappingUtil {

	public static String changeJavaTypeToMysqlType(String javaType) {
		String mysqlType = null;
		if(javaType.equals("String")){
			mysqlType = "VARCHAR";
		}
		if(javaType.equals("int")){
			mysqlType = "INT";
		}
		if(javaType.equals("Date")){
			mysqlType = "DATE";
		}
		if(javaType.equals("Timestamp")){
			mysqlType = "DATETIME";
		}
		if(javaType.equals("double")){
			mysqlType = "DOUBLE";
		}
		if(javaType.equals("float")){
			mysqlType = "FLOAT";
		}
		if(javaType.equals("boolean")){
			mysqlType = "INT";
		}
		if(javaType.equals("byte[]")){
			mysqlType = "BLOB";
		}
		return mysqlType;
		
	}

}

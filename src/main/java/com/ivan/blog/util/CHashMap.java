package com.ivan.blog.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CHashMap extends HashMap<String, String> {
	
	public CHashMap()
	{
	}
	
	public CHashMap(HashMap<String, String> obj)
	{
		super(obj);
	}
	
	public String getString(String key)
	{
		return (String)this.get(key);
	}
	
	// mysql > joda time > mysql:DATETIME <- java.sql.Timestamp
	public Timestamp getMysqlDateTime(String key)
	{
		// 2013-11-15
		String dateTime = (String)this.get(key);
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime jodatime = dtf.parseDateTime(dateTime);
		
		return new Timestamp(jodatime.getMillis());
	}
	
	public int getInt(String key)
	{
		return new Integer((String)this.get(key)).intValue();
	}
	
	public Integer getIntObj(String key)
	{
		return new Integer((String)this.get(key));
	}
	
	public double getDouble(String key)
	{
		return new Double((String)this.get(key)).doubleValue();
	}
	
	public Double getDoubleObj(String key)
	{
		return new Double((String)this.get(key));
	}
	
	public long getLong(String key)
	{
		return new Long((String)this.get(key)).longValue();
	}
	
	public Long getLongObj(String key)
	{
		return new Long((String)this.get(key));
	}
	
	public float getFloat(String key)
	{
		return new Float((String)this.get(key)).floatValue();
	}
	
	public Float getFloatObj(String key)
	{
		return new Float((String)this.get(key));
	}
	
	public void print()
	{
		String key = "";
		String total = "";
		
		try
		{
			Iterator<String> iterator = (new HashSet<String>(this.keySet())).iterator();
			
			while(iterator.hasNext())
			{
				key = iterator.next();
				total = total + "[" + key + "] : " + "[" + this.getString(key) + "]\r\n";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
//			System.out.println("CHashMap : " + e.getMessage());
		}
		
//		System.out.println("CHashMap > print : " + total);
	}
}

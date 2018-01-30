package com.amaker.bean;

public class CollectionBean {
/*
 * 
  CREATE TABLE "XISHI"."COLLECTIONTBL" 
   (	"ID" NUMBER(11,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(50 BYTE), 
	"URL" VARCHAR2(100 BYTE), 
	 CONSTRAINT "COLLECTIONTBL_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "XSHOME"  ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "XSHOME" ;
 

 * */
	private int id;
	private String url;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

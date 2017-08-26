package com.realsun.webpos.model;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class BaseRecord extends DataSupport {
	@Column (ignore = true)
	public int _id=0;
	@Column (ignore = true)
	public String _state="added";
	@Column(unique = true )
	public long REC_ID;
	public long REC_RESID;
	 

}

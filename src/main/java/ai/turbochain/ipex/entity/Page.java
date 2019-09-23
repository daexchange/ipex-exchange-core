package ai.turbochain.ipex.entity;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

import lombok.Data;

@Data
public class Page implements Serializable{

	private static final long serialVersionUID = -5323599284385838198L;

	private Long currentPage;
	 
    private Long pageSize;
    
    private Long total;
    
    private Object data;
	
    @Override
    public String toString() {
        return  JSON.toJSONString(this);
    }
    public Page(){
    	super();
    }
    public Page(Long pageSize,Long total){
    	this.pageSize=pageSize;
    	this.total=total;
    }
}
